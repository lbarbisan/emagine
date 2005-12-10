package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class AbsenceManager extends BaseEditableManagerImpl<Absence, AbsenceDAO> {

	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParam
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParam absenceSearchParam) throws EMagineException {
		AbsenceDAO dao = getDAO();
		return dao.find(apprentices, absenceSearchParam);
	}
	
	@Override
	protected AbsenceDAO getDAO() {
		return DAOManager.getInstance().getAbsenceDAO();
	}
}
