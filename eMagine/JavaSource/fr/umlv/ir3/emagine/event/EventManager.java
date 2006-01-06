package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("event")
public interface EventManager extends BaseManager<Event, EventDAO> {

	// TODO : javadoc
	public abstract List<Event> find(BaseEntity entity,
			EventSearchParams eventSearchParams) throws EMagineException;

}