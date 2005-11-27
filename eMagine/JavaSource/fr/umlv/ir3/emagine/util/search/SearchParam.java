package fr.umlv.ir3.emagine.util.search;

import java.util.Collection;

public interface SearchParam {
		Object getField(String field);
		Collection<String> getFields();
}
