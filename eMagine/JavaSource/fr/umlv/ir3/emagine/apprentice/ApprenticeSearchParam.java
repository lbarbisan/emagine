package fr.umlv.ir3.emagine.apprentice;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represents the critiera to search for an Apprentice
 * @author Anthony
 */
public interface ApprenticeSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	public CourseOptionEnum getCourseOption();
	public Integer getYear();
}
