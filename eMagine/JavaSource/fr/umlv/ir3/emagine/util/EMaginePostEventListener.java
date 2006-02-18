/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

/**
 * @author Administrateur
 *
 */
public class EMaginePostEventListener implements PostInsertEventListener, PostDeleteEventListener, PostUpdateEventListener {

	private static final Log log  = LogFactory.getLog(EMaginePostEventListener.class);
	
	private static final long serialVersionUID = -7847641643089637012L;
	/**
	 * @see org.hibernate.event.PostInsertEventListener#onPostInsert(org.hibernate.event.PostInsertEvent)
	 */
	public void onPostInsert(PostInsertEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			createEvent((EventableEntity) event.getEntity());
		}
	}
	
	/**
	 * @see org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate.event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			createEvent((EventableEntity) event.getEntity());
		}
	}
	
	public void onPostUpdate(PostUpdateEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			createEvent((EventableEntity) event.getEntity());
		}
	}
	
	/**
	 * Create an evenement
	 * @param eventableEntity
	 */
	private void createEvent(EventableEntity eventableEntity) {

		//DAOManager.beginTransaction();
		Session session =  HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		//TODO : #45 - lbarbisan - Spécifier l'utilisateur dans l'évènement
			Event eMagineEvent = new Event();
		
			//TODO : #44 - lbarbisan - Utiliser fillResource de la classe  Bundle
			eMagineEvent.setDescription("Création de :" + eventableEntity.toString());
			eMagineEvent.setDate(new Date());
			//eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			//TODO : #45 - lbarbisan
			//eMagineEvent.setType()
			eMagineEvent.setTitle("création");
			
			try {
				//DAOManager.getInstance().getEventDAO().create(eMagineEvent);
				session.save(eMagineEvent);
			} catch (HibernateException e) {
				//TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en cas de problème
				log.error("Error when tracing event of creation '" + eventableEntity + "'", e);
			}
		try {
			//DAOManager.commitTransaction();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO EMagineException.e Not Implemented
			log.error("Error when tracing event of creation '" + eventableEntity + "'", e);
		}
	}
	
	
}
