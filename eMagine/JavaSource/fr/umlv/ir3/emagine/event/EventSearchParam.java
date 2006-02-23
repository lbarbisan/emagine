package fr.umlv.ir3.emagine.event;

import fr.umlv.ir3.emagine.util.search.SearchParams;


public interface EventSearchParam extends SearchParams {
	
	public String getDateBegin();

	public String getDateEnd();
	
	public String getIdType();
}
