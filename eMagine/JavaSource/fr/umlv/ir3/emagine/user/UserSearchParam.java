package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.IsAField;
import fr.umlv.ir3.emagine.util.search.SearchParam;



public interface UserSearchParam extends SearchParam {
	@IsAField("user.firstName")
	public String getFirstName();
	public String getLastName();
	public String getLogin();
	public Profile getProfile();
}
