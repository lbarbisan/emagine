/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.TemporalType;

import fr.umlv.ir3.emagine.util.EmagineEnum;
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
	
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date date;
	private ArrayList<BaseEntity> sources = new ArrayList<BaseEntity>();
	private String Title;
	private String comment;
	private EventTypeEnum type;
	
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
	 * @param sources The sources to set.
	 */
	public void setSources(ArrayList<BaseEntity> sources) {
		this.sources = sources;
	}
	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return Title;
	}
	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		Title = title;
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
}