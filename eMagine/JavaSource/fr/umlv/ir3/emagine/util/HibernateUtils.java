package fr.umlv.ir3.emagine.util;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.persister.entity.JoinedSubclassEntityPersister;

import fr.umlv.ir3.emagine.modification.FieldModification;



public class HibernateUtils {

    private static Log log = LogFactory.getLog(HibernateUtils.class);

    private static final SessionFactory sessionFactory;
    
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

    static {
        try {            
        	sessionFactory = new AnnotationConfiguration()
            //TODO : Hibernate - Trouver un moyen pour mettre le nom de fichier dans un fichier poroperties ou autre.
        	.configure("fr/umlv/ir3/emagine/ressource/hibernate.cfg.xml")
            .buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    
    public static Session getSession() throws HibernateException {
        Session s = threadSession.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            threadSession.set(s);
        }
        
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = threadSession.get();
        threadSession.set(null);
        if (s != null)
            s.close();
    }
    
    public static void beginTransaction()
    {
        Transaction tx = threadTransaction.get();
        try
        {
            if(tx==null)
            {
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
            }
        }
        catch (Exception exception) {
            throw new IllegalThreadStateException();
        }
    }

    
    public static void commitTransaction()
    {
        Transaction tx = threadTransaction.get();
        try
        {
            if(tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
            {
                tx.commit();
                threadTransaction.set(null);
            }
        }
        catch (Exception exception) {
            rollbackTransaction();
            throw new IllegalThreadStateException();
        }
    }
    
    public static void rollbackTransaction()
    {
        Transaction tx = threadTransaction.get();
        try
        {
            if(tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
            {
                tx.rollback();
            }
        }
        catch (Exception exception) {
            throw new IllegalThreadStateException();
        }
        finally
        {
            closeSession();
        }
    }
    
    public static Map<String, FieldModification> getPropertySnapShot(BaseEntity entity)
    {
    	//HashMap<String, FieldModification>  propertyOldValue = new HashMap<String, FieldModification>();
		//ClassMetadata classMetadata = sessionFactory.getClassMetadata(User.class);
		Map classesMetadata = sessionFactory.getAllClassMetadata();
		
		for(Object obj : classesMetadata.keySet())
		{
			JoinedSubclassEntityPersister persiter = (JoinedSubclassEntityPersister)classesMetadata.get(obj);
			try
			{
				System.err.println("Class : " + obj);
				String[] strings = persiter.getPropertyNames();
				for(String string : strings)
				{
					Object object = persiter.getPropertyValue(entity, string, EntityMode.POJO);
					System.err.println("Valeur : " + classesMetadata.get( object ));
				}
			}
			catch(HibernateException e)
			{
				System.err.println("Exception");
				e.getCause().printStackTrace();
			}
		}
		//Map map = null;	
		//classMetadata.getPropertyValuesToInsert(entity,map, (SessionImplementor) threadSession.get());
	/*	System.out.println(classMetadata);
		Object[] object = classMetadata.getPropertyValues(entity, null);
		for(Object obj : object)
		{
			System.out.println(obj);
		}*/

		
		return null;
    }
}
