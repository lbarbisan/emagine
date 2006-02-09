package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface UserSearchParam extends SearchParams {
	
	public String getFirstName();

	public String getLastName();
	
	public String getLogin();

	public String getIdProfile();
}
