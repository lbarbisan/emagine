package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;

public interface SearchParams {
	public String getField(String field);
	public ParameterInfo getParameterInfo(String field);
	public Collection<String> getFields();
}
