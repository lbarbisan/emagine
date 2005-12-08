package fr.umlv.ir3.emagine.apprentice.candidate.room;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class RoomManager extends BaseManagerImpl<Room, RoomDAO> {

	@Override
	protected RoomDAO getDAO() {
		return DAOManager.getInstance().getRoomDAO();
	}
}
