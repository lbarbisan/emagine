package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
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
import fr.umlv.ir3.emagine.modification.Modification;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED )
public class BaseEntity implements Serializable {
	
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
    
    /**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected BaseEntity(){}

	/**
	 * @return the id of entity, the id is unique accross all Entity in the database.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id of entity, the id is unique accross all Entity in the database.
	 */
	protected void setId(Long id) {
		this.id = id;
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
	
	/**
	 * @return the version of this object. it's used for pesimist locking
	 */
	public Long getVersion() {
		return version;
	}
	/**
	 * @param version the version of this object. it's used for pesimist locking
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * This method compare id of each object, if id are equals it return true
	 * else it return false
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	//FIXME : Hibernate - method equals de base doit être changé, deplus la method hashCode doit être surcharé 
    @Override
	public boolean equals(Object obj) {
		return id == ((BaseEntity)obj).getId();
	}
}
