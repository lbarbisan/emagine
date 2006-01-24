package fr.umlv.ir3.emagine.security;

import java.security.Principal;
import java.util.ResourceBundle;

import org.apache.catalina.realm.JDBCRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;
import org.securityfilter.realm.catalina.CatalinaRealmAdapter;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.DAOManager;

public class EmagineRealmProxy implements SecurityRealmInterface  {
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(EmagineRealmProxy.class);
	
	private SecurityRealmInterface realm = null;

	public EmagineRealmProxy() {
		// If we don't want the securityFilter, for test for example,
		// instanciate a JDBCRealm instead.
		ResourceBundle bundle = Bundles.getConfigBundle();
		String securityRealm = bundle
				.getString("security.SecurityProxy.securityFilterRealm");

		if ("properties".equals(securityRealm)) {
			JDBCRealm realm = new JDBCRealm();
			realm.setDriverName(bundle.getString("db.driver"));
			realm.setConnectionURL(bundle.getString("db.connectionURLPrefix")
					+ bundle.getString("db.hostname") + ":"
					+ bundle.getString("db.port") + "/"
					+ bundle.getString("db.name"));
			realm.setConnectionName(bundle.getString("db.username"));
			realm.setConnectionPassword(bundle.getString("db.password"));
			realm.setUserTable(bundle
					.getString("security.SecurityProxy.userTable"));
			realm.setUserNameCol(bundle
					.getString("security.SecurityProxy.userNameCol"));
			realm.setUserCredCol(bundle
					.getString("security.SecurityProxy.userCredCol"));
			realm.setUserRoleTable(bundle
					.getString("security.SecurityProxy.userRoleTable"));
			realm.setRoleNameCol(bundle
					.getString("security.SecurityProxy.roleNameCol"));

			CatalinaRealmAdapter realmAdapter = new CatalinaRealmAdapter();
			realmAdapter.setRealm(realm);
			this.realm = realmAdapter;

		} else {
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
					log.debug("authenticate : " + username + " / " + password);
					return new StringPrincipal(username);
				}

				public boolean isUserInRole(Principal principal, String rolename) {
					log.debug("isUserInRole : "
							+ (principal != null ? principal.getName()
									: "[principal_null]") + " / " + rolename);
					return true;
				}
			};
		}
	}
	
	public Principal authenticate(String username, String password) {
		final Principal principal = realm.authenticate(username, password);
		if (principal != null) {
			final User user = DAOManager.getInstance().getUserDAO().find(username,
					password);
			if (user != null) {
				return new EmaginePrincipal() {
					public User getUser() {
						return user;
					}

					public Principal getPrincipal() {
						return principal;
					}

					public String getName() {
						return principal.getName();
					}
				};
			}
		}
		return null;
	}

	public boolean isUserInRole(Principal principal, String rolename) {
        if ((principal == null) || (rolename == null) ||
                !(principal instanceof EmaginePrincipal))
                return (false);
        return realm.isUserInRole(((EmaginePrincipal)principal).getPrincipal(), rolename);
	}
	
}
