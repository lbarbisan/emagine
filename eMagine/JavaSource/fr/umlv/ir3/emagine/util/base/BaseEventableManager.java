package fr.umlv.ir3.emagine.util.base;

import java.util.List;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseEventableManager <EntityType extends EventableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseEditableManager <EntityType, BaseDAO<EntityType>> {

	public void addEvent(EntityType entityType, Event event) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			entityType.getEvents().add(event);
			getDAO().update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeEvent(EntityType entityType, Event event) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			entityType.getEvents().remove(event);
			getDAO().update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeEvent(EntityType entityType, List<Event> events) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			entityType.getEvents().removeAll(events);
			getDAO().update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
}
