package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.Type;

import fr.umlv.ir3.emagine.util.base.EditableEntity;

/**
 * @author eMagine Team
 * Hibernate Interceptor for logging Modification
 * Thanks to: Wiki Community Area, http://www.hibernate.org/37.html
 */
public class ModificationInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = -4309640442405255339L;

	private Log log = LogFactory.getLog(ModificationInterceptor.class);

    private SessionFactory sessionFactory;
   
    private Map<Serializable, Modification> modifications = new HashMap<Serializable, Modification>();


    /**
     * @param sessionFactory The sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Retrieve the dirty property of an object     
     * @throws  
     * @see net.sf.hibernate.Interceptor#onFlushDirty(java.lang.Object,
     *      java.io.Serializable, java.lang.Object[], java.lang.Object[],
     *      java.lang.String[], net.sf.hibernate.type.Type[])
     */
    public boolean onFlushDirty(Object entity, Serializable id, Object[] newValues, Object[] oldValues,
            String[] properties, Type[] types) throws CallbackException
            {

    	//Vérifie que l'objet est bien un objet persitant modifiable
        if (entity instanceof EditableEntity  && /* FIXME : Vérifié que l'utilisateur à les droit sur l'objet */true)
        {
        	Modification modification;
        	
        	if(modifications.containsKey(id)==true)
        	{
        		modification = new Modification();
        	}
        	else
        	{
        		modification = modifications.get(id);
        	}

        	for(int index=0;index<properties.length;index++)
        	{
        		if(oldValues[index].equals(newValues[index])==false)
        				{
            			FieldModification<Object> fieldModification = new FieldModification<Object>();
            			fieldModification.setPropertyName(properties[index]);
            			fieldModification.setPropertyValue((Serializable)newValues[index]);
            			
            			modification.getFieldsModifications().put(fieldModification.getPropertyName(), fieldModification);
            			modification.setEditableEntity((EditableEntity)entity);
        				}
        	}
        	
        	modifications.put(id, modification);
        	
        	newValues = oldValues;
        	return true;
        }
        return false;
    }

    /**
     * @see org.hibernate.Interceptor#postFlush(java.util.Iterator)
     */
	@Override
	public void postFlush(Iterator entities) {
		Session session = sessionFactory.openSession();
		
		for(Modification modification : modifications.values())
		{
			session.save(modification);
			session.flush();
		}
		
		modifications.clear();
	}
 
}