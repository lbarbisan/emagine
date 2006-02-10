package fr.umlv.ir3.emagine.apprentice.candidate.room;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class RoomManagerImpl extends BaseManagerImpl<Room, RoomDAO> implements RoomManager {

	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseManagerImpl#delete(EntityType)
	 */
	@Override
	public void delete(Room entity) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			entity.getFormationCenter().getRooms().remove(entity);
			DAOManager.getInstance().getFormationCenterDAO().update(entity.getFormationCenter());
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	@Override
	protected RoomDAO getDAO() {
		return DAOManager.getInstance().getRoomDAO();
	}
}
