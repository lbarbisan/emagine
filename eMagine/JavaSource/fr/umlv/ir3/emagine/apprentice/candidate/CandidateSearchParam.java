package fr.umlv.ir3.emagine.apprentice.candidate;

import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface CandidateSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	public FormationCenter getFormationCenter();
	public CourseOptionEnum getCourseOption();
}
