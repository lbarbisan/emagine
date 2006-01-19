package fr.umlv.ir3.emagine.security;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.apache.catalina.realm.JDBCRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;
import org.securityfilter.realm.catalina.CatalinaRealmAdapter;

import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;

public class SecurityProxy<Type> implements InvocationHandler {
	private SecurityRealmInterface realm;
	private Type object;
	private Object proxy;
	private SessionManager sessionManager;
	
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(SecurityProxy.class);

	
	/**
	 * 
	 * @param object
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public SecurityProxy(Type object) throws EMagineException {
		this.object = object;
		this.proxy = Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
		
		// If we don't want the securityFilter, for test for example, instanciate a JDBCRealm instead.
		ResourceBundle bundle = Bundles.getConfigBundle();
		String securityRealm = bundle.getString("security.SecurityProxy.securityFilterRealm");
		
		if("properties".equals(securityRealm)) {
			JDBCRealm realm = new JDBCRealm();
			realm.setDriverName(bundle.getString("security.SecurityProxy.driverName"));
			realm.setConnectionURL(bundle.getString("security.SecurityProxy.connectionURL"));
			realm.setConnectionName(bundle.getString("security.SecurityProxy.connectionName"));
			realm.setConnectionPassword(bundle.getString("security.SecurityProxy.connectionPassword"));
			realm.setUserTable(bundle.getString("security.SecurityProxy.userTable"));
			realm.setUserNameCol(bundle.getString("security.SecurityProxy.userNameCol"));
			realm.setUserCredCol(bundle.getString("security.SecurityProxy.userCredCol"));
			realm.setUserRoleTable(bundle.getString("security.SecurityProxy.userRoleTable"));
			realm.setRoleNameCol(bundle.getString("security.SecurityProxy.roleNameCol"));
			
			CatalinaRealmAdapter realmAdapter = new CatalinaRealmAdapter();
			realmAdapter.setRealm(realm);
			this.realm = realmAdapter;
			
		} else if ("none".equals(securityRealm)) {
			this.realm = new SecurityRealmInterface() {
				final class StringPrincipal implements Principal {
					String name;
					public StringPrincipal(String name) {
						this.name = name;
					}
					public String getName() {
						return name;
					}
				};
				public Principal authenticate(String username, String password) {
					log.debug("authenticate : "+username+" / "+password);
					return new StringPrincipal(username);
				}
				public boolean isUserInRole(Principal principal, String rolename) {
					log.debug("isUserInRole : "+(principal != null ? principal.getName() : "[principal_null]")+" / "+rolename);
					return true;
				}
			};
		} else {
			this.realm = EmagineSecurityFilter.getInstance().getRealm();
		}
		this.sessionManager = SessionManager.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public Type getProxy() {
		return (Type)proxy;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
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
				rights = rightList.toArray(new String[rightList.size()]);
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
		} catch (Exception e) {
			Throwable t = e;
			while (t != null && !(t instanceof EMagineException)) {
				t = t.getCause();
			}
			if (t != null) {
				throw t;
			} else {
				throw e;
			}
			/*
			if (e.getCause() instanceof EMagineException) {
				throw e.getCause();
			} else {
				throw e;
			}*/
		}
	}

}
