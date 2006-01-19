/**
 * 
 */
package fr.umlv.ir3.emagine.util;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.base.BaseDAO;
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
public class EmagineEnumDAO 
{
	private Log log = LogFactory.getLog(EmagineEnumDAO.class);
	
	/**
	 * Creates the database data for the specified object
	 * 
	 * @param object
	 *            object that must be save in database
	 * @throws EMagineException
	 *             throw this exception if the creation failed or if an
	 *             SQLException occures
	 */
	public void create(EmagineEnum object) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			session.save(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.create", exception);
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
	public EmagineEnum retrieve(long id, Class clazz) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			return (EmagineEnum) session.load(clazz, id);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.update", exception);
		}
	}

	
	/**
	 * Returns all the entities of the paramitrized type, or null if none found
	 * @return all collection of objects
	 * @throws EMagineException throws if an SQLException occures
	 */
	public List<? extends EmagineEnum> findAll(Class<? extends EmagineEnum> clazz) throws EMagineException {
		
		StringBuilder queryString = new StringBuilder().append("from ").append(clazz.getSimpleName());
		
		log.debug("findall() with '" + queryString + "'");
		
		List<?> foundResults = (List<?>) HibernateUtils
				.getSession().createQuery(queryString.toString()).list();
		if (foundResults.size() <= 0) {
			return null;
		}
		return (List<? extends EmagineEnum>) foundResults;
	}
}
