package fr.umlv.ir3.emagine.apprentice;

import fr.umlv.ir3.emagine.util.search.SearchParam;

public interface ApprenticeSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	// TODO : intégrer "filière"
	public Integer getYear();
}
