package fr.umlv.ir3.emagine.modification;

import java.util.Map;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
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
	/*@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType Value;
	@OneToOne(targetEntity = BaseEntity.class)
	private ObjectType newValue;*/
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "baseentity_id")
	private ObjectType baseEntity;
	@OneToMany(mappedBy = "modification")
	@MapKey(name = "propertyName")
	private Map<String, FieldModification> modifications;
	private ModificationStateEnum modificationSate;
	private String comment;
	
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
	public ModificationStateEnum getModificationSate() {
		return modificationSate;
	}
	/**
	 * @param modificationSate The modificationSate to set.
	 */
	public void setModificationSate(ModificationStateEnum modificationSate) {
		this.modificationSate = modificationSate;
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
}
