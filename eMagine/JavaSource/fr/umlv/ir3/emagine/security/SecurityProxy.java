package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;
import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

/**
 * 
 * @author aogier
 *
 * @param <M> specifies the manager class used to base the rights on. The right annotations of <b>that interface</b> will be used to resolve the rights of the proxy.
 */
public class SecurityProxy<M extends BaseManager<E, D>, D extends BaseDAO<E>, E extends BaseEntity> implements InvocationHandler {
	protected SecurityRealmInterface realm;
	private M proxifiedManager;
	private M proxy;
	protected SessionManager sessionManager;
	private Class<?> rightsInterface;
	
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(SecurityProxy.class);

	
	/**
	 * 
	 * @param proxifiedManager
	 * @throws EMagineException if the security filter has not been initialized
	 */
	@SuppressWarnings("unchecked")
	protected SecurityProxy(M object) throws EMagineException {
		this.proxifiedManager = object;
		this.proxy = (M)Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}
	
	protected M getProxy() {
		return proxy;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
			// Retrieve the specified reference interface for rights for the proxifiedManager in the proxy
			if (rightsInterface == null) {
				rightsInterface = proxifiedManager.getClass();
				String className = rightsInterface.getName();
				if (className.endsWith("Impl")) {
					// The specified object is an implementation of the interface which owns the rights
					// Let's get that interface
					rightsInterface = Class.forName(className.substring(0, className.length() - 4));
				}
			}

			MustHaveRights methodRights = method.getAnnotation(MustHaveRights.class);
			MustHaveRights classRights = rightsInterface.getAnnotation(MustHaveRights.class);
	
			ArrayList<String> rightList = new ArrayList<String>();
			if (methodRights == null && classRights != null) {
				// Adds the class rights if no method rights are specified
				// The checked rights become : [class right].[methode name] for each class right
				for (String classRight : classRights.value()) {
					rightList.add(classRight+"."+method.getName());
				}
			} else if (methodRights != null) {
				// Else, we take the rights as they are listed in the anotation for that method
				for (String right : methodRights.value()) {
					rightList.add(right);
				}
			}
			
			if (!rightList.isEmpty()) {
				Principal currentPrincipal = sessionManager.getCurrentPrincipal();
				for (String right : rightList) {
					log.debug("Check if user '"+sessionManager.getCurrentUser().getLogin()+"' has right "+right);
					if (!realm.isUserInRole(currentPrincipal, right)) {
						if (method.getName().equals("update")) {
							Method updateWithoutRightsMethod = method.getDeclaringClass().getMethod("updateWithoutRights", EditableEntity.class);
							if (updateWithoutRightsMethod != null) {
								return updateWithoutRightsMethod.invoke(proxifiedManager, args);
							}
						}
						throw new EMagineException("exception.userIsNotAllowed", right);
					}
				}
			} else {
				log.info("No right check for method "+proxifiedManager.getClass().getName()+"."+method.getName()+" (user : "+sessionManager.getCurrentUser().getLogin()+")");
			}
			return method.invoke(proxifiedManager, args);
		} catch (Exception e) {
			Throwable t = e;
			while (t != null && !(t instanceof EMagineException) && t != t.getCause()) {
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
