package fr.umlv.ir3.emagine.statistic;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;


public class StatisticManagerImpl extends EditableManagerImpl<Statistic, StatisticDAO> implements StatisticManager {
	protected StatisticDAO getDAO() {
		return DAOManager.getInstance().getStatisticDAO();
	}
}
