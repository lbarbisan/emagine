package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
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
    private static final String UPDATE = "update";
    private static final String INSERT = "insert";
    private static final String DELETE = "delete";
    
    private Set inserts = new HashSet();
    private Set updates = new HashSet();
    private Set deletes = new HashSet();


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
    public boolean onFlushDirty(Object obj, Serializable id, Object[] newValues, Object[] oldValues,
            String[] properties, Type[] types) throws CallbackException
            {

    	//Vérifie que l'objet est bien un objet persitant modifiable
        if (obj instanceof EditableEntity  && /* FIXME : Vérifié que l'utilisateur à les droit sur l'objet */true)
        {
        	Modification modification = new Modification();
        	try {
        		DAOManager.getInstance().getBaseDAO().create(modification);
			} catch (EMagineException e) {
				// TODO EMagineException.e Not Implemented
				e.printStackTrace();
			}
			
        	for(int index=0;index<properties.length;index++)
        	{
        		if(oldValues[index].equals(newValues[index])==false)
        				{
            			FieldModification<Object> fieldModification = new FieldModification<Object>();
            			fieldModification.setPropertyName(properties[index]);
            			fieldModification.setPropertyValue((Serializable)newValues[index]);
            			try
            			{
            				DAOManager.getInstance().getBaseDAO().ge create(fieldModification);
        				} catch (EMagineException e) {
        					// TODO EMagineException.e Not Implemented
        					e.printStackTrace();
        				}
        				modification.getFieldsModifications().put(fieldModification.getPropertyName(), fieldModification);
        				try {
							DAOManager.getInstance().getBaseDAO().update(modification);
						} catch (EMagineException e) {
							// TODO EMagineException.e Not Implemented
							e.printStackTrace();
						}
        				((EditableEntity)obj).getModifications().add(modification);
        				}
	
        	}
        	
        	newValues = oldValues;
        	return true;
        }
        return false;
    }
 
}