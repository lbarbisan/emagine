package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represent the criteria for searching a teacher tutor
 * @author eMagine team
 */
public interface EngineerTutorSearchParams extends SearchParams {
	@IsASearchParam("firstName")
	public String getFirstName();
	@IsASearchParam("lastName")
	public String getLastName();
}
