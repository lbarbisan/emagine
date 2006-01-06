package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;
import java.util.ArrayList;

import org.securityfilter.realm.SecurityRealmInterface;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.EMagineException;

public class SecurityProxy<Type> implements InvocationHandler {
	private SecurityRealmInterface realm;
	private Type object;
	private Object proxy;
	private SessionManager sessionManager;
	
	
	/**
	 * 
	 * @param object
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public SecurityProxy(Type object) throws EMagineException {
		this.object = object;
		this.proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
		this.realm = EmagineSecurityFilter.getInstance().getRealm();
		this.sessionManager = SessionManager.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public Type getProxy() {
		return (Type)proxy;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		MustHaveRights methodRights = method.getAnnotation(MustHaveRights.class);
		MustHaveRights classRights = method.getDeclaringClass().getAnnotation(MustHaveRights.class);

		String[] rights = null;
		if (methodRights == null && classRights != null) {
			// Adds the class rights if no method rights are specified
			// The checked rights become : [class right].[methode name] for each class right
			ArrayList<String> rightList = new ArrayList<String>();
			for (String right : classRights.value()) {
				rightList.add(right+"."+method.getName());
			}
			rights = rightList.toArray(rights);
		} else if (methodRights != null) {
			rights = methodRights.value();
		}
		
		if (rights != null) {
			Principal currentPrincipal = sessionManager.getCurrentPrincipal();
			for (String right : rights) {
				if (!realm.isUserInRole(currentPrincipal, right)) {
					if (method.getName().equals("update")) {
						Method updateWithoutRightsMethod = method.getDeclaringClass().getMethod("updateWithoutRights", EditableEntity.class);
						if (updateWithoutRightsMethod != null) {
							return updateWithoutRightsMethod.invoke(object, args);
						}
					}
					throw new EMagineException("exception.userIsNotAllowed", right);
				}
			}
		}
		return method.invoke(object, args);
	}

}
