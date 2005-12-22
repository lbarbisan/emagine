package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class AbsenceManager extends EditableManagerImpl<Absence, AbsenceDAO> {

	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParams
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParams absenceSearchParams) throws EMagineException {
		AbsenceDAO dao = getDAO();
		return dao.find(apprentices, absenceSearchParams);
	}
	
	@Override
	protected AbsenceDAO getDAO() {
		return DAOManager.getInstance().getAbsenceDAO();
	}
}
