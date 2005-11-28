package fr.umlv.ir3.emagine.apprentice;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EditableManager;

public class ApprenticeManager extends EditableManager<Apprentice, ApprenticeDAO> {

	/**
	 * Lists apprentices, using the given search parameters
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Apprentice> getApprentices(ApprenticeSearchParam apprenticeSearchParam) throws EMagineException {
		return getDAO().getApprentices(apprenticeSearchParam);
	}

	@Override
	protected ApprenticeDAO getDAO() {
		return DAOManager.getInstance().getApprenticeDAO();
	}
}
