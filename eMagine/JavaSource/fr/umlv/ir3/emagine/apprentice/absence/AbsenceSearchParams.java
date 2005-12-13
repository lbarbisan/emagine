package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Date;

import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface AbsenceSearchParams extends SearchParams {
	@IsASearchParam("startDate")
	public Date getStartDate();
	@IsASearchParam("endDate")
	public Date getEndDate();
	@IsASearchParam("justification")
	public boolean isJustification();
	@IsASearchParam("numberOfWorkedDays")	// TODO : la recherche ne peut pas être générique
	public int getNumberOfWorkedDays();
}
