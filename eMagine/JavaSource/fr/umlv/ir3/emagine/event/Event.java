/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * Represent an Event. An event is used to inform action in the system
 * This is linked to one or more sources (BaseEntity)
 * @author Laurent
 * @Persitence Enum
 */
@Entity(access = AccessType.FIELD)
public class Event extends BaseEntity {

	private static final long serialVersionUID = 4144109134646449620L;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="type_id")
	private EventTypeEnum type;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date date = new Date();
	private ArrayList<BaseEntity> sources = new ArrayList<BaseEntity>();
	private String title;
	private String comment;
	private String connectedUser;
	private String description;
	
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
	 * @return Returns the sources.
	 */
	public ArrayList<BaseEntity> getSources() {
		return sources;
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
}