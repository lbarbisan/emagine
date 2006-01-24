package fr.umlv.ir3.emagine.security;

import java.security.Principal;

import fr.umlv.ir3.emagine.user.User;

/**
 * This class is a sort of adapter of a Principal object. It is used by the
 * EmagineRealmProxy. The getPrincipal method is called when the realm invokes its isUserInRole method.
 * The goal is to let the adapted realm its original object when invoking its isUserInRole method.
 * 
 * Moreover, EmaginePrincipal stocks the corresponding User object when authentifiing.
 * 
 * @author aogier
 * 
 */
public interface EmaginePrincipal extends Principal {

	/**
	 * Returns the User who has logged in
	 * 
	 * @return the User who has logged in
	 */
	public User getUser();

	/**
	 * Returns the embeded Principal
	 * 
	 * @return the embeded Principal
	 */
	public Principal getPrincipal();

}
