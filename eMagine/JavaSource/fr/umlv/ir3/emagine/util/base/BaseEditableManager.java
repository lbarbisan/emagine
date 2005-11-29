package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseEditableManager<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseManager<EntityType, BaseDAO<EntityType>> {

    /**
     * Updates the database data for the specified object. Handles the update with a transaction.
     * @param entity object that must update save in database
     * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
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
}
