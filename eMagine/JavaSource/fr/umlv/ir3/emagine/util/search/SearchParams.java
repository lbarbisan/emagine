package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;

public interface SearchParams {
	public Object getValue(String field);
	public Collection<String> getFields();
	public Class getType(String field);
}
