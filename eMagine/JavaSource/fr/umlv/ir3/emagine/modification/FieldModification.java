package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

@Entity(access = AccessType.FIELD)
public class FieldModification<ObjectType> extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8847825872307086136L;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "modification_fk")
	private Modification modification;
	private String propertyName;
	private Serializable propertyValue;
	
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
	public Serializable getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Serializable propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	

}
