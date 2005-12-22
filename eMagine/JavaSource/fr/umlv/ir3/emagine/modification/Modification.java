package fr.umlv.ir3.emagine.modification;

import java.util.HashMap;
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
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "entity_id")
	private EditableEntity editableEntity;
	@OneToMany(mappedBy = "modification", cascade=CascadeType.ALL)
	@MapKey(name = "propertyName")
	private Map<String, FieldModification> fieldsModifications = new HashMap<String, FieldModification>();
	//private ModificationStateEnum modificationState;
	private String comment;
	
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

	public void setUserSource(User userSource) {
		this.userSource = userSource;
	}
	public Map<String, FieldModification> getFieldsModifications() {
		return fieldsModifications;
	}
	
	public FieldModification getFieldModification(String propertyName)
	{
		return this.fieldsModifications.get(propertyName);
	}

	public EditableEntity getEditableEntity() {
		return editableEntity;
	}

	public void setEditableEntity(EditableEntity editableEntity) {
		this.editableEntity = editableEntity;
	}

}
