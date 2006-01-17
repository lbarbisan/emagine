package fr.umlv.ir3.emagine.event;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("event")
public interface EventManager extends BaseManager<Event, EventDAO> {
}