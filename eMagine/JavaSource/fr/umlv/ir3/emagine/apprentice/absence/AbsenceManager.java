package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import fr.umlv.ir3.emagine.modification.ModificationManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class AbsenceManager extends ModificationManager<Absence, AbsenceDAO> {

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

	@Override
	public Absence retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Absence.class, id);
	}
}
