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
	 * @throws EMagineException if the config manager 
	 */
	@Override
	public BaseManager getManager(ExtractionConfig config)
			throws EMagineException {
		final String managerClass = Bundles.getExtractionBundle().getString("extraction."+config.getExtractionEntityName()+".manager");
		final BaseManager manager = ManagerManager.getInstance().getManager(managerClass);
		if (manager == null) {
			throw new EMagineException("exception.extraction.unknownConfigManager", "extraction."+config.getExtractionEntityName()+".manager", managerClass);
		}
		return manager;
	}

}
