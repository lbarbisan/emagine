package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.EditableManager;

public class FirmActorManager extends EditableManager<FirmActor, FirmActorDAO> {

	@Override
	protected FirmActorDAO getDAO() {
		return DAOManager.getInstance().getFirmActorDAO();
	}
}