/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.event.PostInsertEvent;
import org.hibernate.event.PostInsertEventListener;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

/**
 * @author Administrateur
 *
 */
public class EMaginePostInsertEventListener implements PostInsertEventListener {

	private static final Log log  = LogFactory.getLog(EMaginePostInsertEventListener.class);
	
	private static final long serialVersionUID = -7847641643089637012L;
	/**
	 * @see org.hibernate.event.PostInsertEventListener#onPostInsert(org.hibernate.event.PostInsertEvent)
	 */
	public void onPostInsert(PostInsertEvent event) {

		DAOManager.beginTransaction();
		//		TODO : #45 - lbarbisan - Spécifier l'utilisateur dans l'évènement
		if(event.getEntity() instanceof EventableEntity)
		{
			Event eMagineEvent = new Event();
		
			//TODO : #44 - lbarbisan - Utiliser fillResource de la classe  Bundle
			eMagineEvent.setDescription("Création de :" + event.getEntity().toString());
			eMagineEvent.setDate(new Date());
			eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			//TODO : #45 - lbarbisan
			//eMagineEvent.setType()
			eMagineEvent.setTitle("création");
			
			try {
				DAOManager.getInstance().getEventDAO().create(eMagineEvent);
			} catch (EMagineException e) {
				//TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en cas de problème
				log.error("Error when tracing event of creation '" + event.getEntity() + "'", e);
			}
		}
		try {
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			log.error("Error when tracing event of creation '" + event.getEntity() + "'", e);
		}
	}
}
