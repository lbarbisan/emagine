package fr.umlv.ir3.emagine.util;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.event.PostUpdateEvent;
import org.hibernate.event.PostUpdateEventListener;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

public class EMaginePostUpdateEventListener implements PostUpdateEventListener {

	private static final long serialVersionUID = -9052907653386941044L;

	private static final Log log  = LogFactory.getLog(EMaginePostUpdateEventListener.class);
	
	public void onPostUpdate(PostUpdateEvent event) {
		
//		TODO : #45 - lbarbisan - Spécifier l'utilisateur dans l'évènement
		if(event.getEntity() instanceof EventableEntity)
		{
			for(int index =0;index < event.getPersister().getPropertyNames().length ;index++)
			{
				Object Obj1 = event.getState()[index];
				Object Obj2 = event.getOldState()[index];
				
				if(!(Obj1!=null ^ Obj2!=null) &&
				((Obj1==null && Obj2==null) || 
						Obj1.equals(Obj2)))
				{
				Event eMagineEvent = new Event();
				
				//TODO : #44 - lbarbisan - Utiliser fillResource de la classe  Bundle
				eMagineEvent.setDescription("Modification de :" + event.getEntity().toString()+
						"." + event.getPersister().getPropertyNames()[index] + " " +
						"de " + Obj2 + " vers " + Obj1);
				eMagineEvent.setDate(new Date());
				eMagineEvent.getSources().add((BaseEntity) event.getEntity());
				//TODO : #45 - lbarbisan
				//eMagineEvent.setType()
				eMagineEvent.setTitle("création");
				
				try {
					ManagerManager.getInstance().getEventManager().create(eMagineEvent);
				} catch (EMagineException e) {
					//TODO : #46 - lbarbisan - Remonter et transmettre l'exeption en cas de problème
					log.error("Error when tracing event of creation'" + event.getEntity() + "'", e);
				}	
			}
			}
		}
	}
}
