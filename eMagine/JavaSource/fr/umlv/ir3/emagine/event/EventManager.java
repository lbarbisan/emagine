package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class EventManager extends BaseManager<Event, EventDAO> {

	public List<Event> getEvents(EventSearchParam eventSearchParam) throws EMagineException {
		return getDAO().getEvents(eventSearchParam);
	}
	
	protected EventDAO getDAO() {
		return DAOManager.getInstance().getEventDAO();
	}
}
