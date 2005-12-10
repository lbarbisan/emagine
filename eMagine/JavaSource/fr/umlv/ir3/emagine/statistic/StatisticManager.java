package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class StatisticManager extends BaseEditableManagerImpl<Statistic, StatisticDAO> {

	public List<Statistic> findAll() throws EMagineException {
		StatisticDAO dao = getDAO();
		return dao.findAll();
	}
	
	protected StatisticDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getStatisticDAO();
	}
}
