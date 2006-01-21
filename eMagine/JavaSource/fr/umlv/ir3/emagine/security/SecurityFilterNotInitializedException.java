package fr.umlv.ir3.emagine.security;

import fr.umlv.ir3.emagine.util.EMagineException;

public class SecurityFilterNotInitializedException extends EMagineException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8811363903159041300L;

	public SecurityFilterNotInitializedException() {
		super("exception.eMagineSecurityFilter.notInitialized");
	}
}
