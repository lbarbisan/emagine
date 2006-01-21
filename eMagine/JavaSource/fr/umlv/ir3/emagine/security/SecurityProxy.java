package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

/**
 * 
 * @author aogier
 * 
 * @param <M>
 *            specifies the manager class used to base the rights on. The right
 *            annotations of <b>that interface</b> will be used to resolve the
 *            rights of the proxy.
 */
public class SecurityProxy<M extends BaseManager<E, D>, D extends BaseDAO<E>, E extends BaseEntity>
		implements InvocationHandler {
	private M proxifiedManager;

	private M proxy;

	private Class<?> rightsInterface;

	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(SecurityProxy.class);

	/**
	 * Build a proxy on the specified manager object
	 * 
	 * @param proxifiedManager
	 */
	@SuppressWarnings("unchecked")
	protected SecurityProxy(M object) {
		this.proxifiedManager = object;
		this.proxy = (M) Proxy.newProxyInstance(object.getClass()
				.getClassLoader(), object.getClass().getInterfaces(), this);
	}

	protected M getProxy() {
		return proxy;
	}

	/**
	 * Tries to invoke the specified method of the manager on which the proxy is
	 * attached. It tests if the current user has the correct rights, using the
	 * <code>SessionManager.isCurrentUserAllowedTo</code> method. The required
	 * rights are retrieved from the annotation on the class which name is based
	 * on the current name of the proxified object manager, without "Impl"
	 * suffix. If that classe declares <code>MustHaveRights("classRight")</code>
	 * annotation then, by default, a method <code>methodName</code> of that
	 * class will be invoked only if the current user has the right named
	 * "classRight.methodName". One can force specific rights method by applying
	 * a <code>MustHaveRights("methodRight")</code> annotation on the method.
	 * Then the method will be invoked only if the current user has the right
	 * named "methodRight".
	 * If it's an update method one wants to invoke, and the current user hasn't the required rights, then the method "updateWithoutRigths" is invoked instead.
	 * 
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object[])
	 * @throws SecurityFilterNotInitializedException
	 *             if the security filter has not been initialized and
	 *             "security.SecurityProxy.securityFilterRealm" key of
	 *             eMagine.properties file has not been set to "none" nor
	 *             "properties"
	 * @throws UserIsNotAllowed if the current user hasn't got any of the required rights
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
			// Retrieve the specified reference interface for rights for the
			// proxifiedManager in the proxy
			if (rightsInterface == null) {
				rightsInterface = proxifiedManager.getClass();
				String className = rightsInterface.getName();
				if (className.endsWith("Impl")) {
					// The specified object is an implementation of the
					// interface which owns the rights
					// Let's get that interface
					rightsInterface = Class.forName(className.substring(0,
							className.length() - 4));
				}
			}

			MustHaveRights methodRights = method
					.getAnnotation(MustHaveRights.class);
			MustHaveRights classRights = rightsInterface
					.getAnnotation(MustHaveRights.class);

			ArrayList<String> rightList = new ArrayList<String>();
			if (methodRights == null && classRights != null) {
				// Adds the class rights if no method rights are specified
				// The checked rights become : [class right].[methode name] for
				// each class right
				for (String classRight : classRights.value()) {
					rightList.add(classRight + "." + method.getName());
				}
			} else if (methodRights != null) {
				// Else, we take the rights as they are listed in the anotation
				// for that method
				for (String right : methodRights.value()) {
					rightList.add(right);
				}
			}

			SessionManager sessionManager = SessionManager.getInstance();

			if (!rightList.isEmpty()) {
				for (String right : rightList) {
					// Check if the current user has that right
					log.debug("Check if user '"
							+ sessionManager.getCurrentUser().getLogin()
							+ "' has right " + right);
					if (!sessionManager.isCurrentUserAllowedTo(right)) {
						if (method.getName().equals("update")) {
							// if it's an update method one wants to invoke, and the current user hasn't got the required rights, then the method "updateWithoutRigths" is invoked instead.
							Method updateWithoutRightsMethod = method
									.getDeclaringClass().getMethod(
											"updateWithoutRights",
											EditableEntity.class);
							if (updateWithoutRightsMethod != null) {
								return updateWithoutRightsMethod.invoke(
										proxifiedManager, args);
							}
						}
						throw new UserIsNotAllowed(right);
					}
				}
			} else {
				log.info("No right check for method "
						+ proxifiedManager.getClass().getName() + "."
						+ method.getName() + " (user : "
						+ sessionManager.getCurrentUser().getLogin() + ")");
			}
			return method.invoke(proxifiedManager, args);
		} catch (Exception e) {
			Throwable t = e;
			while (t != null && !(t instanceof EMagineException)
					&& t != t.getCause()) {
				t = t.getCause();
			}
			if (t != null) {
				throw t;
			} else {
				throw e;
			}
		}
	}

}
