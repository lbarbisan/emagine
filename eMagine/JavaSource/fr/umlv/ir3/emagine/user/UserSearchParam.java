package fr.umlv.ir3.emagine.user;



public interface UserSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	public String getLogin();
	public Profile getProfile();
}
