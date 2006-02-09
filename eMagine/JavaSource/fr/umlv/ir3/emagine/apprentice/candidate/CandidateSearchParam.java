package fr.umlv.ir3.emagine.apprentice.candidate;

import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface CandidateSearchParam extends SearchParams {

	public String getFirstName();

	public String getLastName();
	
	public String getIdCenter();
	
	public String getIdCourseOption();
}
