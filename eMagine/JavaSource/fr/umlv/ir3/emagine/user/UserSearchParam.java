package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.core.user.profile.Profile;



public interface UserSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	public String getLogin();
	public Profile getProfile();
}
