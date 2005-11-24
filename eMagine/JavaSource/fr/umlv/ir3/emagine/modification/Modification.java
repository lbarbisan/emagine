package fr.umlv.ir3.emagine.modification;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Modification<ObjectType extends BaseEntity> extends BaseEntity{
	
	private ModificationStateEnum modificationSate;
	
	private String comment;
	
	@OneToOne
	private User source;
	
	//FIXME : mapping entre les droits et les objets,
	@OneToOne
	private User destination;
	
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType oldValue;
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType currentValue;
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType newValue;
	
}
