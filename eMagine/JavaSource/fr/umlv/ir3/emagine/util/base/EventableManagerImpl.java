package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class EventableManagerImpl <EntityType extends EventableEntity, EntityDAO extends BaseDAO<EntityType>> extends EditableManagerImpl <EntityType, BaseDAO<EntityType>> implements EventableManager<EntityType, EntityDAO> {

	/**
	 * @see fr.umlv.ir3.emagine.util.base.EventableManager#addEvent(EntityType, fr.umlv.ir3.emagine.event.Event)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.util.base.EventableManager#removeEvent(EntityType, fr.umlv.ir3.emagine.event.Event)
	 */
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

	/**
	 * @see fr.umlv.ir3.emagine.util.base.EventableManager#removeEvent(EntityType, java.util.Collection)
	 */
	public void removeEvent(EntityType entityType, Collection<Event> events) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			Collection<Event> events2 = entityType.getEvents();
			events2.removeAll(events);
			BaseDAO<EntityType> dao = getDAO();
			dao.update(entityType);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}
}
