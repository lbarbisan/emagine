/**
 * 
 */
package fr.umlv.ir3.emagine.util.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.modification.EditableInterceptor;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * This class implement the core of DAO design pattern, each DAO class must
 * implement this class. This class used CRUD Design pattern (Create, Retrieve,
 * Update, Delete). This mean that each DAO Class have by default this four
 * method : <br>
 * Create an Object from database <br>
 * Rretrieve an object from database <br>
 * Update an object from/to database <br>
 * Delete an Object from database
 * 
 * @author eMagine team
 * @param <EntityType>
 *            the type of object to manipulate.
 */
public class BaseDAO<EntityType extends BaseEntity> {
	
	private Log log = LogFactory.getLog(BaseDAO.class);
	
	private Class EntityClass;

	/**
	 * Creates the database data for the specified object
	 * 
	 * @param object
	 *            object that must be save in database
	 * @throws EMagineException
	 *             throw this exception if the creation failed or if an
	 *             SQLException occures
	 */
	public void create(EntityType object) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			session.save(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.create", exception);
		}
	}

	/**
	 * Updates the database data for the specified object
	 * 
	 * @param newEntity
	 *            object that must update save in database
	 * @throws EMagineException
	 *             throw this exception if the update failed or if an
	 *             SQLException occures
	 */
	public void update(EntityType newEntity) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			session.update(newEntity);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.update", exception);
		}
	}

	/**
	 * Retrieves the database data for the specified id
	 * 
	 * @param id
	 *            id of the object to retrieve
	 * @return the object which is associated to id, null if not found
	 * @throws EMagineException
	 *             throw this exception if an SQLException occures
	 */
	@SuppressWarnings("unchecked")
	public EntityType retrieve(long id) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			return (EntityType) session.load(getEntityClass(), id);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.update", exception);
		}
	}

	/**
	 * Deletes the database data associated the the specified object
	 * 
	 * @param object
	 *            object to delete
	 * @throws EMagineException
	 *             throw this excepion if the deletation failed or if an
	 *             SQLException occures
	 */
	public void delete(EntityType object) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			session.delete(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.delete", exception);
		}
	}

	/**
	 * Deletes the database data associated the the specified objects
	 * 
	 * @param objects
	 *            object to delete
	 * @throws EMagineException
	 *             throw this excepion if the deletation failed or if an
	 *             SQLException occures
	 */
	public void delete(Collection<EntityType> objects) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			for (EntityType object : objects) {
				session.delete(object);
			}
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.delete", exception);
		}
	}

	protected Class getEntityClass() {
		if (EntityClass == null) {
			// Retrouve le type du generic
			ParameterizedType type = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			EntityClass = (Class) (type.getActualTypeArguments()[0]);
		}
		return EntityClass;
	}

	/**
	 * Searches for a list of parameterized type objects which match the given searchParams
	 * @param searchParams
	 * @return List for search
	 * @throws EMagineException 
	 */
	public List<EntityType> find(SearchParams searchParams) throws EMagineException {

		boolean first = true;
		String queryString;

		queryString = "From " + getEntityClass().getSimpleName()
				+ (searchParams.getFields().size() == 0 ? "" : " where");
		for (String field : searchParams.getFields()) {
			// TODO : Optimiser avec des StringBuffer
			queryString = queryString + (first == true ? "" : " and ") + " "
					+ field + " like :" + field;
			if (first == true) {
				first = false;
			}
		}

		Query query = HibernateUtils.getSession().createQuery(queryString);
		for (String field : searchParams.getFields()) {
			Object value = searchParams.getField(field);
			query.setParameter(field, value);
		}
		return query.list();
	}

	/**
	 * Returns all the entities of the paramitrized type, or null if none found
	 * @return all collection of objects
	 * @throws EMagineException throws if an SQLException occures
	 */
	public List<EntityType> findAll() throws EMagineException {
		
		String query = "from "+ getEntityClass().getSimpleName();
		
		log.debug("findall() for '" + query + "'");
		
		List<EntityType> foundResults = (List<EntityType>) HibernateUtils
				.getSession().createQuery(query).list();
		if (foundResults.size() <= 0) {
			return null;
		}
		return foundResults;
	}

}
