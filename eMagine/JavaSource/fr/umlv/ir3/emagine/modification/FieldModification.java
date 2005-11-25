package fr.umlv.ir3.emagine.modification;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class FieldModification<ObjectType> extends BaseEntity {
	
	@ManyToOne
	private Modification modification;
	private String propertyName;
	private ObjectType propertyValue;
	
	

}
