package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import fr.umlv.ir3.emagine.modification.EditableForm;
import fr.umlv.ir3.emagine.user.profile.Profile;

public class UserModifyForm2 extends EditableForm<User> {
	
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private String passwordRepeat;
	
	private Collection<Profile> profiles;
	
	
	public UserModifyForm2() {
		entity = new User();
	}

	/**
	 * @return Returns the passwordRepeat.
	 */
	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	/**
	 * @param passwordRepeat The passwordRepeat to set.
	 */
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	/**
	 * @return Returns the profiles.
	 */
	public Collection<Profile> getProfiles() {
		return profiles;
	}

	/**
	 * @param profiles The profiles to set.
	 */
	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}
	
	
}
