package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class EventManager extends BaseManager<Event, EventDAO> {

	public List<Event> find(BaseEntity entity, EventSearchParam eventSearchParam) throws EMagineException {
		EventDAO dao = getDAO();
		return dao.find(entity, eventSearchParam);
	}

	protected EventDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getEventDAO();
	}

	@Override
	public Event retrieve(long id) throws EMagineException {
		EventDAO dao = getDAO();
		return dao.retrieve(Event.class, id); 
	}
}
