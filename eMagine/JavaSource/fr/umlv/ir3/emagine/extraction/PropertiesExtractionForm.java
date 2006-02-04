/**
 *  
 */
package fr.umlv.ir3.emagine.extraction;

import java.util.Arrays;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.Bundles;

/**
 * @author netangel
 *
 */
public class PropertiesExtractionForm extends AbstractExtractionForm {

	private static final long serialVersionUID = -1457049539320560373L;

	private String extractionEntityName;

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionForm#getExtractionObjectName()
	 */
	public String getExtractionObjectName() {
		return Bundles.getExtractionBundle().getString("extraction."+extractionEntityName+".sessionObject");
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getEntityProperties()
	 */
	public Collection<String> getEntityProperties() {
		return Arrays.asList(Bundles.getExtractionBundle().getString("extraction."+extractionEntityName+".properties").split(","));
	}

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionConfig#getExtractionEntityName()
	 */
	public String getExtractionEntityName() {
		return extractionEntityName;
	}

	/**
	 * @param extractionEntityName The extractionEntityName to set.
	 */
	public void setExtractionEntityName(String extractionEntityName) {
		this.extractionEntityName = extractionEntityName;
	}
	
	public String getExtractionTitleKey() {
		return "extraction."+extractionEntityName+".title";
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionShowForm#setExtractionType(java.lang.String)
	 */
	public void setExtractionType(String extractionType) {
		this.extractionType = ExtractionType.valueOf(extractionType);
	}
}
