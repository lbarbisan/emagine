package fr.umlv.ir3.emagine.apprentice.candidate.room;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class RoomManagerImpl extends BaseManagerImpl<Room, RoomDAO> implements RoomManager {

	@Override
	protected RoomDAO getDAO() {
		return DAOManager.getInstance().getRoomDAO();
	}
}
