package fr.umlv.ir3.emagine.user;


public interface UserSearchParam {
	public String getFirstName();
	public void setFirstName(String firstName);
	public String getLastName();
	public void setLastName(String lastName);
	public String getLogin();
	public void setLogin(String login);
	public Profile getProfile();
	public void setProfile(Profile profile);
}
