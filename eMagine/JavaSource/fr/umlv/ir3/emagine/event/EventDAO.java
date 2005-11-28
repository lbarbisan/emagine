package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class EventDAO extends BaseDAO<Event> {
	@Override
	public Event retrieve(long id) {
	  	return (Event) HibernateUtils.getSession().load(Event.class, id);
	}

	public List<Event> getEvents(EventSearchParam eventSearchParam) throws EMagineException {
		// TODO EventDAO.getEvents()
		return null;
	}
}
