package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.EventableManagerImpl;

public class ApprenticeManagerImpl extends EventableManagerImpl<Apprentice, ApprenticeDAO> implements ApprenticeManager {

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#excludeApprentice(fr.umlv.ir3.emagine.apprentice.Apprentice)
	 */
	public void excludeApprentice(Apprentice apprentice) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			apprentice.setExcluded(true);
			getDAO().update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#moveUpApprentice(java.util.Collection)
	 */
	public void moveUpApprentice(Collection<Apprentice> apprentices) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			ApprenticeDAO dao = getDAO();
			for (Apprentice apprentice : apprentices) {
				// TODO : voir une meilleur implémentation que ce foreach
				//Integer year = apprentice.getYear();
				//apprentice.setYear(year + 1);
				ManagerManager managerManager = ManagerManager.getInstance();
				EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
				YearEnum year = (YearEnum)emagineEnumManager.retrieve(apprentice.getYear().getId() + 1, YearEnum.class);
				apprentice.setYear(year);
				dao.update(apprentice);
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#addAbsence(fr.umlv.ir3.emagine.apprentice.Apprentice, fr.umlv.ir3.emagine.apprentice.absence.Absence)
	 */
	public void addAbsence(Apprentice apprentice, Absence absence) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Absence> absences = apprentice.getAbsences();
			absences.add(absence);
			getDAO().update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	public Apprentice integrate(Candidate candidate) throws EMagineException
	{	
		DAOManager.beginTransaction();
		Apprentice apprentice ;
		
		try {
			DAOManager.getInstance().getCandidateDAO().delete(candidate);
			DAOManager.commitTransaction();
			DAOManager.beginTransaction();
			apprentice = DAOManager.getInstance().getApprenticeDAO().Integrate(candidate);
			DefaultAddressEnum defaultAddressEnum= (DefaultAddressEnum) ManagerManager.getInstance().getEmagineEnumManager().find("Personnelle", DefaultAddressEnum.class);
			apprentice.setDefaultAddress(defaultAddressEnum);
			getDAO().update(apprentice);
			DAOManager.commitTransaction();
		} catch (HibernateException exception) {
			throw new EMagineException("exception.ApprenticeDAO.create", exception);
		}
		return apprentice;	
	}

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#removeAbsence(fr.umlv.ir3.emagine.apprentice.Apprentice, fr.umlv.ir3.emagine.apprentice.absence.Absence)
	 */
	public void removeAbsence(Apprentice apprentice, Absence absence) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Absence> absences = apprentice.getAbsences();
			absences.remove(absence);
			getDAO().update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#update(fr.umlv.ir3.emagine.apprentice.Apprentice)
	 */
	public void update(Apprentice apprentice) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			//throw new EMagineException("exception.todo", "Initialiser l'event"); // TODO : le code commenté est bon, mais il faut initialiser l'évennement
			Apprentice oldApprentice = retrieve(apprentice.getId());
			// Comparison of the teacherTutors
			TeacherTutor teacherTutor = apprentice.getTeacherTutor();
			TeacherTutor oldTeacherTutor = oldApprentice.getTeacherTutor();
			if (teacherTutor != null && !teacherTutor.equals(oldTeacherTutor)) {
				Event event = new Event();
				//event.setType(EventTypeEnum.MODIFICATION); // TODO : event.setType (EventTypeEnum)
				event.setTitle(Bundles.getMessageResources().getMessage("event.apprentice.update.teacherTutor.title"));
				event.setUserComment(Bundles.getMessageResources().getMessage("event.apprentice.update.teacherTutor.comment", oldTeacherTutor.getFirstName(), oldTeacherTutor.getLastName()));
				//event.getSources().add(apprentice);
				addEvent(apprentice, event);
			}
			
			// Comparison of the engineerTutor
			EngineerTutor engineerTutor = apprentice.getEngineerTutor();
			EngineerTutor oldEngineerTutor = oldApprentice.getEngineerTutor();
			if (engineerTutor != null && !engineerTutor.equals(oldEngineerTutor)) {
				Event event = new Event();
				//event.setType(EventTypeEnum.MODIFICATION); // TODO : event.setType (EventTypeEnum)
				event.setTitle(Bundles.getMessageResources().getMessage("event.apprentice.update.engineerTutor.title"));
				event.setUserComment(Bundles.getMessageResources().getMessage("event.apprentice.update.engineerTutor.comment", oldEngineerTutor.getFirstName(), oldEngineerTutor.getLastName()));
				//event.getSources().add(apprentice);
				addEvent(apprentice, event);
			}
			
			// Comparison of the firm
			Firm firm = apprentice.getFirm();
			Firm oldFirm = oldApprentice.getFirm();
			if (firm != null && !firm.equals(oldFirm)) {
				Event event = new Event();
				//event.setType(EventTypeEnum.MODIFICATION); // TODO : event.setType (EventTypeEnum)
				event.setTitle(Bundles.getMessageResources().getMessage("event.apprentice.update.firm.title"));
				event.setUserComment(Bundles.getMessageResources().getMessage("event.apprentice.update.firm.comment", oldFirm.getName(), oldFirm.getAddress()));
				//event.getSources().add(apprentice);
				addEvent(apprentice, event);
			}
			
			ApprenticeDAO dao = getDAO();
			dao.update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.apprentice.ApprenticeManager#find(fr.umlv.ir3.emagine.apprentice.ApprenticeSearchParams)
	 */
	public List<Apprentice> find(ApprenticeSearchParam apprenticeSearchParams) throws EMagineException {
		return super.find(apprenticeSearchParams);
	}
	
	@Override
	protected ApprenticeDAO getDAO() {
		return DAOManager.getInstance().getApprenticeDAO();
	}
}
