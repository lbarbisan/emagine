package fr.umlv.ir3.emagine.statistic;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;

public class StatisticManager extends EditableManagerImpl<Statistic, StatisticDAO> {
	protected StatisticDAO getDAO() {
		return DAOManager.getInstance().getStatisticDAO();
	}
}
