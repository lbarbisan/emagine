package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.modification.Modification;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED )
public abstract class EditableEntity extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
    private List<Modification> modifications;
    
    @Version
    private Long version;

    
    
    /**
	 * @param id
     * @param version
     * @param modifications constructor
	 */
	protected EditableEntity(Long id, Long version, List<Modification> modifications) {
		super(id);
		this.modifications = modifications;
		this.version = version;
	}

	/**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected EditableEntity() {}

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
	 * Add modification comparing with the specified object
	 * @param modification
	 */
	public void addModification(EditableEntity baseEntity) {
		Modification modification = new Modification();
		for (FieldModification field : baseEntity.getFields()) {
			Object propertyValue = field.getPropertyValue();
			if(propertyValue.equals(this.getField(field.getPropertyName()))) {
				modification.addFieldModification(field);
				this.modifications.add(modification);
			}
		}
	}
	
	public void acceptModification() {
		//TODO : BaseEntity.acceptModification
	}
	
	public void acceptFieldModification(FieldModification modification) {
		//TODO : BaseEntity.acceptModification
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
}
