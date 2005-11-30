package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class StatisticManager extends BaseEditableManager<Statistic, StatisticDAO> {

	public List<Statistic> find() throws EMagineException {
		StatisticDAO dao = getDAO();
		return dao.find();
	}
	
	protected StatisticDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getStatisticDAO();
	}

	@Override
	public Statistic retrieve(long id) throws EMagineException {
		StatisticDAO dao = getDAO();
		return dao.retrieve(Statistic.class, id);
	}
}
