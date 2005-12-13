package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class EventDAO extends BaseDAO<Event> {

	public List<Event> find(BaseEntity entity, EventSearchParams eventSearchParams) throws EMagineException {
		// TODO fr.umlv.ir3.emagine.event.EventDAO.find(entity, eventSearchParam)
		throw new EMagineException("exception.unimplementedMethod",
				"fr.umlv.ir3.emagine.event.EventDAO.find(entity, eventSearchParam)");
	}
}
