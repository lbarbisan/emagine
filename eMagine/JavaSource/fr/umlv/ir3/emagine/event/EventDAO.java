package fr.umlv.ir3.emagine.event;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class EventDAO extends BaseDAO<Event> {

	public List<Event> find(BaseEntity entity, EventSearchParam eventSearchParam) throws EMagineException {
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		List list = createQuery.list();
		return list;
	}
}
