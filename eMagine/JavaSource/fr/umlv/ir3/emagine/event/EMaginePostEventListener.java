/**
 *  
 */
package fr.umlv.ir3.emagine.event;

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

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

/**
 * @author Administrateur
 *
 */
public class EMaginePostEventListener implements PostInsertEventListener, PostDeleteEventListener, PostUpdateEventListener {

	private static final Log log  = LogFactory.getLog(EMaginePostEventListener.class);
	
	private static final long serialVersionUID = -7847641643089637012L;
	
	//TODO : #45 - lbarbisan - Sp�cifier l'utilisateur dans l'�v�nement
	//TODO : #52 - lbarbisan - Mettre en place la gestion des ev�nements avec annotations
	//TODO : #44 - lbarbisan - Utiliser fillResource de la classe  Bundle
	//TODO : #54 - lbarbisan - Regarder les propri�t�s modifi�es
	/**
	 * @see org.hibernate.event.PostInsertEventListener#onPostInsert(org.hibernate.event.PostInsertEvent)
	 */
	public void onPostInsert(PostInsertEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			EventableEntity eventableEntity = (EventableEntity) event.getEntity();
			Event eMagineEvent = new Event();
			
			eMagineEvent.setDescription("Cr�ation de :" + eventableEntity.toString());
			eMagineEvent.setDate(new Date());
			eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			eMagineEvent.setTitle("cr�ation");
				
			createEvent(eMagineEvent);
		}
	}
	
	/**
	 * @see org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate.event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			if(event.getEntity() instanceof EventableEntity)
			{
				EventableEntity eventableEntity = (EventableEntity) event.getEntity();
				Event eMagineEvent = new Event();
				
				eMagineEvent.setDescription("Suppression de :" + eventableEntity.toString());
				eMagineEvent.setDate(new Date());
				eMagineEvent.getSources().add((BaseEntity) event.getEntity());
				eMagineEvent.setTitle("Suppression");
					
				createEvent(eMagineEvent);
			}
		}
	}
	
	public void onPostUpdate(PostUpdateEvent event) {
		if(event.getEntity() instanceof EventableEntity)
		{
			EventableEntity eventableEntity = (EventableEntity) event.getEntity();
			Event eMagineEvent = new Event();
			
			eMagineEvent.setDescription("Mise � jour de :" + eventableEntity.toString());
			eMagineEvent.setDate(new Date());
			eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			eMagineEvent.setTitle("Mise � jour");
				
			createEvent(eMagineEvent);
		}
	}
	
	/**
	 * Create an evenement
	 * @param eventableEntity
	 */
	private void createEvent(Event eMagineEvent) {

		Session session =  HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
				session.save(eMagineEvent);
				transaction.commit();
			} catch (HibernateException e) {
				//TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en cas de probl�me
				log.error("Error when tracing event of creation '" + eMagineEvent.getDescription() + "'", e);
			}
	}
	
	
}
