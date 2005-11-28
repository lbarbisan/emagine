package fr.umlv.ir3.emagine.util.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.HibernateUtils;

/**
 * 
 * @author  Administrateur
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED )
public class EditableEntity extends EventEntity implements Serializable {
	
	private static final long serialVersionUID = 15466724567987L;
	
    private List<Modification> modifications;
    
    /**
     * This constructor is necessary for Hibernate, it's used for lazy load
     */
	protected EditableEntity(){}

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
	 * Add modification comparing with the specified object
	 * @param modification
	 */
	@SuppressWarnings("unchecked")
	public void addModification(EditableEntity baseEntity) {
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
}
