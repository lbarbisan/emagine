/**
 * 
 */
package fr.umlv.ir3.emagine.util.base;

import org.hibernate.HibernateException;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;


/**
 * This class implement the core of DAO design pattern, each DAO class must implement
 * this class. This class used CRUD Design pattern (Create, Retrieve, Update, Delete).
 * This mean that each DAO Class have by default this four method :
 * <br>Create an Object from database
 * <br>Rretrieve an object from database
 * <br>Update an object from/to database
 * <br>Delete an Object from database
 * @author eMagine team
 * @param <ObjectType> the type of object to manipulate.
 */
public abstract class BaseDAO<ObjectType> {
	 
	/**
	 * Create the database data for the specified object
	 * @param object object that must be save in database
	 * @throws EMagineException throw this exception if the creation failed
	 */
    public void create(ObjectType object) throws EMagineException {
    	try {
    		HibernateUtils.getSession().save(object);
    	} catch (HibernateException exception) {
    		throw new EMagineException("exception.hibernate.create", exception);
    	}
    }

    /**
     * Update the database data for the specified object
     * @param object object that must update save in database
     * @throws EMagineException  throw this exception if the update failed
     */
    public void update(ObjectType object) throws EMagineException {
    	try {
    		HibernateUtils.getSession().saveOrUpdate(object);
    	} catch (HibernateException exception) {
    		throw new EMagineException("exception.hibernate.update", exception);
    	}
    }

    /**
     * Retrieve the database data for the specified id
     * @param id id of the object to retrieve
     * @return the object which is associated to id
     */
	//FIXME: Doit-on remonter une exception si l'objet n'est pas trouvé ?
    public abstract ObjectType retrieve(long id);

    /**
     * delete the database data associated the the specified object 
     * @param object object to delete
     * @throws EMagineException throw this excepion if the deletation failed
     */
    public void delete(ObjectType object) throws EMagineException {
    	try {
	    	HibernateUtils.getSession().delete(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.hibernate.delete", exception);
		}
    }
    

}
