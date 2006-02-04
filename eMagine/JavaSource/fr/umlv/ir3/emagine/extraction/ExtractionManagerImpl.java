package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class ExtractionManagerImpl extends BaseManagerImpl<Extraction, ExtractionDAO> implements ExtractionManager {


	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionManager#saveConfig(fr.umlv.ir3.emagine.extraction.ExtractionForm)
	 */
	public void saveConfig(ExtractionConfig config) {
		// TODO enclosing_package.ExtractionManagerImpl.saveConfig(enclosing_method_arguments)
		throw new RuntimeException(new EMagineException("exception.unimplementedMethod", "enclosing_package.ExtractionManagerImpl.saveConfig(enclosing_method_arguments)"));
	}
	
	@Override
	protected ExtractionDAO getDAO() {
		return DAOManager.getInstance().getExtractionDAO();
	}

	public ExtractionConfig retrieveCurrentUserConfig(ExtractionConfig config) throws EMagineException {
		// TODO enclosing_package.ExtractionManagerImpl.retrieveCurrentUserConfig(enclosing_method_arguments)
		throw new RuntimeException(new EMagineException("exception.unimplementedMethod", "enclosing_package.ExtractionManagerImpl.retrieveCurrentUserConfig(enclosing_method_arguments)"));
	}
}
