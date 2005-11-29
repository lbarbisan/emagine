package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class StatisticManager extends BaseEditableManager<Statistic, StatisticDAO> {

	public List<Statistic> getStatistics() throws EMagineException {
		return getDAO().getStatistics();
	}
	
	protected StatisticDAO getDAO() {
		return DAOManager.getInstance().getStatisticDAO();
	}

	@Override
	public Statistic retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Statistic.class, id);
	}
}
