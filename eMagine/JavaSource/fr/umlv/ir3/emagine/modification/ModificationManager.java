package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public abstract class ModificationManager<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseManager<EntityType, BaseDAO<EntityType>>{

    /**
     * Updates the database data for the specified object. Handles the update with a transaction.
     * @param entity object that must update save in database
     * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
     */
	//TODO : Supprimer la suppressio Warninng
	@SuppressWarnings("unchecked")
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
	 * Accept All modification for specified Object
	 * @param entity
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
	 * Accept spécified Modification for cpécified Object and specified Field
	 * @param entity
	 * @param name
	 */
	public void acceptFieldModificationFor(EntityType entity, String name)
	{
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
