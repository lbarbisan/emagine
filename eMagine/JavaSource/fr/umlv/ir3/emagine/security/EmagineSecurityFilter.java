package fr.umlv.ir3.emagine.security;

import org.securityfilter.filter.SecurityFilter;
import org.securityfilter.realm.SecurityRealmInterface;

public class EmagineSecurityFilter extends SecurityFilter {
	private static EmagineSecurityFilter instance;

	public EmagineSecurityFilter() {
		super();
		instance = this;
	}

	/**
	 * Returns the instance of the security filter.
	 * @return
	 * @throws SecurityFilterNotInitializedException if the security filter has not been initialized
	 */
	public static EmagineSecurityFilter getInstance() throws SecurityFilterNotInitializedException {
		if (instance == null) {
			throw new SecurityFilterNotInitializedException();
		}
		return instance;
	}

	/**
	 * Gets the emagine security filter's realm
	 * @return
	 */
	public SecurityRealmInterface getRealm() {
		return realm;
	}

}
