package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class ApprenticeManager extends BaseEventableManager<Apprentice, ApprenticeDAO> {

	/**
	 * Excludes the given apprentice
	 * @param apprentice
	 * @throws EMagineException throw if the apprentice doesn't exist or if an SQLException occures
	 */
	public void excludeApprentice(Apprentice apprentice) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			apprentice.setExcluded(true);
			ApprenticeDAO dao = getDAO();
			dao.update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Move up the given apprentices in the upper courseOption level
	 * @param apprentice
	 * @throws EMagineException throw if an apprentice doesn't exist or if an SQLException occures
	 */
	public void moveUpApprentice(Collection<Apprentice> apprentices) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			ApprenticeDAO dao = getDAO();
			for (Apprentice apprentice : apprentices) {
				// TODO : voir une meilleur implémentation que ce foreach
				Integer year = apprentice.getYear();
				apprentice.setYear(year + 1);
				dao.update(apprentice);
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Adds the given absence to the given apprentice
	 * @param apprentice
	 * @param absence
	 * @throws EMagineException throws if an SQLException occures
	 */
	public void addAbsence(Apprentice apprentice, Absence absence) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Absence> absences = apprentice.getAbsences();
			absences.add(absence);
			ApprenticeDAO dao = getDAO();
			dao.update(apprentice);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Removes the given absence from the given apprentice
	 * @param apprentice
	 * @param absence
	 * @throws EMagineException throws if an SQLException occures
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
	 * Updates the given apprentice. If the teachingTutor, the engineerTutor, or the firm of him or her is modified, adds an event to remember the old one.
	 * @param apprentice
	 * @throws EMagineException throws if an SQLException occures
	 */
	public void update(Apprentice apprentice) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Apprentice oldApprentice = retrieve(apprentice.getId());
			// Comparison of the teacherTutors
			TeacherTutor teacherTutor = apprentice.getTeacherTutor();
			TeacherTutor oldTeacherTutor = oldApprentice.getTeacherTutor();
			if (!teacherTutor.equals(oldTeacherTutor)) {
				Event event = new Event();
				// TODO : initialiser l'event
				addEvent(apprentice, event);
			}
			
			// Comparison of the engineerTutor
			EngineerTutor engineerTutor = apprentice.getEngineerTutor();
			EngineerTutor oldEngineerTutor = oldApprentice.getEngineerTutor();
			if (!engineerTutor.equals(oldEngineerTutor)) {
				Event event = new Event();
				// TODO : initialiser l'event
				addEvent(apprentice, event);
			}
			
			// Comparison of the firm
			Firm firm = apprentice.getFirm();
			Firm oldFirm = oldApprentice.getFirm();
			if (!firm.equals(oldFirm)) {
				Event event = new Event();
				// TODO : initialiser l'event
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
	
	
	
	@Override
	protected ApprenticeDAO getDAO() {
		return DAOManager.getInstance().getApprenticeDAO();
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO ApprenticeManager.extract()
		return null;
	}
}
