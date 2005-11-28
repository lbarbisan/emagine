package fr.umlv.ir3.emagine.util;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.metadata.ClassMetadata;

import fr.umlv.ir3.emagine.modification.ModificationInterceptor;
import fr.umlv.ir3.emagine.util.base.BaseEntity;



public class HibernateUtils {

    private static Log log = LogFactory.getLog(HibernateUtils.class);

    private static final SessionFactory sessionFactory;
    
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
    private static final ThreadLocal<Interceptor> threadInterceptor = new ThreadLocal<Interceptor>();
    
    static {
        try {            
        	threadInterceptor.set(new ModificationInterceptor());
        	
        	sessionFactory = new AnnotationConfiguration()
            //TODO : Hibernate - Trouver un moyen pour mettre le nom de fichier dans un fichier poroperties ou autre.
        	.configure("fr/umlv/ir3/emagine/ressource/hibernate.cfg.xml")
            .setInterceptor(threadInterceptor.get())
        	.buildSessionFactory();
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    
    public static Session getSession() throws HibernateException {
        Session session = null;
        // Open a new Session, if this Thread has none yet
        if (session == null) {
        	session = sessionFactory.openSession();
            threadSession.set(session);
        }
        return session;
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
    
    public static Interceptor getInterceptor()
    {
    	return threadInterceptor.get();
    }
    
    public static Object getPropertyValue(String  name, BaseEntity entity)
    {
    	ClassMetadata classMetadata = sessionFactory.getClassMetadata(entity.getClass());
    	return classMetadata.getPropertyValue(entity, name, EntityMode.POJO);
    }
}
