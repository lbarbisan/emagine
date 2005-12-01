package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class AbsenceManager extends BaseEditableManager<Absence, AbsenceDAO> {

	/**
	 * Lists absences, using the given search parameters
	 * @param absenceSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(AbsenceSearchParam absenceSearchParam) throws EMagineException {
		return getDAO().find(absenceSearchParam);
	}
	
	@Override
	protected AbsenceDAO getDAO() {
		return DAOManager.getInstance().getAbsenceDAO();
	}

	@Override
	public Absence retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Absence.class, id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO AbsenceManager.extract()
		return null;
	}
}
