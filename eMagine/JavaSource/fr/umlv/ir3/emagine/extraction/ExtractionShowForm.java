package fr.umlv.ir3.emagine.extraction;

import java.util.Collection;


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
	
	/**
	 * @return the collection of the extraction groups containing the entity properties
	 */
	public Collection<ExtractionGroup> getExtractionGroups();
	
	/**
	 * @return the root group which contains the properties for the main group and the sub-groups of that group.
	 */
	public ExtractionGroup getRootGroup();
	
	/**
	 * @return the current selected ids
	 */
	public String[] getCurrentSelectedIds();
	
}
