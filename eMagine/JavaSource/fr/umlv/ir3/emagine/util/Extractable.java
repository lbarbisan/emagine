package fr.umlv.ir3.emagine.util;

import java.util.Collection;

public interface Extractable {
	/**
	 * Returns all the fields which can be accessed for each rows.
	 * @return
	 */
	public Collection<String> getFields();
	/**
	 * Gives the propertyName for a specific column
	 * @param column
	 * @return
	 */
	public String getPropertyNameForColumn(String column);
	/**
	 * Gives all the rows of that extractable
	 * @return
	 */
	public Collection getRows();
}
