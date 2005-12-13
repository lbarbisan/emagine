package fr.umlv.ir3.emagine.apprentice;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface ApprenticeSearchParams extends SearchParams {
	@IsASearchParam("firstName")
	public String getFirstName();
	@IsASearchParam("lastName")
	public String getLastName();
	@IsASearchParam("courseOption")
	public CourseOptionEnum getCourseOption();
	@IsASearchParam("year")
	public Integer getYear();
}
