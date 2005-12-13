package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represents the critiera to search for a FormationCenter
 * @author Anthony
 */
public interface FormationCenterSearchParams extends SearchParams {
	@IsASearchParam("name")
	public String getName();
	@IsASearchParam("address")
	public Address getAddress();
	@IsASearchParam("phone")
	public String getPhone();
	@IsASearchParam("numberOfRooms")
	public Integer getNumberOfRooms();
	@IsASearchParam("totalFreeSits")
	public Integer getTotalFreeSits();
}
