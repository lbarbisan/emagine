package fr.umlv.ir3.emagine.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.modification.Modification;

/**
 * @author  Administrateur
 * @persistence : Terminé
 */
@Entity(access = AccessType.FIELD)
//@EmbeddableSuperclass
@Inheritance(strategy=InheritanceType.JOINED )
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS )
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 15466724567987L;
	
	@Id(generate = GeneratorType.AUTO )
	private Long id;
    @Version
    private Long version;
    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},
    		mappedBy="sources")
    @OrderBy("startDate")
    private List<Event> events;
    
    @OneToMany(cascade = CascadeType.ALL ,
    		mappedBy = "baseEntity")
    private List<Modification> modifications;
    
    private HashMap<String, FieldModification> propertyOldValue;

    /**
     * This constructor is necessary for Hibernate
     *
     */
	protected BaseEntity()
	{
		
	}

	/**
	 * @return the id of entity
	 */
	public Long getId() {
		return id;
	}

    @Override
	public boolean equals(Object obj) {
		return id == ((BaseEntity)obj).getId();
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<Modification> getModifications() {
		return modifications;
	}

	public void setModifications(List<Modification> modifications) {
		this.modifications = modifications;
	}

	public HashMap<String, FieldModification> getPropertyOldValue() {
		return propertyOldValue;
	}

	public void setPropertyOldValue(
			HashMap<String, FieldModification> propertyOldValue) {
		this.propertyOldValue = propertyOldValue;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
