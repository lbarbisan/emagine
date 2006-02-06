package fr.umlv.ir3.emagine.security;

import javax.servlet.http.HttpSession;

public interface SessionManagerConfig {
	/**
	 * 
	 * Returns an <code>EmaginePrincipal</code> object containing the name of
	 * the current authenticated user. If the user has not been authenticated,
	 * the method returns <code>null</code>.
	 * 
	 * @return a <code>EmaginePrincipal</code> containing the name of the user
	 *         making this request; <code>null</code> if the user has not been
	 *         authenticated
	 *         
	 * @throws SecurityFilterNotCorrectlyInitializedException if the current Principal is not an EmaginePrincipal (the realm used is not correct)
	 */
	public abstract EmaginePrincipal getUserPrincipal() throws SecurityFilterNotCorrectlyInitializedException;

	/**
	 * 
	 * Returns the current session associated with this SessionManagerConfig, or if the
	 * SessionManagerConfig does not have a session public HttpSession getSession();, creates
	 * one.
	 * 
	 * @return the <code>HttpSession</code> associated with this request
	 */
	public HttpSession getSession();
}
