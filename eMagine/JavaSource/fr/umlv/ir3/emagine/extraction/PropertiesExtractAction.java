/**
 *  
 */
package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseManager;

/**
 * Default ExtractAction which get the manager in the extraction.properties file
 * @author aogier
 *
 */
public class PropertiesExtractAction extends ExtractAction {

	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractAction#getManager(fr.umlv.ir3.emagine.extraction.ExtractionConfig)
	 */
	@Override
	public BaseManager getManager(ExtractionConfig config)
			throws EMagineException {
		return ManagerManager.getInstance().getManager(Bundles.getExtractionBundle().getString("extraction."+config.getExtractionEntityName()+".manager"));
	}

}
