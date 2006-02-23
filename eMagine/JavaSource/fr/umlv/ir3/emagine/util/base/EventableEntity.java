package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.modification.Modification;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
public abstract class EventableEntity extends EditableEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
    @OneToMany(mappedBy = "source")
    @Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
    private List<Event> events = new ArrayList<Event>();
 
	protected EventableEntity(List<Modification> modifications, List<Event> events) {
		super(modifications);
	}
	
	protected EventableEntity() {};

	public List<Event> getEvents() {
		return events;
	}
}