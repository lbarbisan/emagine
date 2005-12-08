package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseEventableManager <EntityType extends EventableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseEditableManagerImpl <EntityType, BaseDAO<EntityType>> {

	public void addEvent(EntityType entityType, Event event) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Event> events = entityType.getEvents();
			events.add(event);
			BaseDAO<EntityType> dao = getDAO();
			dao.update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeEvent(EntityType entityType, Event event) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Event> events = entityType.getEvents();
			events.remove(event);
			BaseDAO<EntityType> dao = getDAO();
			dao.update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public void removeEvent(EventableEntity entityType, Collection<Event> events) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Event> events2 = entityType.getEvents();
			events2.removeAll(events);
			BaseDAO<EntityType> dao = getDAO();
			dao.update((EntityType)entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
}
