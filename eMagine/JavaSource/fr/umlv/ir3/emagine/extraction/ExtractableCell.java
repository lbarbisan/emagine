package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.EMagineException;

public interface ExtractableCell {
	public Object getCellValue() throws EMagineException;
	public String getColumnName();
}
