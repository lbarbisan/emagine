package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class StatisticManager extends BaseManager<Statistic, StatisticDAO> {

	public List<Statistic> getStatistics() throws EMagineException {
		return getDAO().getStatistics();
	}
	
	protected StatisticDAO getDAO() {
		return DAOManager.getInstance().getStatisticDAO();
	}
}
