package fr.umlv.ir3.emagine.statistic;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class StatisticManager extends BaseEditableManagerImpl<Statistic, StatisticDAO> {
	protected StatisticDAO getDAO() {
		return DAOManager.getInstance().getStatisticDAO();
	}
}
