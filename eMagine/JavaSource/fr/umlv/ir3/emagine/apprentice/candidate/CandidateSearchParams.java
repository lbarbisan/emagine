package fr.umlv.ir3.emagine.apprentice.candidate;

import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface CandidateSearchParams extends SearchParams {
	@IsASearchParam("firstName")
	public String getFirstName();
	@IsASearchParam("lastName")
	public String getLastName();
	@IsASearchParam("formationCenter.id")
	public FormationCenter getFormationCenter();
	@IsASearchParam("courseOption")
	public CourseOptionEnum getCourseOption();
}
