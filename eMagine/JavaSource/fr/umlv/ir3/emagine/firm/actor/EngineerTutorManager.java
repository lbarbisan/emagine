package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public interface EngineerTutorManager extends BaseManager<EngineerTutor, EngineerTutorDAO> {

	/**
	 * Searches for the specified engineerTutorSearchParams
	 * @param engineerTutorSearchParams
	 * @return
	 * @throws EMagineException
	 */
	public abstract List<EngineerTutor> find(
			EngineerTutorSearchParams engineerTutorSearchParams)
			throws EMagineException;

	/**
	 * Adds the specified apprentice to the specified engineerTutor
	 * @param apprentice
	 * @param engineerTutor
	 * @throws EMagineException
	 */
	public abstract void addApprentice(Apprentice apprentice,
			EngineerTutor engineerTutor) throws EMagineException;

}