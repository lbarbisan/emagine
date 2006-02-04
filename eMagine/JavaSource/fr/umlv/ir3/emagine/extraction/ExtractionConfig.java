/**
 *  
 */
package fr.umlv.ir3.emagine.extraction;

import java.util.Collection;

/**
 * Configuration of an extraction :
 * - Extraction entity name
 * - Extraction entity properties
 * - Extraction type
 * - Extraction entity properties selected by the user
 * @author netangel
 *
 */
public interface ExtractionConfig {
	/**
	 * @return all the properties to be listed in the extraction selection form for the current extraction entity. The returned collection cannot be modified.
	 */
	public Collection<String> getEntityProperties();
	
	/**
	 * @return the name of the extraction entity linked with the form.
	 */
	public String getExtractionEntityName();
	
	/**
	 * @return the last extractionType selected by the user. The default value is not specified.
	 */
	public ExtractionType getExtractionType();
	
	/**
	 * @return the last entityProperties selected by the user. The default value is not specified.
	 */
	public String[] getSelectedEntityProperties();

}
