package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class AbsenceDAO extends BaseDAO<Absence> {
	
	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParams
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParams absenceSearchParams) throws EMagineException {
		// TODO fr.umlv.ir3.emagine.apprentice.absence.AbsenceDAO.find(apprentices, absenceSearchParams)
		throw new EMagineException(
				"exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.apprentice.absence.AbsenceDAO.find(apprentices, absenceSearchParams)",
				"numberOfWorkedDays transient");
	}
}
