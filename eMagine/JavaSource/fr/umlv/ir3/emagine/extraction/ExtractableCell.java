package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.EMagineException;

public interface ExtractableCell {
	/**
	 * Returns the value of the cell.
	 * @return the value of the cell.
	 * @throws EMagineException if an error specific for the underlaying implementation occurs
	 */
	public Object getCellValue() throws EMagineException;
	
	/**
	 * Returns the name of the column for that cell.
	 * @return the name of the column for that cell.
	 */
	public String getColumnName();
}
