package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class EventManagerImpl extends BaseManagerImpl<Event, EventDAO> implements EventManager {

	// TODO : javadoc
	/**
	 * @see fr.umlv.ir3.emagine.event.EventManager#find(fr.umlv.ir3.emagine.util.base.BaseEntity, fr.umlv.ir3.emagine.event.EventSearchParams)
	 */
	public List<Event> find(BaseEntity entity, EventSearchParams eventSearchParams) throws EMagineException {
		return getDAO().find(entity, eventSearchParams);
	}

	protected EventDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getEventDAO();
	}
}
