package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;
import java.util.HashMap;

public class SearchParamsImpl implements SearchParams {

	/**  **/
	HashMap<String, ParameterInfo> fields = new HashMap<String, ParameterInfo>();
	HashMap<String, Object> values = new HashMap<String, Object>();
	
	public void setField(String name, Object value) {
		values.put(name, value);
		fields.put(name, new ParameterInfo(name, value.getClass() ,name));
	}
	
	public String getField(String field) {
		return values.get(field).toString();
	}

	public Collection<String> getFields() {
		return fields.keySet();
	}

	public ParameterInfo getParameterInfo(String field) {
		return null;
	}

}
