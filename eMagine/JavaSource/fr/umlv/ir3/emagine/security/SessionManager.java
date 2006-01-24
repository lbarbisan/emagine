/**
 *  
 */
package fr.umlv.ir3.emagine.security;

import java.security.Principal;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.securityfilter.realm.SecurityRealmInterface;

import fr.umlv.ir3.emagine.user.User;
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

	private ConcurrentHashMap<String, EmaginePrincipal> loginPrincipals = new ConcurrentHashMap<String, EmaginePrincipal>();

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
		this.realm = EmagineSecurityFilter.getInstance().getRealm();
	}
	
	/**
	 * Initialize the thread local parameters for the specified HttpServletRequest.
	 * @param request
	 * @throws SecurityFilterNotCorrectlyInitializedException if the current Principal is not an EmaginePrincipal (the realm used is not correct)
	 */
	public void initThreadLocal(HttpServletRequest request) throws SecurityFilterNotCorrectlyInitializedException {
		if (!(request.getUserPrincipal() instanceof EmaginePrincipal)) {
			throw new SecurityFilterNotCorrectlyInitializedException();
		}
		final EmaginePrincipal principal = (EmaginePrincipal)request.getUserPrincipal();
		User currentUser = principal.getUser();
		if (!isLoggedIn(currentUser.getLogin())) {
			login(principal, request.getSession());
		}
		setCurrentUser(currentUser);
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
		synchronized (loginSessions) {
			HttpSession session = loginSessions.remove(user.getLogin());
			loginPrincipals.remove(user.getLogin());
			if (session != null) {
				try {
					session.invalidate();
				} catch (IllegalStateException e) {
					throw new EMagineException(
							"exception.sessionManager.killUserSession.alreadyKilled");
				}
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
	 * Adds the given login and session to the pool of accepted logins.
	 * 
	 * @param user
	 * @param httpSession
	 */
	protected void login(EmaginePrincipal principal,  HttpSession session) {
		String login = principal.getUser().getLogin();
		synchronized (loginSessions) {
			loginSessions.put(login, session);
			loginPrincipals.put(login, principal);
		}
	}

	/**
	 * Tells if the given login is logged in or not
	 * @param login
	 * @return <code>true</code> if he / she is logged in, <code>false</code> otherwise
	 */
	protected boolean isLoggedIn(String login) {
		return loginSessions.contains(login);
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
			return loginPrincipals.get(user.getLogin());
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
