package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class EngineerTutorManager extends BaseManagerImpl<EngineerTutor, EngineerTutorDAO>{

	@Override
	public void update(EngineerTutor engineerTutor)
			throws EMagineException {
		// TODO fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager.update(engineerTutor)
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager.update(engineerTutor)");
		//TODO : updateEngineerTutor : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
		//TODO : updateEngineerTutor :  createEngineerTutor :  engineerTutorUnique
		//super.update(engineerTutor);
	}

	/**
	 * Searches for the specified engineerTutorSearchParams
	 * @param engineerTutorSearchParams
	 * @return
	 * @throws EMagineException
	 */
	public List<EngineerTutor> find(EngineerTutorSearchParams engineerTutorSearchParams) throws EMagineException {
		return getDAO().find(engineerTutorSearchParams);
	}
	
	public void addApprentice(Apprentice apprentice, EngineerTutor engineerTutor) throws EMagineException {
		//FIXME: Si l'étudiant existe déjà ?
		//FIXME: Est-ce necessaire d'affecter à l'étudiant , puis d'affecter au tuteur?
		
		apprentice.setEngineerTutor(engineerTutor);
		List<Apprentice> apprentice2 = engineerTutor.getApprentice();
		apprentice2.add(apprentice);
		update(engineerTutor);
		//FIXME : manque les transactions
	}

	@Override
	protected EngineerTutorDAO getDAO() {
		return DAOManager.getInstance().getEngineerTutorDAO();
	}
}
