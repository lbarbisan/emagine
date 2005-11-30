package fr.umlv.ir3.emagine.apprentice.candidate.room;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class RoomManager extends BaseManager<Room, RoomDAO> {

	@Override
	protected RoomDAO getDAO() {
		return DAOManager.getInstance().getRoomDAO();
	}

	@Override
	public Room retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Room.class, id);
	}
}
