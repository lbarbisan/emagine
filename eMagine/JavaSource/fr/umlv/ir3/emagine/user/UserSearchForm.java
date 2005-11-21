package fr.umlv.ir3.emagine.user;

import java.util.Collection;
import org.apache.struts.action.ActionForm;

public class UserSearchForm extends ActionForm implements UserSearchParam {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2405706291327109100L;

	private Collection<Profile> profiles;
	
	private Collection<User> userResults;

	private String firstName;

	private String lastName;

	private String login;

	private Profile profile;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Collection<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}
	public void setUserResults(Collection<User> users) {
		userResults = users;
	}
	public Collection<User> getUserResults() {
		return userResults;
	}
	public void setFilterbyField(String field, String value) {
		// TODO UserSearchForm.setFilterbyField()
		
	}
	public void removeFilterbyField(String field) {
		// TODO UserSearchForm.removeFilterbyField()
		
	}
	public void clearFilterbyField() {
		// TODO UserSearchForm.clearFilterbyField()
		
	}


}
