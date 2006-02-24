package fr.umlv.ir3.emagine.util;


import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEventListener;

import fr.umlv.ir3.emagine.event.EMaginePostEventListener;
import fr.umlv.ir3.emagine.modification.EditableInterceptor;
/**
 * This class is a tool to access to Hibernate Function.
 * @author Administrateur
 *
 */
public class HibernateUtils {

    private static Log log = LogFactory.getLog(HibernateUtils.class);
    
    private static final SessionFactory sessionFactory;
    
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();
    private static final EditableInterceptor editableInterceptor = new EditableInterceptor();
   
    static {
        try {            
        	//Initialize Hibernate configuration
        	ResourceBundle bundle = Bundles.getConfigBundle();
        	
        	String cfgHibernate = bundle.getString("hibernate.configurationFile");
        	
        	Properties properties =  new Properties();
        	Enumeration enums = bundle.getKeys();
        	while(enums.hasMoreElements())
        			{
        			String name = (String) enums.nextElement();
        			properties.put(name, bundle.getObject(name));
        			}
  
        	Configuration cfg = new AnnotationConfiguration();
        	
        	cfg.configure(cfgHibernate)
        	.addProperties(properties);
        	//.setInterceptor(editableInterceptor);

        	loadListeners(cfg);
        	
        	sessionFactory = cfg.buildSessionFactory(); 
        	//editableInterceptor.setSessionFactory(sessionFactory);        	
        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    private static void loadListeners(Configuration cfg)
    {
    	
    	PostDeleteEventListener[] stackDelete = { new EMaginePostEventListener()};
    	PostUpdateEventListener[] stackUpdate = { new EMaginePostEventListener()};
    	PostInsertEventListener[] stackInsert = { new EMaginePostEventListener()};
//    	
    	cfg.getEventListeners().setPostDeleteEventListeners(stackDelete);
    	cfg.getEventListeners().setPostUpdateEventListeners(stackUpdate);
    	cfg.getEventListeners().setPostInsertEventListeners(stackInsert);
    	
    	for(Object object: cfg.getEventListeners().getPostUpdateEventListeners())
    	{
    		System.err.println(object);
    	}
    	for(Object object: cfg.getEventListeners().getPostDeleteEventListeners())
    	{
    		System.err.println(object);
    	}
    	for(Object object: cfg.getEventListeners().getPostInsertEventListeners())
    	{
    		System.err.println(object);
    	}
    }
    
    /**
     * Return the session in current thread
     * @return the session 
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = threadSession.get();
        // Open a new Session, if this Thread has none yet
        if (session == null) {
        	session = sessionFactory.openSession();
        	//session.setFlushMode(FlushMode.COMMIT);
        	threadSession.set(session);
        }
        return session;
    }

    /**
     * Close the current session in current thread.
     * @throws HibernateException, if close session failed
     */
    public static void closeSession() throws HibernateException {
        log.trace("close current session");
    	Session session = threadSession.get();
        threadSession.set(null);
        if (session != null)
        {
        	log.debug("Session is closed");
        	session.close();
        }
    }
    
    /**
     * Return the unique factory of the application.
     * @return
     */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    /**
     * Start a transaction
     * @throws HibernateException if starting transaction failed
     */
    public static void beginTransaction() throws HibernateException
    {
    	log.trace("beginTransaction");
        Transaction tx = threadTransaction.get();
            if(tx==null)
            {
                Session session = getSession();
				tx = session.beginTransaction();
                threadTransaction.set(tx);
            }
    }

    /**
     * Commit the current transaction in the current thread
     * If commit failed, a rollback is done.
     * @throws HibernateException if commit failed
     */
    public static void commitTransaction() throws HibernateException
    {
    	log.trace("commitTransaction");
    	Transaction tx = threadTransaction.get();
        try
        {
            if(tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
            {
                tx.commit();
                threadTransaction.set(null);
//                closeSession();
            }
        }
        catch (HibernateException exception) {
            rollbackTransaction();
            throw exception;
        }
    }
    
    /**
     * rollback the current transaction in the current thread
     * @throws HibernateException if rollback failed
     */
    public static void rollbackTransaction() throws HibernateException
    {
    	log.trace("rollbackTransaction");
    	Transaction tx = threadTransaction.get();
        try
        {
        	if(tx!=null && !tx.wasCommitted() && !tx.wasRolledBack())
            {
                tx.rollback();
            }
        }
        finally
        {
            closeSession();
        }
    }
    
    /**
     * Return the current interceptor for the application
     * @return interceptor
     */
	public static EditableInterceptor getEditableInterceptor() {
		return editableInterceptor;
	}
}
