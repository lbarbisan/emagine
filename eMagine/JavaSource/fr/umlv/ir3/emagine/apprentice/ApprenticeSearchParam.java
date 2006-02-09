package fr.umlv.ir3.emagine.apprentice;

import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface ApprenticeSearchParam extends SearchParams {
	
	public String getFirstName();

	public String getLastName();
	
	public String getIdCourseOption();
	
	public String getIdYear();
}
