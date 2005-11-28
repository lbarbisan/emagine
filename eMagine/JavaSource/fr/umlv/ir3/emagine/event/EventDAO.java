package fr.umlv.ir3.emagine.event;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class EventDAO extends BaseDAO<Event> {
	@Override
	public Event retrieve(long id) {
	  	return (Event) HibernateUtils.getSession().load(Event.class, id);
	}
}
