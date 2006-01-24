package fr.umlv.ir3.emagine.security;

import fr.umlv.ir3.emagine.util.EMagineException;

public class SecurityFilterNotCorrectlyInitializedException extends EMagineException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541426938549486761L;

	public SecurityFilterNotCorrectlyInitializedException() {
		super("exception.eMagineSecurityFilter.notCorrectlyInitialized");
	}
}
