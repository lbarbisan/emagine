package fr.umlv.ir3.emagine.user;

import java.util.Collection;


public interface IUserSearchForm {
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getLogin();
	public void setLogin(String login);
	public Profile getProfile();
	public void setProfile(Profile profile);
	public Collection<Profile> getProfiles();
	public void setProfiles(Collection<Profile> profiles);
}
