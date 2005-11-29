package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Date;

import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface AbsenceSearchParam extends SearchParam {
	public Date getStartDate();
	public Date getEndDate();
	public boolean isJustification();
	public int getNumberOfworkedDays();
}
