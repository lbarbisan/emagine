package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.Modification;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
public abstract class EventableEntity extends EditableEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
    @ManyToMany(cascade={CascadeType.ALL},mappedBy="sources")
    @OrderBy("date")
    private List<Event> events;

    
    
	protected EventableEntity(Long id, Long version, List<Modification> modifications, List<Event> events) {
		super(id, version, modifications);
		this.events = events;
	}
	
	protected EventableEntity() {};

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}


}