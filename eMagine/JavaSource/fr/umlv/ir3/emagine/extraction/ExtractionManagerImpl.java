package fr.umlv.ir3.emagine.extraction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ExtractionManagerImpl extends BaseManagerImpl<ExtractionEntity, ExtractionEntityDAO> implements ExtractionManager {


	/**
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionManager#saveConfig(fr.umlv.ir3.emagine.extraction.ExtractionForm)
	 */
	public void saveConfig(ExtractionConfig config) {
		// TODO enclosing_package.ExtractionManagerImpl.saveConfig(enclosing_method_arguments)
		throw new RuntimeException(new EMagineException("exception.unimplementedMethod", "enclosing_package.ExtractionManagerImpl.saveConfig(enclosing_method_arguments)"));
	}
	
	@Override
	protected ExtractionEntityDAO getDAO() {
		return DAOManager.getInstance().getExtractionEntityDAO();
	}
	
	public ExtractionConfig retrieveCurrentUserConfig(ExtractionConfig config) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			SearchParamsImpl searchParams = new SearchParamsImpl();
			searchParams.setField("extractionconfigentity.user.id", SessionManager.getInstance().getCurrentUser().getId());
			searchParams.setField("extractionconfigentity.extractionEntity.name", config.getExtractionEntityName());
			List<ExtractionConfigEntity> configs = DAOManager.getInstance().getExtractionConfigEntityDAO().find(searchParams);
			if (configs.size() > 0) {
				return configs.get(0);
			} else {
				//TODO : fabriquer une nouvelle extraction config pour le user
				// Search if the extraction entity exists
				SearchParamsImpl searchParams2 = new SearchParamsImpl();
				searchParams2.setField("extractionentity.name", config.getExtractionEntityName());
				List<ExtractionEntity> entities = DAOManager.getInstance().getExtractionEntityDAO().find(searchParams2);
				if (entities.size() < 1) {
					// The entity doesn't exist, throws the exception
					throw new EMagineException("exception.extraction.entityDoesntExists");
				}
				ExtractionEntity entity = entities.get(0);
				ExtractionConfigEntity configEntity = new ExtractionConfigEntity();
				configEntity.setExtractionEntity(entity);
				configEntity.setExtractionType(config.getExtractionType());
				configEntity.setUser(SessionManager.getInstance().getCurrentUser());
				if (config.getSelectedEntityProperties() != null) {
					HashSet selectedProperties = new HashSet(Arrays.asList(config.getSelectedEntityProperties()));
					
					// Adds all the selected properties
					for (ExtractionProperty property : entity.getProperties()) {
						if (selectedProperties.contains(property.getName())) {
							configEntity.getSelectedExtractionProperties().add(property);
						}
					}
				}
				DAOManager.commitTransaction();
				return configEntity;
			}
			
			//DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
}
