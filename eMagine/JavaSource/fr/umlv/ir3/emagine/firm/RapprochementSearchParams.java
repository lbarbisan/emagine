package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface RapprochementSearchParams extends SearchParams {
	
	@IsASearchParam("courseOption")
	public CourseOptionEnum getCourseOption() throws NumberFormatException, EMagineException;
}
