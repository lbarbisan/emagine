package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class EngineerTutorManagerImpl extends EditableManagerImpl<EngineerTutor, EngineerTutorDAO> implements EngineerTutorManager{

	/**
	 * @see fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager#update(fr.umlv.ir3.emagine.firm.actor.EngineerTutor)
	 */
	@Override
	public void update(EngineerTutor engineerTutor)
			throws EMagineException {
		//TODO : updateEngineerTutor :  createEngineerTutor :  engineerTutorUnique
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.firm.actor.EngineerTutorManagerImpl.update(engineerTutor)");
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager#updateWithoutRights(fr.umlv.ir3.emagine.firm.actor.EngineerTutor)
	 */
	@Override
	public void updateWithoutRights(EngineerTutor newEntity) throws EMagineException {
		// TODO Envoyer un event de modif de tuteur ingénieur
		// puis : super.updateWithoutRights(newEntity);
		throw new EMagineException("exception.unimplementedMethod", "enclosing_package.EngineerTutorManagerImpl.updateWithoutRights(enclosing_method_arguments)");
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
		
		try {
			apprentice.setEngineerTutor(engineerTutor);
			List<Apprentice> apprentice2 = engineerTutor.getApprentice();
			apprentice2.add(apprentice);
			update(engineerTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	@Override
	protected EngineerTutorDAO getDAO() {
		return DAOManager.getInstance().getEngineerTutorDAO();
	}
}
