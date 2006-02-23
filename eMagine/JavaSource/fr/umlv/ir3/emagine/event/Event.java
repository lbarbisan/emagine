/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * Represent an Event. An event is used to inform action in the system
 * This is linked to one or more sources (BaseEntity)
 * @author Laurent
 */
@Entity(access = AccessType.FIELD)
public class Event extends BaseEntity {

	private static final long serialVersionUID = 4144109134646449620L;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="type_id")
	private EventTypeEnum type;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date date = new Date();
	private String title;
	private String userComment;
	private String connectedUser;
	private String oldValue;
	private String newValue;
	private String property;
	private String description;
	
	/**
	 * @return Returns the comment.
	 */
	public String getUserComment() {

		return userComment;
	}
	/**
	 * @param comment The comment to set.
	 */
	public void setUserComment(String comment) {
		this.userComment = comment;
	}
	/**
	 * @return Returns the date.
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date The date to set.
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return Returns the type.
	 */
	public EventTypeEnum getType() {
		return type;
	}
	/**
	 * @param type The type to set.
	 */
	public void setType(EventTypeEnum type) {
		this.type = type;
	}
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return Returns the connectedUser.
	 */
	public String getConnectedUser() {
		return connectedUser;
	}
	/**
	 * @param connectedUser The connectedUser to set.
	 */
	public void setConnectedUser(String connectedUser) {
		this.connectedUser = connectedUser;
	}
	/**
	 * @return Returns the newValue.
	 */
	public String getNewValue() {
		return newValue;
	}
	/**
	 * @param newValue The newValue to set.
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	/**
	 * @return Returns the oldValue.
	 */
	public String getOldValue() {
		return oldValue;
	}
	/**
	 * @param oldValue The oldValue to set.
	 */
	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 * @return Returns the property.
	 */
	public String getProperty() {
		return property;
	}
	/**
	 * @param property The property to set.
	 */
	public void setProperty(String property) {
		this.property = property;
	}
}