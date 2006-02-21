package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.EventableManagerImpl;


public class FirmActorManagerImpl extends EventableManagerImpl<FirmActor, FirmActorDAO> implements FirmActorManager {

	@Override
	protected FirmActorDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getFirmActorDAO();
	}
	/**
	 *@see 
	 */
	public boolean isEngineerTutor(FirmActor firmActor)
	{
		return getDAO().isEngineerTutor(firmActor);
	}
}
