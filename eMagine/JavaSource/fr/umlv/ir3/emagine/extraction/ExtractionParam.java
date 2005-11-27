package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.Extractable;

public interface ExtractionParam {

	public abstract Extractable getExtractable();

	public abstract ExtractionType getExtractionType();

	public abstract boolean isSaveConfig();
	
	public abstract String[] getSelectedFields();

}