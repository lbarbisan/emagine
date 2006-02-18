/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import java.util.Date;

import javax.print.attribute.standard.Fidelity;

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

import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.ManagerManager;
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
			EventableEntity eventableEntity = (EventableEntity) event
					.getEntity();
			Event eMagineEvent = new Event();

			eMagineEvent.setDescription("Création de :"
					+ eventableEntity.toString());
			eMagineEvent.setDate(new Date());
			// eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			eMagineEvent.setTitle("création");

			createEvent(eMagineEvent);
		}
	}

	/**
	 * @see org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate.event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		if (event.getEntity() instanceof EventableEntity) {
			if (event.getEntity() instanceof EventableEntity) {
				EventableEntity eventableEntity = (EventableEntity) event
						.getEntity();
				Event eMagineEvent = new Event();

				eMagineEvent.setDescription("Suppression de :"
						+ eventableEntity.toString());
				eMagineEvent.setDate(new Date());
				// eMagineEvent.getSources().add((BaseEntity)
				// event.getEntity());
				eMagineEvent.setTitle("Suppression");
			}
		}
	}

	public void onPostUpdate(PostUpdateEvent event) {
		if (event.getEntity() instanceof EventableEntity) {
			EventableEntity eventableEntity = (EventableEntity) event
					.getEntity();
			Event eMagineEvent = new Event();
			Date date = new Date();

			eMagineEvent.setDescription("Mise à jour de :"
					+ eventableEntity.toString());
			eMagineEvent.setDate(date);
			// eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			eMagineEvent.setTitle("Mise à jour");

			try {
				logChanges(event);
			} catch (EMagineException e) {
				// FIXME : SecurityFilterNotInitializedException.e Not
				// Implemented
				e.printStackTrace();
			}

			createEvent(eMagineEvent);
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

		// Iterate through all the fields in the object
		for (int index = 0; index < types.length; index++) {
			String fieldName = name[index];
			if (!fieldName.equals("id")) {
				if (states[index] == null ^ oldStates[index] == null) {
					Event event = new Event();
					event.setUserComment("no comment");
					event.setConnectedUser(SessionManager.getInstance()
							.getCurrentUser().getHumanName());
					event.setDate(new Date());
					event.setProperty(fieldName);
					if(states[index]==null)
						event.setDescription("Initialisation de la valeur");
					else
						event.setDescription("suppression de la valeur");
					event.setNewValue(states[index]==null ? "":states[index].toString());
					event.setOldValue(oldStates[index]==null ? "":oldStates[index].toString());
					event.setDescription("");
					event.setTitle("Modification paramètres");
					createEvent(event);					
				} else if (states[index] != null && oldStates[index] != null) {
					Class interfaces[] = states[index].getClass().getInterfaces();
					for (int index2 = 0; index2 < interfaces.length; index2++) {
						if (!interfaces[index2].getName().equals("java.util.Collection")) {
							// FIXME : Gérer les exceptions
							index2 = interfaces.length;
						} else if (interfaces[index2].getName().equals("fr.umlv.ir3.emagine.base.BaseEntity")) {
							// FIXME : Récurrence pour les objets
							index2 = interfaces.length;
						} else {
							Event event = new Event();
							event.setUserComment("no comment");
							event.setConnectedUser(SessionManager.getInstance()
									.getCurrentUser().getHumanName());
							event.setDate(new Date());
							event.setProperty(fieldName);
							if(states[index]==null)
								event.setDescription("Initialisation de la valeur");
							else
								event.setDescription("suppression de la valeur");
							event.setNewValue(states[index]==null ? "":states[index].toString());
							event.setOldValue(oldStates[index]==null ? "":oldStates[index].toString());
							event.setDescription("");
							event.setTitle("Modification paramètres");
							event.setDescription("Modification de la propriété");
							event.setTitle("Modification paramètres");
							event.setType((EventTypeEnum)
									 ManagerManager.getInstance().getEmagineEnumManager()
									 .find(EventTypeEnum.MOD_GENERAL,EventTypeEnum.class) );
							
							createEvent(event);
							
							index2 = interfaces.length;
						}
					}
				}
			}
		}
	}

	/**
	 * Create an evenement
	 * 
	 * @param eventableEntity
	 */
	private void createEvent(Event eMagineEvent) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(eMagineEvent);
			transaction.commit();
		} catch (HibernateException e) {
			// TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en
			// cas de problème
			log.error("Error when tracing event '"
					+ eMagineEvent.getDescription() + "'", e);
		}
		session.close();
	}

}
