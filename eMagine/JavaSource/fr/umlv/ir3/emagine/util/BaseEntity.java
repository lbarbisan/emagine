package fr.umlv.ir3.emagine.util;

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
import javax.persistence.OrderBy;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.event.Event;

/**
 * @author  Administrateur
 * @persistence : Terminé
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 15466724567987L;
	
	@Id(generate = GeneratorType.AUTO )
	public Long id;
    @Version
    private Long version;
    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE},
    		mappedBy="sources")
    @OrderBy("startDate")
    private List<Event> events;
	
    /**
     * This constructor is necessary for Hibernate
     *
     */
	protected BaseEntity()
	{}

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
	
	
}
