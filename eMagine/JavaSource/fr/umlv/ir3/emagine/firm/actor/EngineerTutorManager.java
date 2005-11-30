package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class EngineerTutorManager extends BaseManager<EngineerTutor, EngineerTutorDAO>{

	@Override
	public void update(EngineerTutor engineerTutor)
			throws EMagineException {
		//TODO : updateEngineerTutor : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
		//TODO : updateEngineerTutor :  createEngineerTutor :  engineerTutorUnique
		super.update(engineerTutor);
	}

	public List<EngineerTutor> find(EngineerTutorSearchParam engineerTutorSearchParam) throws EMagineException {
		EngineerTutorDAO dao = getDAO();
		return dao.find(engineerTutorSearchParam);
	}
	
	public void addApprentice (Apprentice apprentice, EngineerTutor engineerTutor) throws EMagineException {
		//FIXME: Si l'étudiant existe déjà ?
		//FIXME: Est-ce necessaire d'affecter à l'étudiant , puis d'affecter au tuteur?
		apprentice.setEngineerTutor(engineerTutor);
		List<Apprentice> apprentice2 = engineerTutor.getApprentice();
		apprentice2.add(apprentice);
		update(engineerTutor);
	}

	@Override
	protected EngineerTutorDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getEngineerTutorDAO();
	}

	@Override
	public EngineerTutor retrieve(long id) throws EMagineException {
		EngineerTutorDAO dao = getDAO();
		return dao.retrieve(EngineerTutor.class, id);
	}
}
