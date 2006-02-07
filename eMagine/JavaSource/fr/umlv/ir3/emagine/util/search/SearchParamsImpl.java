package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class SearchParamsImpl implements SearchParams {

	/**  **/
	HashSet<String> fields = new HashSet<String>();
	HashMap<String, Object> values = new HashMap<String, Object>();
	
	public void setField(String name, Object value) {
		values.put(name, value);
		fields.add(name);
	}
	
	public String getValue(String field) {
		return values.get(field).toString();
	}

	public Collection<String> getFields() {
		return fields;
	}

	/**
	 * Throws NullPointerException if the given field doesn't exists
	 * @see fr.umlv.ir3.emagine.util.search.SearchParams#getType(java.lang.String)
	 */
	public Class getType(String field) {
		return values.get(field).getClass();
	}
}
