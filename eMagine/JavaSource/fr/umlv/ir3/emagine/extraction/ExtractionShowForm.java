package fr.umlv.ir3.emagine.extraction;


/**
 * Form that represents the selection of the extract properties for an extraction entity.
 * @author netangel
 *
 */
public interface ExtractionShowForm extends ExtractionConfig {

	/**
	 * Sets the specified extractionType. It represents the last extractionType selected by the user.
	 * @param extractionType
	 */
	public void setExtractionType(ExtractionType extractionType);

	/**
	 * Sets the specified extractionType. It represents the last extractionType selected by the user.
	 * @param extractionType
	 */
	public void setExtractionType(String extractionType);

	/**
	 * Sets the specified selectedEntityProperties. They represents the last entityProperties selected by the user.
	 * @param selectedEntityProperties
	 */
	public void setSelectedEntityProperties(String[] selectedEntityProperties);
	
}
