package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;

public interface SearchParams {
	public Object getField(String field);
	public Collection<String> getFields();
}
