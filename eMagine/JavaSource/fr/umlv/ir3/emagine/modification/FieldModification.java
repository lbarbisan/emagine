package fr.umlv.ir3.emagine.modification;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class FieldModification<ObjectType extends BaseEntity> extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8847825872307086136L;
	
	@ManyToOne
	private Modification modification;
	private String propertyName;
	private ObjectType propertyValue;
	
	public Modification getModification() {
		return modification;
	}
	public void setModification(Modification modification) {
		this.modification = modification;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public ObjectType getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(ObjectType propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	

}
