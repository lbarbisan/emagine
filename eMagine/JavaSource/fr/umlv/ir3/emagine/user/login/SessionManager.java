/**
 *  
 */
package fr.umlv.ir3.emagine.user.login;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.umlv.ir3.emagine.user.User;

/**
 * @author iorga
 *
 */
public class SessionManager implements HttpSessionListener {
	private static ConcurrentHashMap<String, HttpSession> loginSessions = new ConcurrentHashMap<String, HttpSession>();

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// TODO SessionManager.sessionCreated()
		System.out.println("Session Created");
		System.out.println("Source : "+sessionEvent.getSource().getClass().toString());
		HttpSession session = sessionEvent.getSession();
		Enumeration enumeration = session.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String name = (String)enumeration.nextElement();
			System.out.println(name+" = "+session.getAttribute(name));
		}
	}

	/**
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO SessionManager.sessionDestroyed()
		System.out.println("Session destroyed");
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
	 * Adds the given login and session to the pull of accepted logins
	 * @param login
	 * @param httpSession
	 */
	public static void login(String login, HttpSession httpSession) {
		loginSessions.putIfAbsent(login, httpSession);
	}

}
