package fr.umlv.ir3.emagine.student;

import fr.umlv.ir3.emagine.util.search.SearchParam;

public interface StudentSearchParam extends SearchParam {
	public String getFirstName();
	public String getLastName();
	// TODO : int�grer "fili�re"
	public Integer getYear();
}
