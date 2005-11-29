package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class FirmActorManager extends BaseEditableManager<FirmActor, FirmActorDAO> {

	@Override
	protected FirmActorDAO getDAO() {
		return DAOManager.getInstance().getFirmActorDAO();
	}

	@Override
	public FirmActor retrieve(long id) throws EMagineException {
		return getDAO().retrieve(FirmActor.class , id);
	}
}