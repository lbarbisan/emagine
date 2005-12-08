package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParam;

public abstract class BaseManagerImpl
	<EntityType extends BaseEntity, EntityDAO extends BaseDAO<EntityType>> 
	implements BaseManager<EntityType, EntityDAO> {
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#find(fr.umlv.ir3.emagine.util.search.SearchParam)
	 */
	public List<EntityType> find(SearchParam searchParam) throws EMagineException {
		EntityDAO dao = getDAO();
		return dao.find(searchParam);
	}

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
	public EntityType retrieve(long id) throws EMagineException
	{
		try {
			EntityDAO dao = getDAO();
			return dao.retrieve(id);
		} catch (EMagineException exception) {
			throw exception;
		}
	}
	

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
