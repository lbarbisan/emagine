package fr.umlv.ir3.emagine.util.base;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.ExtractionParams;
import fr.umlv.ir3.emagine.extraction.Extractor;
import fr.umlv.ir3.emagine.extraction.ExtractorFactory;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public abstract class BaseManagerImpl
	<EntityType extends BaseEntity, EntityDAO extends BaseDAO<EntityType>> 
	implements BaseManager<EntityType, EntityDAO> {
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#find(fr.umlv.ir3.emagine.util.search.SearchParams)
	 */
	public List<EntityType> find(SearchParams searchParams) throws EMagineException {
		return getDAO().find(searchParams);
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#findAll()
	 */
	public List<EntityType> findAll() throws EMagineException {
		return getDAO().findAll();
	}

	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#create(EntityType)
	 */
	public void create(EntityType entity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			getDAO().create(entity);
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
		return getDAO().retrieve(id);
	}
	

    /**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#update(EntityType)
	 */
	public void update(EntityType newEntity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			getDAO().update(newEntity);
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
			getDAO().delete(entity);
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
			for (EntityType entity : entities) {
				dao.delete(entity);
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	/**
	 * Implementation of a default extraction. For specific implementation, check that the params.getExtractionListName() corresponds to your extraction. 
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#extract(fr.umlv.ir3.emagine.extraction.Extractable, fr.umlv.ir3.emagine.extraction.ExtractionForm, java.io.OutputStream)
	 */
	public void extract(Extractable extractable, ExtractionParams params, OutputStream stream) throws EMagineException {
		Extractor extractor = ExtractorFactory.getExtractor(params.getExtractionType());
		extractor.extract(extractable, stream);
	}

	protected abstract EntityDAO getDAO();
}
