/**
 *  
 */
package fr.umlv.ir3.emagine.user.login;

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
	private static ThreadLocal<User> currentUser;

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
		if (session != null) {
			session.invalidate();
		}
	}
	
	/**
	 * Adds the given login and session to the pool of accepted logins.
	 * Retreive the User with the specified login, and set it into the session.
	 * @param login
	 * @param httpSession
	 * @throws EMagineException throws if the user cannot be retreived
	 */
	public static void login(String login, HttpSession session) throws EMagineException {
		//FIXME : quand hibernate sera OK
		//User user = ManagerManager.getInstance().getUserManager().find(login);
		User user = new User();
		user.setEmail("email@fr");
		user.setFirstName("Laurent");
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("dfsd");
		session.setAttribute(Constants.LOGGED_IN_USER_KEY, user);

		loginSessions.putIfAbsent(login, session);
	}

}
