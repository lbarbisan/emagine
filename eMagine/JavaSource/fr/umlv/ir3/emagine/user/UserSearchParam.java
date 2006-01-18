package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface UserSearchParam extends SearchParams {
	
	@RequestParam("user.firstName")
	public String getFirstName();

	@RequestParam("user.lastName")
	public String getLastName();
	
	@RequestParam("user.login")
	public String getLogin();
	
	@RequestParam("user.profile.id")
	public String getProfile();
}
