package fr.umlv.ir3.emagine.extraction;

import org.apache.struts.action.ActionForm;

import fr.umlv.ir3.emagine.util.Extractable;

public class ExtractionForm extends ActionForm implements ExtractionParam {
	private static final long serialVersionUID = 6762568005279012044L;
	/**
	 * Used to know if the configuration must be saved
	 */
	private boolean saveConfig;
	/**
	 * Type of extraction (XLS / CSV)
	 */
	private ExtractionType extractionType;
	/**
	 * Name of the extractable saved in the session, from which the list could be extracted
	 */
	private String extractableName;
	
	private Extractable extractable;

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionParam#getExtractable()
	 */
	public Extractable getExtractable() {
		return extractable;
	}

	public void setExtractable(Extractable extractable) {
		this.extractable = extractable;
	}

	public String getExtractableName() {
		return extractableName;
	}

	public void setExtractableName(String extractableName) {
		this.extractableName = extractableName;
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionParam#getExtractionType()
	 */
	public ExtractionType getExtractionType() {
		return extractionType;
	}

	public void setExtractionType(ExtractionType extractionType) {
		this.extractionType = extractionType;
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionParam#isSaveConfig()
	 */
	public boolean isSaveConfig() {
		return saveConfig;
	}

	public void setSaveConfig(boolean saveConfig) {
		this.saveConfig = saveConfig;
	}
	
	
}
