package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Date;

import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface AbsenceSearchParams extends SearchParams {
	
	/**
	 * @return  the end date of abscence to search
	 */
	@IsASearchParam("startDate")
	public Date getStartDate();
	/**
	 * @return the end date of abscence to search
	 */
	@IsASearchParam("endDate")
	public Date getEndDate();
	
	/**
	 * @return true, to find only jsutificated abscence false, otherwise
	 */
	@IsASearchParam("justification")
	public boolean isJustification();
	
	/**
	 * @return the number of worked day in the actual abscence
	 */
	@IsASearchParam("numberOfWorkedDays")	// TODO : la recherche ne peut pas être générique
	public int getNumberOfWorkedDays();
}
