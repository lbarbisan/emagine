/**
 *  
 */
package fr.umlv.ir3.emagine.security;

import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * @author aogier
 *
 */
public class UserIsNotAllowed extends EMagineException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2842251881872843670L;

	UserIsNotAllowed(String right) {
		super("exception.userIsNotAllowed", right);
	}
}
