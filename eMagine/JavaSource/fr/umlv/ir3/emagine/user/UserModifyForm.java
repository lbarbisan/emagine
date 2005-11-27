package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.base.BaseModifyForm;

public class UserModifyForm extends BaseModifyForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private User entity = new User();
	private String passwordRepeat;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public User getEntity() {
		return entity;
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
	public Long getId() {
		return entity.getId();
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
