package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class EditableManager<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseManager<EntityType, BaseDAO<EntityType>>{

    /**
     * Updates the database data for the specified object. Handles the update with a transaction.
     * @param entity object that must update save in database
     * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
     */
	@SuppressWarnings("unchecked")
	public void update(EntityType newEntity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
//			 Load the original object 
    		EntityType oldEntity = getDAO().retrieve(newEntity.getId());
    		// set the modification
    		newEntity.addModification(oldEntity);
    		//Save new Object
			getDAO().update(newEntity);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

}
