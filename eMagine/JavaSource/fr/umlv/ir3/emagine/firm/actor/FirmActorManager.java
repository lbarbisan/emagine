package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.EventableManager;

public class FirmActorManager extends EventableManager<FirmActor, FirmActorDAO> {

	@Override
	protected FirmActorDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getFirmActorDAO();
	}
}
