package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * @author eMagine Team
 *
 */
public interface FormationCenterManager extends EditableManager<FormationCenter, FormationCenterDAO> {

	/**
	 * Adds the given room to the given formationCenter
	 * @param formationCenter
	 * @param room
	 * @throws EMagineException throws if an SQLException occures
	 */
	public abstract void addRoom(FormationCenter formationCenter, Room room)
			throws EMagineException;

	/**
	 * Removes the given room from the given formationCenter
	 * @param formationCenter
	 * @param room
	 * @throws EMagineException throws if an SQLException occures
	 */
	public abstract void removeRoom(FormationCenter formationCenter, Room room)
			throws EMagineException;

	/**
	 * Removes the given rooms from the given formationCenter
	 * @param formationCenter
	 * @param rooms 
	 * @throws EMagineException throws if an SQLException occures
	 */
	public abstract void removeRooms(FormationCenter formationCenter,
			Collection<Room> rooms) throws EMagineException;

	/**
	 * Tries to fill the given formationCenter rooms with its candidates. Returns the candidates who are in one of the rooms.
	 * @param formationCenter
	 * @return Candidate's List
	 * @throws EMagineException
	 */
	public abstract List<Candidate> generateAttendanceSheet(
			FormationCenter formationCenter) throws EMagineException;

	/**
	 * Searches for the given formationCenterSearchParams
	 * @param formationCenterSearchParams
	 * @return Candidate's List
	 * @throws EMagineException
	 */
	public abstract List<FormationCenter> find(
			FormationCenterSearchParams formationCenterSearchParams)
			throws EMagineException;

}