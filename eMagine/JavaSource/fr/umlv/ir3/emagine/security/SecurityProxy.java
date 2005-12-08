package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;

import org.securityfilter.realm.SecurityRealmInterface;

import fr.umlv.ir3.emagine.user.login.SessionManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class SecurityProxy<Type> implements InvocationHandler {
	static protected SecurityRealmInterface realm = EmagineSecurityFilter.getRealm();	// TODO : améliorer cette dépendance
	private Type object;
	private Object proxy;
	
	
	public SecurityProxy(Type object) {
		this.object = object;
		this.proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}
	
	@SuppressWarnings("unchecked")
	public Type getProxy() {
		return (Type)proxy;
	}
	
	/*
	public static Object createRightManagedObject(Object object) {
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), new SecurityProxy(object));
	}*/

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		MustHaveRights rights = method.getAnnotation(MustHaveRights.class);
		if (rights != null) {
			Principal currentPrincipal = SessionManager.getCurrentPrincipal();
			for (String right : rights.value()) {
				if (!realm.isUserInRole(currentPrincipal, right)) {
					throw new EMagineException("exception.userIsNotAllowed", right);
				}
			}
		}
		return method.invoke(object, args);
	}

}
