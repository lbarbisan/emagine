/**
 * 
 */
package fr.umlv.ir3.emagine.dao.hibernate;

import fr.umlv.ir3.emagine.dao.BaseDAO;
import fr.umlv.ir3.emagine.util.hibernate.HibernateUtils;


/**
 * @author Administrateur
 *
 */
public abstract class HibernateBaseDAO<ObjectType> implements BaseDAO<ObjectType>{

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#create(ObjectType)
     */
    public void create(ObjectType object) {
    	  HibernateUtils.getSession().save(object);
        
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#update(ObjectType)
     */
    public void update(ObjectType object) {
    	  HibernateUtils.getSession().saveOrUpdate(object);
    }

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#read(long)
     */
    public abstract ObjectType retrieve(long id);

    /* (non-Javadoc)
     * @see fr.umlv.ir3.emagine.dao.BaseDAO#delete(ObjectType)
     */
    public void delete(ObjectType object) {
  	  HibernateUtils.getSession().delete(object);        
    }

 

}
