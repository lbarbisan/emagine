package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParam;


public interface UserSearchParam extends SearchParam {
	@RequestParam("user.firstName")
	public String getFirstName();
	@RequestParam("user.lastName")
	public String getLastName();
	@RequestParam("user.login")
	public String getLogin();
	@RequestParam("user.profile.id")
	public Profile getProfile();
}
