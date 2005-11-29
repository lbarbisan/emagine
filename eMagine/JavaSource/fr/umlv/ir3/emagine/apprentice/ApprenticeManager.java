package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.modification.ModificationManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class ApprenticeManager extends ModificationManager<Apprentice, ApprenticeDAO> {

	/**
	 * Lists apprentices, using the given search parameters
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Apprentice> getApprentices(ApprenticeSearchParam apprenticeSearchParam) throws EMagineException {
		return getDAO().getApprentices(apprenticeSearchParam);
	}

	/**
	 * Excludes the given apprentice
	 * @param apprentice
	 * @throws EMagineException throw if the apprentice doesn't exist or if an SQLException occures
	 */
	public void excludeApprentice(Apprentice apprentice) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			getDAO().excludeApprentice(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Move up the given apprentices in the upper courseOption level
	 * @param apprentice
	 * @throws EMagineException throw if an apprentice doesn't exist or if an SQLException occures
	 */
	public void moveUpApprentice(Collection<Apprentice> apprentices) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			getDAO().moveUpApprentice(apprentices);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	@Override
	protected ApprenticeDAO getDAO() {
		return DAOManager.getInstance().getApprenticeDAO();
	}

	@Override
	public Apprentice retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Apprentice.class, id);
	}
}
