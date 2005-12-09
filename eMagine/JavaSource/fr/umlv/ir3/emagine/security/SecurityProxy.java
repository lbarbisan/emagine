package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;

import org.securityfilter.realm.SecurityRealmInterface;

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
		MustHaveRights rights = method.getAnnotation(MustHaveRights.class);
		if (rights != null) {
			Principal currentPrincipal = sessionManager.getCurrentPrincipal();
			for (String right : rights.value()) {
				if (!realm.isUserInRole(currentPrincipal, right)) {
					throw new EMagineException("exception.userIsNotAllowed", right);
				}
			}
		}
		return method.invoke(object, args);
	}

}
