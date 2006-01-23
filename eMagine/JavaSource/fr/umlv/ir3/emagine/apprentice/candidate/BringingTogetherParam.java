package fr.umlv.ir3.emagine.apprentice.candidate;

import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface BringingTogetherParam extends SearchParams {
	
	@RequestParam("candidate.optionCourse.id")
	public String getIdCourseOption();
}
