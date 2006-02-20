package fr.umlv.ir3.emagine.extraction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import fr.umlv.ir3.emagine.security.SecurityFilterNotInitializedException;
import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ExtractionManagerImpl extends BaseManagerImpl<ExtractionEntity, ExtractionEntityDAO> implements ExtractionManager {


	/**
	 * @throws EMagineException 
	 * @see fr.umlv.ir3.emagine.extraction.ExtractionManager#saveConfig(fr.umlv.ir3.emagine.extraction.ExtractionForm)
	 */
	public void saveConfig(ExtractionConfig config) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			ExtractionConfigEntity configEntity = retrieveCurrentUserConfigWithoutTransaction(config);
			updateSelectedConfigEntity(configEntity, config);
			DAOManager.getInstance().getExtractionConfigEntityDAO().update(configEntity);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	@Override
	protected ExtractionEntityDAO getDAO() {
		return DAOManager.getInstance().getExtractionEntityDAO();
	}
	
	public ExtractionConfig retrieveCurrentUserConfig(ExtractionConfig config) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			ExtractionConfigEntity configEntity = retrieveCurrentUserConfigWithoutTransaction(config);
			DAOManager.commitTransaction();
			return configEntity;
			//DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	private ExtractionConfigEntity retrieveCurrentUserConfigWithoutTransaction(ExtractionConfig config) throws EMagineException {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("extractionconfigentity.user.id", SessionManager.getInstance().getCurrentUser().getId());
		searchParams.setField("extractionconfigentity.extractionEntity.name", config.getExtractionEntityName());
		// Try to get the saved config for the specified extraction entity
		List<ExtractionConfigEntity> configs = DAOManager.getInstance().getExtractionConfigEntityDAO().find(searchParams);
		if (configs.size() > 0) {
			// It exists, return it
			return configs.get(0);
		} else {
			// Search if the extraction entity exists
			SearchParamsImpl searchParams2 = new SearchParamsImpl();
			searchParams2.setField("extractionentity.name", config.getExtractionEntityName());
			List<ExtractionEntity> entities = DAOManager.getInstance().getExtractionEntityDAO().find(searchParams2);
			ExtractionEntity entity = null;
			if (entities.size() < 1) {
				// The entity doesn't exist, throws the exception
				/** Create the entity and save it **/
				entity = new ExtractionEntity();
				entity.setName(config.getExtractionEntityName());
				for (String property : config.getEntityProperties()) {
					// Create all the property
					final ExtractionProperty extractionProperty = new ExtractionProperty(property);
					extractionProperty.setExtractionEntity(entity);
					entity.getProperties().add(extractionProperty);
				}
				DAOManager.getInstance().getExtractionEntityDAO().create(entity);
			} else {
				entity = entities.get(0);
			}
			/** Create the config to associate with the entity for the current user */
			ExtractionConfigEntity configEntity = new ExtractionConfigEntity();
			configEntity.setExtractionEntity(entity);
			configEntity.setUser(SessionManager.getInstance().getCurrentUser());
			updateSelectedConfigEntity(configEntity, config);
			
			DAOManager.getInstance().getExtractionConfigEntityDAO().create(configEntity);
			return configEntity;
		}
	}

	private ExtractionConfigEntity updateSelectedConfigEntity(ExtractionConfigEntity configEntity, ExtractionConfig config) throws SecurityFilterNotInitializedException {
		configEntity.setExtractionType(config.getExtractionType());
		// Attach the selected entity properties if any
		if (config.getSelectedEntityProperties() != null) {
			HashSet selectedProperties = new HashSet(Arrays.asList(config.getSelectedEntityProperties()));
			
			// Adds all the selected properties
			for (ExtractionProperty property : configEntity.getExtractionEntity().getProperties()) {
				if (selectedProperties.contains(property.getName())) {
					configEntity.getSelectedExtractionProperties().add(property);
				}
			}
		}
		return configEntity;
	}
}
