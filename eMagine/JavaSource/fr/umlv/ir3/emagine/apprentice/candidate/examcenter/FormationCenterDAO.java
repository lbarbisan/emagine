package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

/**
 * DAO For FormationCenter Data in Database
 * @author Laurent
 */
public class FormationCenterDAO extends BaseDAO<FormationCenter> {

	/**
	 * Searches for the given formationCenterSearchParams
	 * @param formationCenterSearchParams
	 * @return FormationCenter's List
	 * @throws EMagineException if error accurs during find
	 */
	public List<FormationCenter> find(FormationCenterSearchParams formationCenterSearchParams) throws EMagineException {
		// TODO fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO.find(formationCenterSearchParams)
		throw new EMagineException(
				"exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO.find(formationCenterSearchParams)");
		/*
		 * 	gérer les numberOfRooms et totalFreeSits
		 */
	}
}
