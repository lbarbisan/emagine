package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseManager<EntityType extends BaseEntity, EntityDAO extends BaseDAO<EntityType>> {
	/**
	 * Creates the database data for the specified object. Handles the creation with a transaction.
	 * @param entity object that must be save in database
	 * @throws EMagineException throw this exception if the creation failed or if an SQLException occures
	 */
	public void create(EntityType entity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			EntityDAO dao = getDAO();
			dao.create(entity);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
    /**
     * Retrieves the database data for the specified id
     * @param id id of the object to retrieve
     * @return the object which is associated to id, null if not found
     * @throws EMagineException throw this exception if an SQLException occures
     */
	public abstract EntityType retrieve(long id) throws EMagineException;
	

    /**
     * Updates the database data for the specified object. Handles the update with a transaction.
     * @param entity object that must update save in database
     * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
     */
	public void update(EntityType newEntity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			EntityDAO dao =  getDAO();
			dao.update(newEntity);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
    /**
     * Deletes the database data associated the the specified object. Handles the deletion with a transaction. 
     * @param object object to delete
     * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
     */
	public void delete(EntityType entity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			EntityDAO dao = getDAO();
			dao.delete(entity);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
    /**
     * Deletes the database data associated the the specified objects. Handles the deletion with a transaction. 
     * @param object object to delete
     * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
     */
	public void delete(Collection<EntityType> entities) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			EntityDAO dao = getDAO();
			dao.delete(entities);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	protected abstract EntityDAO getDAO();
}
