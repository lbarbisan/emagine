package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;
import java.util.HashMap;

public class SearchParamsImpl implements SearchParams {

	HashMap<String, Object> fields = new HashMap<String, Object>();
	
	public void setField(String name, Object value)
	{
		fields.put(name, value);
	}
	
	public Object getField(String field) {
		return fields.get(field);
	}

	public Collection<String> getFields() {
		return fields.keySet();
	}

}
