package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * @author eMagine Team
 * @see fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager
 */
public class AbsenceManagerImpl extends EditableManagerImpl<Absence, AbsenceDAO> implements AbsenceManager {

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager#find(java.util.Collection, fr.umlv.ir3.emagine.apprentice.absence.AbsenceSearchParams)
	 */
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParams absenceSearchParams) throws EMagineException {
		return getDAO().find(apprentices, absenceSearchParams);
	}
	
	@Override
	protected AbsenceDAO getDAO() {
		return DAOManager.getInstance().getAbsenceDAO();
	}
}
