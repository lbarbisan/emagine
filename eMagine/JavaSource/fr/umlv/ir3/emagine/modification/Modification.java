package fr.umlv.ir3.emagine.modification;

import java.util.Date;
import java.util.Map;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.EventableEntity;

@Entity(access = AccessType.FIELD)
public class Modification<ObjectType extends EventableEntity> extends BaseEntity{
	
	private static final long serialVersionUID = -985619438827774992L;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "sourceuser_id")
	private User userSource;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "destinationuser_id")
	private User userDestination;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "baseentity_id")
	private ObjectType baseEntity;
	@OneToMany(mappedBy = "modification")
	@MapKey(name = "propertyName")
	private Map<String, FieldModification> fieldsModifications;
	//private ModificationStateEnum modificationState;
	private String comment;
	private String className;
	private String fieldName;
	private String event;
	private String userName;
	private Date date;
	private String newValue;
	private String oldValue;
	private String persistedObjectId;
	private BaseEntity entity;
	
	public Modification(){super();}
	
	/**
	 * @return Returns the comment.
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment The comment to set.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return Returns the modificationSate.
	 */
	/*public ModificationStateEnum getModificationState() {
		return modificationState;
	}*/
	/**
	 * @param modificationSate The modificationSate to set.
	 */
	/*public void setModificationSate(ModificationStateEnum modificationState) {
		this.modificationState = modificationState;
	}*/
	/**
	 * @return Returns the userDestination.
	 */
	public User getUserDestination() {
		return userDestination;
	}
	/**
	 * @param userDestination The userDestination to set.
	 */
	public void setUserDestination(User userDestination) {
		this.userDestination = userDestination;
	}
	/**
	 * @return Returns the userSource.
	 */
	public User getUserSource() {
		return userSource;
	}
	public ObjectType getBaseEntity() {
		return baseEntity;
	}
	public void setBaseEntity(ObjectType baseEntity) {
		this.baseEntity = baseEntity;
	}
	public void setUserSource(User userSource) {
		this.userSource = userSource;
	}
	public Map<String, FieldModification> getFieldsModifications() {
		return fieldsModifications;
	}
	
	@SuppressWarnings("unchecked")
	public void addFieldModification(FieldModification fieldModification)
	{
		this.fieldsModifications.put(fieldModification.getPropertyName(), fieldModification);
		
	}
	public FieldModification getFieldModification(String propertyName)
	{
		return this.fieldsModifications.get(propertyName);
	}
	

	
	public void setEntityName(String className) {
		this.className = className;
	}

	public void setEntityAttribute(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setMessage(String event) {
		this.event = event;
	}

	public void setUpdatedBy(String userName) {
		this.userName = userName;
	}

	public void setUpdatedDate(Date date) {
		this.date = date;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
		
	}

	public void setEntityId(String string) {
		this.persistedObjectId = persistedObjectId;
		
	}

	public void setEntity(BaseEntity entity) {
		this.entity = entity;
		
	}

	public Object getEntity() {
		return entity;
	}

}
