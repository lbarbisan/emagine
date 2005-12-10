package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;

public class FormationCenterManager extends BaseEditableManagerImpl<FormationCenter, FormationCenterDAO> {

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
			FormationCenterDAO dao = getDAO();
			dao.update(formationCenter);
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
	
	/**
	 * Removes the given rooms from the given formationCenter
	 * @param formationCenter
	 * @param room
	 * @throws EMagineException throws if an SQLException occures
	 */
	public void removeRooms(FormationCenter formationCenter, Collection<Room> rooms) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Room> centerRooms = formationCenter.getRooms();
			centerRooms.removeAll(rooms);
			FormationCenterDAO dao = getDAO();
			dao.update(formationCenter);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	/**
	 * Tries to fill the given formationCenter rooms with its candidates. Returns the candidates who are in one of the rooms.
	 * @param formationCenter
	 * @return
	 * @throws EMagineException
	 */
	public List<Candidate> generateAttendanceSheet(FormationCenter formationCenter) throws EMagineException {
		LinkedList<Candidate> treatedCandidates = new LinkedList<Candidate>();
		DAOManager.beginTransaction();
		try {
			Iterator<Candidate> candidates = formationCenter.getCandidates().iterator();
			Iterator<Room> rooms = formationCenter.getRooms().iterator();
			CandidateDAO candidateDAO = DAOManager.getInstance().getCandidateDAO();
			RoomDAO roomDAO = DAOManager.getInstance().getRoomDAO();
			FormationCenterDAO formationCenterDAO = getDAO();
			
			if (rooms.hasNext()) {
				// Gets the first room
				Room room = rooms.next();
				
				// Gets the next candidate
				while (candidates.hasNext() && room.getNumberOfFreeSits() > 0) {
					Candidate candidate = candidates.next();
					if (candidate.getRoom() == null) {
						// The candidate is not attributed to a room
						while (room.getNumberOfFreeSits() <= 0 && rooms.hasNext()) {
							room = rooms.next();
						}
						if (room.getNumberOfFreeSits() > 0) {
							candidate.setRoom(room);
							candidateDAO.update(candidate);
							roomDAO.update(room);
							formationCenterDAO.update(formationCenter);
							treatedCandidates.add(candidate);
						}
						// If the room has no more free sits, search for the next one
						while (room.getNumberOfFreeSits() <= 0 && rooms.hasNext()) {
							room = rooms.next();
						}
					} else {
						treatedCandidates.add(candidate);
					}
				}
			}
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
		return treatedCandidates;
	}

	@Override
	protected FormationCenterDAO getDAO() {
		return DAOManager.getInstance().getFormationCenterDAO();
	}
}
