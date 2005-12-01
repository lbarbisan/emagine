package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class FormationCenterManager extends BaseEditableManager<FormationCenter, FormationCenterDAO> {

	/**
	 * Lists formationCenters, using the given search parameters
	 * @param formationCenterSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<FormationCenter> find(FormationCenterSearchParam formationCenterSearchParam) throws EMagineException {
		return getDAO().find(formationCenterSearchParam);
	}
	
	/**
	 * Adds the given room to the given formationCenter
	 * @param formationCenter
	 * @param room
	 * @throws EMagineException throws if an SQLException occures
	 */
	public void addRoom(FormationCenter formationCenter, Room room) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Room> rooms = formationCenter.getRooms();
			rooms.add(room);
			getDAO().update(formationCenter);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Removes the given room from the given formationCenter
	 * @param formationCenter
	 * @param room
	 * @throws EMagineException throws if an SQLException occures
	 */
	public void removeRoom(FormationCenter formationCenter, Room room) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Room> rooms = formationCenter.getRooms();
			rooms.remove(room);
			getDAO().update(formationCenter);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	@Override
	protected FormationCenterDAO getDAO() {
		return DAOManager.getInstance().getFormationCenterDAO();
	}

	@Override
	public FormationCenter retrieve(long id) throws EMagineException {
		return getDAO().retrieve(FormationCenter.class, id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO FormationCenterManager.extract()
		return null;
	}
}
