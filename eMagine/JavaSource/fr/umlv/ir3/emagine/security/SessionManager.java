/**
 *  
 */
package fr.umlv.ir3.emagine.security;

import java.security.Principal;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Constants;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;

/**
 * @author iorga
 *
 */
public class SessionManager {
	private static ConcurrentHashMap<String, HttpSession> loginSessions = new ConcurrentHashMap<String, HttpSession>();
	private static ConcurrentHashMap<String, Principal> loginPrincipal = new ConcurrentHashMap<String, Principal>();
	private static ThreadLocal<User> currentUser = new ThreadLocal<User>();

	/**
	 * Sets the user for the current thread
	 * @param user
	 */
	public static void setCurrentUser(User user) {
		currentUser.set(user);
	}
	
	/**
	 * Gets the user associated with the current thread
	 * @return
	 */
	public static User getCurrentUser() {
		return currentUser.get();
	}
	
	/**
	 * Returns <code>true</code> if the specified user is connected, <code>false</code> otherwise. 
	 * @param user
	 * @return
	 */
	public static boolean isUserConnected(User user) {
		return loginSessions.containsKey(user.getLogin());
	}
	
	/**
	 * Kills the specified user's session.
	 * @param user
	 */
	public static void killUserSession(User user) {
		HttpSession session = loginSessions.remove(user.getLogin());
		if (session != null) {	// TODO : synchronized ?
			session.invalidate();
			loginPrincipal.remove(user.getLogin());
		}
	}
	
	/**
	 * Adds the given login and session to the pool of accepted logins.
	 * Retreive the User with the specified login, and set it into the session.
	 * @param principal 
	 * @param login
	 * @param password
	 * @param httpSession
	 * @throws EMagineException throws if the user cannot be retreived
	 */
	public static void login(Principal principal, String login, String password, HttpSession session) throws EMagineException {
		//FIXME : quand hibernate sera OK
//		User user = new User();
//		user.setEmail("email@fr");
//		user.setFirstName("Laurent");
//		user.setLastName("Barbisan");
//		user.setLogin("lbarbisan");
//		user.setPassword("dfsd");

		synchronized (login) {
			User user = ManagerManager.getInstance().getUserManager().find(login, password);
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
	 * Gets the principal associated with the current thread, or <code>null</code> if no user is currently connected
	 * @return
	 */
	public static Principal getCurrentPrincipal() {
		User user = currentUser.get();
		if (user != null) {
			return loginPrincipal.get(user.getLogin());
		}
		return null;
	}

}
