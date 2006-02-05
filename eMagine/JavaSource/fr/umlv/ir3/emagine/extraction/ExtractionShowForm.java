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
	 * @return the last extractionType selected by the user. The default value is not specified.
	 */
	public String getExtractionTypeName();

	/**
	 * Sets the specified extractionType. It represents the last extractionType selected by the user.
	 * @param extractionType
	 */
	public void setExtractionTypeName(String extractionTypeName);

	/**
	 * Sets the specified selectedEntityProperties. They represents the last entityProperties selected by the user.
	 * @param selectedEntityProperties
	 */
	public void setSelectedEntityProperties(String... selectedEntityProperties);
	
}
