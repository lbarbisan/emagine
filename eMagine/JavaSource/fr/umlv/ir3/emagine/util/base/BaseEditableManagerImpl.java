package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;

public abstract class BaseEditableManagerImpl<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseManagerImpl<EntityType, BaseDAO<EntityType>> implements BaseEditableManager<EntityType, EntityDAO> {

    /**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#update(EntityType)
	 */
	@Override
	public void update(EntityType newEntity) throws EMagineException {
			DAOManager.beginTransaction();
			//Load the original object 
    		EntityType oldEntity = retrieve(newEntity.getId());
    		// set the modification
    		newEntity.addModification(oldEntity);
    		super.update(newEntity);
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#acceptAllModificationFor(EntityType)
	 */
	public void acceptAllModificationFor(EntityType entity) {
		DAOManager.beginTransaction();
		entity.acceptModification();
		try {
			super.update(entity);
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#acceptFieldModificationFor(EntityType, java.lang.String)
	 */
	public void acceptFieldModificationFor(EntityType entity, String name) {
		DAOManager.beginTransaction();
		FieldModification field = entity.getCurrentModification().getFieldModification(name);
		entity.acceptFieldModification(field);
		try {
			super.update(entity);
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#extract(fr.umlv.ir3.emagine.extraction.ExtractionParam)
	 */
	//FIXME: Utilisé les générics
	public abstract Extractable extract(ExtractionParam extractionParam);
}
