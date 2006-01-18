package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;
import java.util.HashMap;

public class SearchParamsImpl implements SearchParams {

	/**  **/
	HashMap<String, String> fields = new HashMap<String, String>();
	
	public void setField(String name, String value) {
		fields.put(name, value);
	}
	
	public String getField(String field) {
		return fields.get(field);
	}

	public Collection<String> getFields() {
		return fields.keySet();
	}

}
