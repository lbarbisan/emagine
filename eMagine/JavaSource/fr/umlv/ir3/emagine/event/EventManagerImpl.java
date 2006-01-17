package fr.umlv.ir3.emagine.event;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class EventManagerImpl extends BaseManagerImpl<Event, EventDAO> implements EventManager {

	protected EventDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getEventDAO();
	}
}
