package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.dao.UserSearchParam;
import java.util.Collection;
import org.apache.struts.action.ActionForm;

public class UserSearchForm extends ActionForm implements UserSearchParam {
	
	private Collection<Profile> profiles;

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


}
