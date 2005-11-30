package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class EventDAO extends BaseDAO<Event> {

	public List<Event> find(BaseEntity entity, EventSearchParam eventSearchParam) throws EMagineException {
		String query = "";
		return HibernateUtils.getSession().createQuery(query).list();
	}
}
