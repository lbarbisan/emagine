package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratorType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.util.HibernateUtils;

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
    
    
    /**
	 * @param id
	 * @param version
	 * @param name constructor
	 */
	protected BaseEntity(Long id, Long version) {
		this.id = id;
		this.version = version;
	}

	/**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected BaseEntity() {}

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
	 * return the value of specified property in this class 
	 * @param name name of property
	 * @return return the object associated to the name property
	 */
	//FIXME:Supprimer le warinig
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
    
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}
}
