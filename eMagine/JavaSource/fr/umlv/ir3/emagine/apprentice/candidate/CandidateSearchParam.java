package fr.umlv.ir3.emagine.apprentice.candidate;

import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface CandidateSearchParam extends SearchParams {
	
	@RequestParam("candidate.firstName")
	public String getFirstName();

	@RequestParam("candidate.lastName")
	public String getLastName();
	
	@RequestParam("candidate.formationCenter.id")
	public String getIdCenter();
	
	@RequestParam("candidate.optionCourse.id")
	public String getIdCourseOption();
}
