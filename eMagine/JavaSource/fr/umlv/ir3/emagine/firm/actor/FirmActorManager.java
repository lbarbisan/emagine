package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.modification.ModificationManager;
import fr.umlv.ir3.emagine.util.DAOManager;

public class FirmActorManager extends ModificationManager<FirmActor, FirmActorDAO> {

	@Override
	protected FirmActorDAO getDAO() {
		return DAOManager.getInstance().getFirmActorDAO();
	}
}