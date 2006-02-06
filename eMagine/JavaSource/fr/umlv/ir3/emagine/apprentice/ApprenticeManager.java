package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.EventableManager;

@MustHaveRights("apprentice")
public interface ApprenticeManager extends EventableManager<Apprentice, ApprenticeDAO> {

	/**
	 * Excludes the given apprentice
	 * @param apprentice
	 * @throws EMagineException throw if the apprentice doesn't exist or if an SQLException occures
	 */
	public abstract void excludeApprentice(Apprentice apprentice)
			throws EMagineException;

	/**
	 * Move up the given apprentices in the upper courseOption level
	 * @param apprentice
	 * @throws EMagineException throw if an apprentice doesn't exist or if an SQLException occures
	 */
	public abstract void moveUpApprentice(Collection<Apprentice> apprentices)
			throws EMagineException;

	/**
	 * Adds the given absence to the given apprentice
	 * @param apprentice
	 * @param absence
	 * @throws EMagineException throws if an SQLException occures
	 */
	@MustHaveRights("apprentice.update")
	public abstract void addAbsence(Apprentice apprentice, Absence absence)
			throws EMagineException;

	/**
	 * Removes the given absence from the given apprentice
	 * @param apprentice
	 * @param absence
	 * @throws EMagineException throws if an SQLException occures
	 */
	@MustHaveRights("apprentice.update")
	public abstract void removeAbsence(Apprentice apprentice, Absence absence)
			throws EMagineException;

	/**
	 * Updates the given apprentice. If the teachingTutor, the engineerTutor, or the firm of him or her is modified, adds an event to remember the old one.
	 * @param apprentice
	 * @throws EMagineException throws if an SQLException occures
	 */
	public abstract void update(Apprentice apprentice) throws EMagineException;

	/**
	 * Searches for the given apprenticeSearchParams
	 * @param apprenticeSearchParams
	 * @return
	 * @throws EMagineException 
	 */
	public abstract List<Apprentice> find(
			ApprenticeSearchParam apprenticeSearchParams)
			throws EMagineException;
	/**
	 * Pass an apprentice
	 * @param candidate
	 * @return
	 * @throws EMagineException
	 */
	public abstract Apprentice Integrate(
			Candidate candidate) 
			throws EMagineException;

}