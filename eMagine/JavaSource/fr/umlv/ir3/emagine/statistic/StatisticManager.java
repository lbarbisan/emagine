package fr.umlv.ir3.emagine.statistic;

import java.util.List;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class StatisticManager extends BaseEditableManager<Statistic, StatisticDAO> {

	public List<Statistic> findAll() throws EMagineException {
		StatisticDAO dao = getDAO();
		return dao.findAll();
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

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO StatisticManager.extract()
		return null;
	}
}
