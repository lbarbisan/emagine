package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class StatisticDAO extends BaseDAO<Statistic> {

	public List<Statistic> findAll() throws EMagineException {
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		List list = createQuery.list();
		return list;
	}
}
