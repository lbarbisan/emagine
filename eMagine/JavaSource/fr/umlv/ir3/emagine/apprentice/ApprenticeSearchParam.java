package fr.umlv.ir3.emagine.apprentice;

import fr.umlv.ir3.emagine.util.RequestParam;
import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface ApprenticeSearchParam extends SearchParams {
	
	@RequestParam("apprentice.firstName")
	public String getFirstName();

	@RequestParam("apprentice.lastName")
	public String getLastName();
	
	@RequestParam("apprentice.courseOption.id")
	public String getIdCourseOption();
	
	@RequestParam("apprentice.year.id")
	public String getIdYear();
}
