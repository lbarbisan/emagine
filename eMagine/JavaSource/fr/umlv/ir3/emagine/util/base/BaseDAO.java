/**
 * 
 */
package fr.umlv.ir3.emagine.util.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.EntityType;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.search.SearchParam;


/**
 * This class implement the core of DAO design pattern, each DAO class must implement
 * this class. This class used CRUD Design pattern (Create, Retrieve, Update, Delete).
 * This mean that each DAO Class have by default this four method :
 * <br>Create an Object from database
 * <br>Rretrieve an object from database
 * <br>Update an object from/to database
 * <br>Delete an Object from database
 * @author eMagine team
 * @param <EntityType> the type of object to manipulate.
 */
public class BaseDAO<EntityType extends BaseEntity> {

	/**
	 * Creates the database data for the specified object
	 * @param object object that must be save in database
	 * @throws EMagineException throw this exception if the creation failed or if an SQLException occures
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
     * @param object object that must update save in database
     * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
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
     * @param id id of the object to retrieve
     * @return the object which is associated to id, null if not found
     * @throws EMagineException throw this exception if an SQLException occures
     */
    public EntityType retrieve(long id) throws EMagineException {
    	try {
    		Session session = HibernateUtils.getSession();
    		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
    		Class klass = (Class)(type.getActualTypeArguments()[0]);
			return (EntityType) session.load(klass, id);
    	} catch (HibernateException exception) {
    		throw new EMagineException("exception.baseDAO.update", exception);
    	}
    }

	/**
     * Deletes the database data associated the the specified object 
     * @param object object to delete
     * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
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
     * @param object object to delete
     * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
     */
    public void delete(Collection<EntityType> objects) throws EMagineException {
    	try {
	    	Session session = HibernateUtils.getSession();
			session.delete(objects);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.delete", exception);
		}
    }
    
    public List<EntityType> find(SearchParam searchParam)
    {
    	
    	boolean first = true;
    	String queryString;
    	
    	//Retrouve le type du generic
    	ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		Class klass = (Class)(type.getActualTypeArguments()[0]);
		
		queryString = "From " + klass.getName() + (searchParam.getFields().size()==0 ? "" : " where");
        for (String field : searchParam.getFields())
        {        	
        	//TODO : Optimiser avec des StringBUffer
        	queryString = queryString + (first==true ? "" : " and ") + " " + field + " = :" + field;
        	if(first==true) {first= false;}
		}
        
        Query query = HibernateUtils.getSession().createQuery(queryString);
        for (String field : searchParam.getFields())
        {        	
        	Object value = searchParam.getField(field);
        	query.setParameter(field, value);
		}         
        return query.list();
    }
}
