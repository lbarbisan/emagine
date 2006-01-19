package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.EMagineException;

public interface EventableManager<EntityType extends EventableEntity, EntityDAO extends BaseDAO<EntityType>> extends BaseManager<EntityType, EntityDAO> {

	public abstract void addEvent(EntityType entityType, Event event)
			throws EMagineException;

	public abstract void removeEvent(EntityType entityType, Event event)
			throws EMagineException;

	public abstract void removeEvent(EntityType entityType,
			Collection<Event> events) throws EMagineException;

}