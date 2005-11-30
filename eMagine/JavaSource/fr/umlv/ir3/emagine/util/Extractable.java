package fr.umlv.ir3.emagine.util;

import java.util.Iterator;

public interface Extractable extends Iterable<Iterable<Object>> {

	
	/**
	 * Sets the columns show in extraction
	 * @param selectedColumns list all collumn
	 */
	public void setSelectedColums(Iterable<String> selectedColumns);
	
	
	/**
	 * Gives all the column name of that extractable
	 * @return
	 */
	public Iterator<String> getColumnsName();
	
	/**
	 * Gives all the column name of that extractable
	 * @return
	 */
	public Iterator<String> getselectedColumnsName();
	
}
