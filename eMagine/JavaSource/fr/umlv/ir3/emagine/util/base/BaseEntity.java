package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.ArrayList;
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
import fr.umlv.ir3.emagine.event.EventSearchParam;
import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.ManagerManager;

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
    private String name;
    
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

	public List<Event> getEvents(EventSearchParam eventSearchParam) throws EMagineException {
		return ManagerManager.getInstance().getEventManager().getEvents(eventSearchParam);
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

	public List<Modification> getModifications() {
		return modifications;
	}	
	/**
	 * 
	 * @return the current modification, or null if no modification exist
	 */
	public Modification getCurrentModification() {
		if(modifications.size()==0) {
			return null;
		}
		else {
			return modifications.get(modifications.size()-1);
		}
	}
	
	/**
	 * Add modification for this object
	 * @param modification
	 */
	//TODO : Supprimer suppression warinig
	@SuppressWarnings("unused")
	private void addModification(Modification modification) {
		this.modifications.add(modification);
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Add modification comparing with the specified object
	 * @param modification
	 */
	@SuppressWarnings("unchecked")
	public void addModification(BaseEntity baseEntity) {
		Modification modification = new Modification();
		for (FieldModification field : baseEntity.getFields()) {
			if(field.getPropertyValue().equals(this.getField(field.getPropertyName()))) {
				modification.addFieldModification(field);
				this.modifications.add(modification);
			}
		}
	}
	
	public void acceptModification() {
		//TODO : BaseEntity.acceptModification
	}
	
	/**
	 * return the value of specified property in this class 
	 * @param name name of property
	 * @return return the object associated to the name property
	 */
	//FIXME:SUpprimer le warinig
	@SuppressWarnings("unchecked")
	public FieldModification getField(String name) {
		FieldModification field = new FieldModification();
		
		//TODO : BaseEntity.getFieldValue
		field.setPropertyName(name);
		field.setPropertyValue(HibernateUtils.getPropertyValue(name, this));
		return field;
	}
	
	/**
	 * return the value of specified property in this class 
	 * @param name name of property
	 * @return return the object associated to the name property
	 */
	public List<FieldModification> getFields() {
		ArrayList<FieldModification> properties = new ArrayList<FieldModification>();
		for(String propertyName : HibernateUtils.getPropertyNames(this)) {
			properties.add(getField(propertyName));
		}
		return properties;
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
