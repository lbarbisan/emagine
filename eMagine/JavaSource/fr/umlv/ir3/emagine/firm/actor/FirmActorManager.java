package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.base.EventableManager;

@MustHaveRights("firmActor")
public interface FirmActorManager extends EventableManager<FirmActor, FirmActorDAO> {
	public boolean isEngineerTutor(FirmActor firmActor);
}