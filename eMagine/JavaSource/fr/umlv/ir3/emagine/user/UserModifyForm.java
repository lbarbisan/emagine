package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.user.profile.Profile;

public class UserModifyForm extends ActionForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private User user = new User();
	private String passwordRepeat;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public User getUser() {
		return user;
	}
	
	public String getEmail() {
		return user.getEmail();
	}
	public void setEmail(String email) {
		user.setEmail(email);
	}
	public String getFirstName() {
		return user.getFirstName();
	}
	public void setFirstName(String firstName) {
		user.setFirstName(firstName);
	}
	public Long getId() {
		return user.getId();
	}
	public String getLastName() {
		return user.getLastName();
	}
	public void setLastName(String lastName) {
		user.setLastName(lastName);
	}
	public String getLogin() {
		return user.getLogin();
	}
	public void setLogin(String login) {
		user.setLogin(login);
	}
	public String getPassword() {
		return user.getPassword();
	}
	public void setPassword(String password) {
		user.setPassword(password);
	}
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	public Profile getProfile() {
		return user.getProfile();
	}
	public void setProfile(Profile profile) {
		user.setProfile(profile);
	}	
}
