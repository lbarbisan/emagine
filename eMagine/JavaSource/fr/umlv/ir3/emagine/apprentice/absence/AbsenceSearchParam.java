package fr.umlv.ir3.emagine.apprentice.absence;

import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface AbsenceSearchParam extends SearchParams {
	
	public String getStartDate();

	public String getEndDate();
	
	public String getIdJustification();
}
