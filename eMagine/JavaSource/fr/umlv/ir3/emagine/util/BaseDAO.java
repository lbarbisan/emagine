/**
 * 
 */
package fr.umlv.ir3.emagine.util;

import org.hibernate.HibernateException;


//CRUD Design pattern
public abstract class BaseDAO<ObjectType> {
	 /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#create(ObjectType)
     */
    public void create(ObjectType object) throws EMagineException {
    	try {
    		HibernateUtils.getSession().save(object);
    	} catch (HibernateException exception) {
    		throw new EMagineException("exception.hibernate.create", exception);
    	}
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#update(ObjectType)
     */
    public void update(ObjectType object) throws EMagineException {
    	try {
    		HibernateUtils.getSession().saveOrUpdate(object);
    	} catch (HibernateException exception) {
    		throw new EMagineException("exception.hibernate.update", exception);
    	}
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#read(long)
     */
    public abstract ObjectType retrieve(long id);

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#delete(ObjectType)
     */
    public void delete(ObjectType object) throws EMagineException {
    	try {
	    	HibernateUtils.getSession().delete(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.hibernate.delete", exception);
		}
    }
    

}
