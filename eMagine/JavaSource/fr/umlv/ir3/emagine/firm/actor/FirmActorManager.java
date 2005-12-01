package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseEventableManager;

public class FirmActorManager extends BaseEventableManager<FirmActor, FirmActorDAO> {

	@Override
	protected FirmActorDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getFirmActorDAO();
	}

	@Override
	public FirmActor retrieve(long id) throws EMagineException {
		return getDAO().retrieve(FirmActor.class , id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO FirmActorManager.extract()
		return null;
	}
}
