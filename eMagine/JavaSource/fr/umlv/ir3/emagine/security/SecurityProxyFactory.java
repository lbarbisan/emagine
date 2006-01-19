package fr.umlv.ir3.emagine.security;

import java.security.Principal;
import java.util.ResourceBundle;

import org.apache.catalina.realm.JDBCRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;
import org.securityfilter.realm.catalina.CatalinaRealmAdapter;

import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class SecurityProxyFactory {
	private final SecurityRealmInterface realm;
	private final SessionManager sessionManager;
	
	private static SecurityProxyFactory instance;
	
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(SecurityProxyFactory.class);

	/**
	 * 
	 * @throws EMagineException if the security filter has not been initialized
	 */
	protected SecurityProxyFactory() throws EMagineException {
		// If we don't want the securityFilter, for test for example, instanciate a JDBCRealm instead.
		ResourceBundle bundle = Bundles.getConfigBundle();
		String securityRealm = bundle.getString("security.SecurityProxy.securityFilterRealm");
		
		if("properties".equals(securityRealm)) {
			JDBCRealm realm = new JDBCRealm();
			realm.setDriverName(bundle.getString("db.driver"));
			realm.setConnectionURL(
					bundle.getString("db.connectionURLPrefix") +
					bundle.getString("db.hostname") + ":" +
					bundle.getString("db.port") + "/" +
					bundle.getString("db.name"));
			realm.setConnectionName(bundle.getString("db.username"));
			realm.setConnectionPassword(bundle.getString("db.password"));
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
		instance = this;
	}
	
	/**
	 * 
	 * @return
	 * @throws EMagineException if the security filter has not been initialized
	 */
	private static synchronized SecurityProxyFactory getInstance() throws EMagineException {
		if (instance == null) {
			instance = new SecurityProxyFactory();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param <R>
	 * @param <D>
	 * @param <E>
	 * @param rightsInterface
	 * @return
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public static <R extends BaseManager<E, D>, D extends BaseDAO<E>, E extends BaseEntity> R getProxy(R rightsInterface) throws EMagineException {
		SecurityProxy<R, D, E> proxy = new SecurityProxy<R, D, E>(rightsInterface);
		proxy.realm = getInstance().realm;
		proxy.sessionManager = getInstance().sessionManager;
		return proxy.getProxy();
	}

}
