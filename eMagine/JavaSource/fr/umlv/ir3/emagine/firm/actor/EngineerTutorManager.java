package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;

@MustHaveRights("engineerTutor")
public interface EngineerTutorManager extends EditableManager<EngineerTutor, EngineerTutorDAO> {

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
	@MustHaveRights("engineerTutor.update")
	public abstract void addApprentice(Apprentice apprentice,
			EngineerTutor engineerTutor) throws EMagineException;

}