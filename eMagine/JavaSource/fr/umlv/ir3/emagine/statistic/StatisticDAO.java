package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class StatisticDAO extends BaseDAO<Statistic> {
	@Override
	public Statistic retrieve(long id) {
	  	return (Statistic) HibernateUtils.getSession().load(Statistic.class, id);
	}

	public List<Statistic> getStatistics() throws EMagineException {
		// TODO StatisticDAO.getStatistics()
		return null;
	}
}
