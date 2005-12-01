package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class ApprenticeManager extends BaseEventableManager<Apprentice, ApprenticeDAO> {

	/**
	 * Lists apprentices, using the given search parameters
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Apprentice> find(ApprenticeSearchParam apprenticeSearchParam) throws EMagineException {
		return getDAO().find(apprenticeSearchParam);
	}

	/**
	 * Excludes the given apprentice
	 * @param apprentice
	 * @throws EMagineException throw if the apprentice doesn't exist or if an SQLException occures
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
	 * Move up the given apprentices in the upper courseOption level
	 * @param apprentice
	 * @throws EMagineException throw if an apprentice doesn't exist or if an SQLException occures
	 */
	public void moveUpApprentice(Collection<Apprentice> apprentices) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			for (Apprentice apprentice : apprentices) {
				// TODO : voir une meilleur implémentation que ce foreach
				apprentice.setYear(apprentice.getYear() + 1);
				getDAO().update(apprentice);
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
			apprentice.getAbsences().add(absence);
			getDAO().update(apprentice);
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
			if (!apprentice.getTeacherTutor().equals(oldApprentice.getTeacherTutor())) {
				Event event = new Event();
				// TODO : initialiser l'event
				addEvent(apprentice, event);
			}
			
			// Comparison of the engineerTutor
			if (!apprentice.getEngineerTutor().equals(oldApprentice.getEngineerTutor())) {
				Event event = new Event();
				// TODO : initialiser l'event
				addEvent(apprentice, event);
			}
			
			// Comparison of the firm
			if (!apprentice.getFirm().equals(oldApprentice.getFirm())) {
				Event event = new Event();
				// TODO : initialiser l'event
				addEvent(apprentice, event);
			}
			
			getDAO().update(apprentice);
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
	public Apprentice retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Apprentice.class, id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO ApprenticeManager.extract()
		return null;
	}
}
