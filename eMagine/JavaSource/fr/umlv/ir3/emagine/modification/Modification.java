package fr.umlv.ir3.emagine.modification;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.BaseEntity;

@Entity(access = AccessType.FIELD)
public class Modification<ObjectType extends BaseEntity> extends BaseEntity{
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "sourceuser_id")
	private User userSource;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "destinationuser_id")
	private User userDestination;
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType Value;
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType newValue;
	
	private ModificationStateEnum modificationSate;
	private String comment;
	
}
