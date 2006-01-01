package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class EngineerTutorManagerImpl extends BaseManagerImpl<EngineerTutor, EngineerTutorDAO> implements EngineerTutorManager{

	/**
	 * @see fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager#update(fr.umlv.ir3.emagine.firm.actor.EngineerTutor)
	 */
	@Override
	public void update(EngineerTutor engineerTutor)
			throws EMagineException {
		// TODO fr.umlv.ir3.emagine.firm.actor.EngineerTutorManagerImpl.update(engineerTutor)
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.firm.actor.EngineerTutorManagerImpl.update(engineerTutor)");
		//TODO : updateEngineerTutor : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
		//TODO : updateEngineerTutor :  createEngineerTutor :  engineerTutorUnique
		//super.update(engineerTutor);
	}

	/**
	 * @see fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager#find(fr.umlv.ir3.emagine.firm.actor.EngineerTutorSearchParams)
	 */
	public List<EngineerTutor> find(EngineerTutorSearchParams engineerTutorSearchParams) throws EMagineException {
		return getDAO().find(engineerTutorSearchParams);
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager#addApprentice(fr.umlv.ir3.emagine.apprentice.Apprentice, fr.umlv.ir3.emagine.firm.actor.EngineerTutor)
	 */
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
