package fr.umlv.ir3.emagine.event;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class EventManager extends BaseManagerImpl<Event, EventDAO> {

	public List<Event> find(BaseEntity entity, EventSearchParam eventSearchParam) throws EMagineException {
		EventDAO dao = getDAO();
		return dao.find(entity, eventSearchParam);
	}

	protected EventDAO getDAO() {
		DAOManager instance = DAOManager.getInstance();
		return instance.getEventDAO();
	}
}
