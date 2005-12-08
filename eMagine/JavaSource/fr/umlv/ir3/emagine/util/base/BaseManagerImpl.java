package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseManagerImpl<EntityType extends BaseEntity, EntityDAO extends BaseDAO<EntityType>> implements BaseManager<EntityType, EntityDAO> {
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#create(EntityType)
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
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#retrieve(long)
	 */
	public abstract EntityType retrieve(long id) throws EMagineException;
	

    /**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#update(EntityType)
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
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#delete(EntityType)
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
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#delete(java.util.Collection)
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
