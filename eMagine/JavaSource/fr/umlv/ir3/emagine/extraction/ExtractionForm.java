package fr.umlv.ir3.emagine.extraction;

import org.apache.struts.action.ActionForm;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Extractable;

public class ExtractionForm extends ActionForm implements ExtractionParam {

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
	 * All the selected fields of the extractable
	 */
	private String[] selectedFields;

	/**
	 * @return Returns the extractable.
	 */
	public Extractable getExtractable() {
		return extractable;
	}

	/**
	 * @param extractable The extractable to set.
	 */
	public void setExtractable(Extractable extractable) {
		this.extractable = extractable;
	}

	/**
	 * @return Returns the extractableName.
	 */
	public String getExtractableName() {
		return extractableName;
	}

	/**
	 * @param extractableName The extractableName to set.
	 */
	public void setExtractableName(String extractableName) {
		this.extractableName = extractableName;
	}

	/**
	 * @return Returns the extractionType.
	 */
	public ExtractionType getExtractionType() {
		return extractionType;
	}

	/**
	 * @param extractionType The extractionType to set.
	 */
	public void setExtractionType(ExtractionType extractionType) {
		this.extractionType = extractionType;
	}

	/**
	 * @return Returns the saveConfig.
	 */
	public boolean isSaveConfig() {
		return saveConfig;
	}

	/**
	 * @param saveConfig The saveConfig to set.
	 */
	public void setSaveConfig(boolean saveConfig) {
		this.saveConfig = saveConfig;
	}

	/**
	 * @return Returns the selectedFields.
	 */
	public String[] getSelectedFields() {
		return selectedFields;
	}

	/**
	 * @param selectedFields The selectedFields to set.
	 */
	public void setSelectedFields(String[] selectedFields) {
		this.selectedFields = selectedFields;
	}

	public User getUser() {
		// TODO ExtractionForm.getUser()
		return null;
	}

	public ViewEnum getView() {
		// TODO ExtractionForm.getView()
		return null;
	}
}
