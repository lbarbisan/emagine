package fr.umlv.ir3.emagine.extraction;

import java.util.Collection;

public interface Extractable {
	Collection<String> getColumnTitles();
	Iterable<ExtractableRow> getRows();
}
