package fr.umlv.ir3.emagine.extraction;

import java.util.Collection;

public interface Extractable {
	/**
	 * Returns the title of each column. The titles must be in the same order as the column in each rows.
	 * @return the title of each column.
	 */
	Collection<String> getColumnTitles();
	
	/**
	 * Returns the rows of the extractable.
	 * @return the rows of the extractable.
	 */
	Iterable<ExtractableRow> getRows();
}
