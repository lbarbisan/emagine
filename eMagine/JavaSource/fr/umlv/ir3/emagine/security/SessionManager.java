/**
 *  
 */
package fr.umlv.ir3.emagine.security;

import java.security.Principal;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.JDBCRealm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;
import org.securityfilter.realm.catalina.CatalinaRealmAdapter;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.Constants;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * @author iorga
 * 
 */
public class SessionManager {
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(SessionManager.class);

	private static SessionManager instance;

	private ConcurrentHashMap<String, HttpSession> loginSessions = new ConcurrentHashMap<String, HttpSession>();

	private ConcurrentHashMap<String, Principal> loginPrincipal = new ConcurrentHashMap<String, Principal>();

	private ThreadLocal<User> currentUser = new ThreadLocal<User>();

	private final SecurityRealmInterface realm;

	/**
	 * Instanciate the only instance of SessionManager singleton.
	 * 
	 * @throws SecurityFilterNotInitializedException
	 *             if the security filter has not been initialized and
	 *             "security.SecurityProxy.securityFilterRealm" key of
	 *             eMagine.properties file has not been set to "none" nor
	 *             "properties"
	 */
	private SessionManager() throws SecurityFilterNotInitializedException {
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
		} else {
			this.realm = EmagineSecurityFilter.getInstance().getRealm();
		}
	}
	
	/**
	 * Initialize the thread local parameters for the specified HttpServletRequest.
	 * @param request
	 */
	public void initThreadLocal(HttpServletRequest request) {
		User currentUser = (User)request.getSession().getAttribute(Constants.LOGGED_IN_USER_KEY);
		if (currentUser != null) {
			setCurrentUser(currentUser);
		}
	}

	/**
	 * Sets the user for the current thread
	 * 
	 * @param user
	 */
	protected void setCurrentUser(User user) {
		currentUser.set(user);
	}

	/**
	 * Gets the user associated with the current thread
	 * 
	 * @return
	 */
	public User getCurrentUser() {
		return currentUser.get();
	}

	/**
	 * Returns <code>true</code> if the specified user is connected,
	 * <code>false</code> otherwise.
	 * 
	 * @param user
	 * @return
	 */
	public boolean isUserConnected(User user) {
		return loginSessions.containsKey(user.getLogin());
	}

	/**
	 * Kills the specified user's session.
	 * 
	 * @param user
	 * @throws EMagineException
	 *             if the current user's session already had been killed before
	 * @throws NullPointerException
	 *             if specified user is null
	 */
	public void killUserSession(User user) throws EMagineException {
		synchronized (user.getId()) {
			HttpSession session = loginSessions.remove(user.getLogin());
			if (session != null) {
				try {
					session.invalidate();
				} catch (IllegalStateException e) {
					throw new EMagineException(
							"exception.sessionManager.killUserSession.alreadyKilled");
				}
				loginPrincipal.remove(user.getLogin());
			}
		}
	}

	/**
	 * Kills the current connected user's session.
	 * 
	 * @throws EMagineException
	 *             if the current user's session already had been killed before
	 * @throws NullPointerException
	 *             if there isn't any current connected user.
	 */
	public void killCurrentSession() throws EMagineException {
		killUserSession(getCurrentUser());
	}

	/**
	 * Adds the given login and session to the pool of accepted logins. Retreive
	 * the User with the specified login, and set it into the session.
	 * 
	 * @param principal
	 * @param login
	 * @param password
	 * @param httpSession
	 * @throws EMagineException
	 *             throws if the user cannot be retreived
	 */
	protected void login(Principal principal, String login, String password,
			HttpSession session) throws EMagineException {
		synchronized (login) {
			User user = DAOManager.getInstance().getUserDAO().find(login,
					password);
			if (user != null) {
				HttpSession prevSession = loginSessions.put(login, session);
				if (prevSession != null) {
					prevSession.invalidate();
				}
				session.setAttribute(Constants.LOGGED_IN_USER_KEY, user);
				loginPrincipal.put(login, principal);
				setCurrentUser(user);
			}
		}
	}

	/**
	 * Gets the principal associated with the current thread, or
	 * <code>null</code> if no user is currently connected
	 * 
	 * @return
	 */
	private Principal getCurrentPrincipal() {
		User user = currentUser.get();
		if (user != null) {
			return loginPrincipal.get(user.getLogin());
		}
		return null;
	}

	/**
	 * Says if current user has the specified right. Uses the singleton instance
	 * to retreive the currentPrincipal, so if the
	 * 
	 * @param right
	 * @return <code>true</code> if the current user has the specified right, <code>false</code> otherwise
	 */
	public boolean isCurrentUserAllowedTo(String right) {
		return realm.isUserInRole(getCurrentPrincipal(), right);
	}

	/**
	 * @return the SessionManager singleton instance
	 * @throws SecurityFilterNotInitializedException
	 *             if the security filter has not been initialized and
	 *             "security.SecurityProxy.securityFilterRealm" key of
	 *             eMagine.properties file has not been set to "none" nor
	 *             "properties"
	 */
	public static synchronized SessionManager getInstance()
			throws SecurityFilterNotInitializedException {
		if (instance == null) {
			instance = new SessionManager();
		}
		return instance;
	}
}
