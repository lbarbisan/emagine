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
import org.hibernate.type.Type;

import fr.umlv.ir3.emagine.security.SecurityFilterNotInitializedException;
import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

/**
 * @author Administrateur
 * 
 */
public class EMaginePostEventListener implements PostInsertEventListener,
		PostDeleteEventListener, PostUpdateEventListener {

	private static final Log log = LogFactory
			.getLog(EMaginePostEventListener.class);

	private static final long serialVersionUID = -7847641643089637012L;

	// TODO : #45 - lbarbisan - Spécifier l'utilisateur dans l'évènement
	// TODO : #52 - lbarbisan - Mettre en place la gestion des evènements avec
	// annotations
	// TODO : #44 - lbarbisan - Utiliser fillResource de la classe Bundle
	// TODO : #54 - lbarbisan - Regarder les propriétés modifiées
	/**
	 * @see org.hibernate.event.PostInsertEventListener#onPostInsert(org.hibernate.event.PostInsertEvent)
	 */
	public void onPostInsert(PostInsertEvent event) {
		if (event.getEntity() instanceof EventableEntity) {
			EventableEntity eventableEntity = (EventableEntity) event.getEntity();
			
			Event eMagineEvent = new Event();

			try {
				eMagineEvent.setConnectedUser(SessionManager.getInstance().getCurrentUser().getHumanName());
				eMagineEvent.setTitle("création");
				eMagineEvent.setDescription("Création de :"+ eventableEntity.toString());
				eMagineEvent.setUserComment("no comment");
				eMagineEvent.setDate(new Date());
			} catch (SecurityFilterNotInitializedException e) {	
				//FIXME : Manage Exception
				e.printStackTrace();
			}
			
			((EventableEntity)event.getEntity()).getEvents().add(eMagineEvent);
			eMagineEvent.setSource((BaseEntity) event.getEntity());			
		}
	}

	/**
	 * @see org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate.event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		if (event.getEntity() instanceof EventableEntity) {
			EventableEntity eventableEntity = (EventableEntity) event.getEntity();
			
			Event eMagineEvent = new Event();

			try {
				eMagineEvent.setConnectedUser(SessionManager.getInstance().getCurrentUser().getHumanName());
				eMagineEvent.setTitle("Suppression");
				eMagineEvent.setDescription("Suppression de :"+ eventableEntity.toString());
				eMagineEvent.setUserComment("no comment");
				eMagineEvent.setDate(new Date());
			} catch (SecurityFilterNotInitializedException e) {	
				//FIXME : Manage Exception
				e.printStackTrace();
			}
			
			((EventableEntity)event.getEntity()).getEvents().add(eMagineEvent);
			eMagineEvent.setSource((BaseEntity) event.getEntity());
		}
	}
		
	public void onPostUpdate(PostUpdateEvent event) {
//		if (event.getEntity() instanceof EventableEntity) {
//			EventableEntity eventableEntity = (EventableEntity) event.getEntity();
//			
//			Event eMagineEvent = new Event();
//
//			try {
//				eMagineEvent.setConnectedUser(SessionManager.getInstance().getCurrentUser().getHumanName());
//				eMagineEvent.setTitle("Modification");
//				eMagineEvent.setDescription("Modification de :"+ eventableEntity.toString());
//				eMagineEvent.setUserComment("no comment");
//				eMagineEvent.setDate(new Date());
//			} catch (SecurityFilterNotInitializedException e) {	
//				//FIXME : Manage Exception
//				e.printStackTrace();
//			}
//			
//			((EventableEntity)event.getEntity()).getEvents().add(eMagineEvent);
//			eMagineEvent.setSource((BaseEntity) event.getEntity());
//		}
		
		try {
			logChanges(event);
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}
		
	}

	private void logChanges(PostUpdateEvent postUpdateEvent)
			throws EMagineException {

		// get an array of all fields in the class including those in
		// superclasses if this is a subclass.
		Object[] states = postUpdateEvent.getState();
		Object[] oldStates = postUpdateEvent.getOldState();
		String[] name = postUpdateEvent.getPersister().getPropertyNames();
		Type[] types = postUpdateEvent.getPersister().getPropertyTypes();
		
		Event event;

		// Iterate through all the fields in the object
		for (int index = 0; index < types.length; index++) {
			if(!"Collection".equals(types[index].getReturnedClass().getSimpleName()))
			{
			String fieldName = name[index];
			
			event = new Event();
			event.setUserComment("no comment");
			event.setConnectedUser(SessionManager.getInstance().getCurrentUser().getHumanName());
			event.setDate(new Date());
			event.setNewValue(states[index]==null ? "":states[index].toString());
			event.setOldValue(oldStates[index]==null ? "":oldStates[index].toString());
			event.setProperty(fieldName);
			event.setTitle("Modification paramètres");
			event.setDescription(states[index]==null ? "Initialisation de la valeur" : "Suppression de la valeur");

			if(!event.getNewValue().equals(event.getOldValue()))
			{
				((EventableEntity)postUpdateEvent.getEntity()).getEvents().add(event);
				event.setSource((BaseEntity) postUpdateEvent.getEntity());
			}
			}
		}
	
	}

//	/**
//	 * Create an evenement
//	 * 
//	 * @param eventableEntity
//	 */
//	private void createEvent(Event eMagineEvent) {
//
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		Transaction transaction = session.beginTransaction();
//		try {
//			session.save(eMagineEvent);
//			transaction.commit();
//		} catch (HibernateException e) {
//			// TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en
//			// cas de problème
//			log.error("Error when tracing event '"
//					+ eMagineEvent.getDescription() + "'", e);
//		}
//		//session.close();
//	}

}
