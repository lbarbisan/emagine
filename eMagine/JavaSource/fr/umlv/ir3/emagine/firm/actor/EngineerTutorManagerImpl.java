package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import org.hibernate.HibernateException;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.DefaultAddressEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;

public class EngineerTutorManagerImpl extends EditableManagerImpl<EngineerTutor, EngineerTutorDAO> implements EngineerTutorManager{


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
			engineerTutor.getApprentice().add(apprentice);
			update(engineerTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	public EngineerTutor becomeEngineerTutor(FirmActor firmActor) throws EMagineException
	{	
		DAOManager.beginTransaction();
		EngineerTutor engineerTutor ;
		
		try {
			//Delete Firm
			firmActor.getFirm().getFirmActors().remove(firmActor);
			DAOManager.getInstance().getFirmDAO().update(firmActor.getFirm());
			DAOManager.commitTransaction();
			
			//Pass FirmActor to EngeneersTutor
			DAOManager.beginTransaction();
			engineerTutor = DAOManager.getInstance().getEngineerTutorDAO().becomeEngineerTutor(firmActor);
			DAOManager.getInstance().getEngineerTutorDAO().update(engineerTutor);
			DAOManager.commitTransaction();
		} catch (HibernateException exception) {
			throw new EMagineException("exception.ApprenticeDAO.create", exception);
		}
		return engineerTutor;	
	}

	@Override
	protected EngineerTutorDAO getDAO() {
		return DAOManager.getInstance().getEngineerTutorDAO();
	}
}
