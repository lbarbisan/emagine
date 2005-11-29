package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.modification.ModificationForm;
import fr.umlv.ir3.emagine.user.profile.Profile;

public class UserModifyForm extends ModificationForm<User> {
	
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private String passwordRepeat;
	
	public UserModifyForm() {
		entity = new User();
	}
	
	public String getEmail() {
		return entity.getEmail();
	}
	public void setEmail(String email) {
		entity.setEmail(email);
	}
	public String getFirstName() {
		return entity.getFirstName();
	}
	public void setFirstName(String firstName) {
		entity.setFirstName(firstName);
	}
	public String getLastName() {
		return entity.getLastName();
	}
	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}
	public String getLogin() {
		return entity.getLogin();
	}
	public void setLogin(String login) {
		entity.setLogin(login);
	}
	public String getPassword() {
		return entity.getPassword();
	}
	public void setPassword(String password) {
		entity.setPassword(password);
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public Profile getProfile() {
		return entity.getProfile();
	}
	public void setProfile(Profile profile) {
		entity.setProfile(profile);
	}	
}
