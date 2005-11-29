package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EditableManager;

public class AbsenceManager extends EditableManager<Absence, AbsenceDAO> {

	/**
	 * Lists absences, using the given search parameters
	 * @param absenceSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> getAbsences(AbsenceSearchParam absenceSearchParam) throws EMagineException {
		return getDAO().getAbsences(absenceSearchParam);
	}
	
	@Override
	protected AbsenceDAO getDAO() {
		return DAOManager.getInstance().getAbsenceDAO();
	}
}
