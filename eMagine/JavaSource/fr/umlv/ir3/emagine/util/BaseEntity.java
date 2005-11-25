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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.event.Event;
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
    /*@OneToOne(mappedBy = "previousEntity")
    private BaseEntity nextEntity;
    @OneToOne
    @JoinColumn(name = "nextEntity_id")
    private BaseEntity previousEntity;*/
	
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
