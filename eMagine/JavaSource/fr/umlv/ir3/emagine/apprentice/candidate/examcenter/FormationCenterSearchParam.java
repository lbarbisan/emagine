package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represents the critiera to search for a FormationCenter
 * @author Anthony
 */
public interface FormationCenterSearchParam extends SearchParam {
	public String getName();
	public Address getAddress();
	public String getPhone();
	public Integer getNumberOfRooms();
	public Integer getTotalFreeSits();
}
