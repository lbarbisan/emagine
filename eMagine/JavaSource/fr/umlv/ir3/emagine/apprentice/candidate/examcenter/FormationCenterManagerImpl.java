package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomDAO;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class FormationCenterManagerImpl extends EditableManagerImpl<FormationCenter, FormationCenterDAO> implements FormationCenterManager {

	/**
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager#addRoom(fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter, fr.umlv.ir3.emagine.apprentice.candidate.room.Room)
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
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager#removeRoom(fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter, fr.umlv.ir3.emagine.apprentice.candidate.room.Room)
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
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager#removeRooms(fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter, java.util.Collection)
	 */
	public void removeRooms(FormationCenter formationCenter, Collection<Room> rooms) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Room> centerRooms = formationCenter.getRooms();
			centerRooms.removeAll(rooms);
			getDAO().update(formationCenter);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager#generateAttendanceSheet(fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter)
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
	
	/**
	 * @see fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager#find(fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterSearchParams)
	 */
	public List<FormationCenter> find(FormationCenterSearchParams formationCenterSearchParams) throws EMagineException {
		return getDAO().find(formationCenterSearchParams);
	}

	@Override
	protected FormationCenterDAO getDAO() {
		return DAOManager.getInstance().getFormationCenterDAO();
	}
}
