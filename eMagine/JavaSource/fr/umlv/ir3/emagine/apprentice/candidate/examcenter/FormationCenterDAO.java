package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FormationCenterDAO extends BaseDAO<FormationCenter> {

	/**
	 * Searches for the given formationCenterSearchParams
	 * @param formationCenterSearchParams
	 * @return
	 * @throws EMagineException
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
