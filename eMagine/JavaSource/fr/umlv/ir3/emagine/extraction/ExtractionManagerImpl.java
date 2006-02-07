package fr.umlv.ir3.emagine.extraction;

import java.util.List;

import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ExtractionManagerImpl extends BaseManagerImpl<ExtractionEntity, ExtractionDAO> implements ExtractionManager {


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
	
	public ExtractionConfig retrieveCurrentUserConfig(String extractionEntityName) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			SearchParamsImpl searchParams = new SearchParamsImpl();
			searchParams.setField("user.id", SessionManager.getInstance().getCurrentUser().getId());
			searchParams.setField("extractionEntity.name", extractionEntityName);
			List<ExtractionConfigEntity> config = DAOManager.getInstance().getExtractionConfigEntityDAO().find(searchParams);
			if (config.size() > 0) {
				return config.get(0);
			} else {
				//TODO : fabriquer une nouvelle extraction config pour le user
				return null;
			}
			
			//DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
}
