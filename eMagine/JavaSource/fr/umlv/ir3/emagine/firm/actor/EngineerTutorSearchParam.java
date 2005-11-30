package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represent the criteria for searching a teacher tutor
 * @author eMagine team
 */
public interface EngineerTutorSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
}
