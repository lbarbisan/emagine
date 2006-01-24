/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.event.PostDeleteEvent;
import org.hibernate.event.PostDeleteEventListener;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

/**
 * @author Administrateur
 *
 */
public class EMaginePostDeleteEventListener implements PostDeleteEventListener {

	private static final long serialVersionUID = -7867858900899415259L;
	
	private static final Log log  = LogFactory.getLog(EMaginePostDeleteEventListener.class);

	/**
	 * @see org.hibernate.event.PostDeleteEventListener#onPostDelete(org.hibernate.event.PostDeleteEvent)
	 */
	public void onPostDelete(PostDeleteEvent event) {
		
//		TODO : #45 - lbarbisan - Spécifier l'utilisateur dans l'évènement
		if(event.getEntity() instanceof EventableEntity)
		{
			Event eMagineEvent = new Event();
		
			//TODO : #44 - lbarbisan - Utiliser fillResource de la classe  Bundle
			eMagineEvent.setDescription("Suppression de :" + event.getEntity().toString());
			eMagineEvent.setDate(new Date());
			eMagineEvent.getSources().add((BaseEntity) event.getEntity());
			//TODO : #45 - lbarbisan
			//eMagineEvent.setType()
			eMagineEvent.setTitle("Suppression");
			
			try {
				ManagerManager.getInstance().getEventManager().create(eMagineEvent);
			} catch (EMagineException e) {
				//TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en cas de problème
				log.error("Error when tracing event of deleting'" + event.getEntity() + "'", e);
			}
		}
	}
}
