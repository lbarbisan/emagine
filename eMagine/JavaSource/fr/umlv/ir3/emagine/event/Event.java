/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.TemporalType;

import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * @author Laurent
 * @Persitence Enum
 */
@Entity(access = AccessType.FIELD)
public class Event extends BaseEntity {

	private static final long serialVersionUID = 4144109134646449620L;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@OrderBy("id")
	private List<BaseEntity> sources;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date date;
	private String Title;
	private String comment;
	private EventTypeEnum type;

	
	public List<BaseEntity> getSources() {
		return sources;
	}
	public void setSources(List<BaseEntity> sources) {
		this.sources = sources;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public EventTypeEnum getType() {
		return type;
	}
	public void setType(EventTypeEnum type) {
		this.type = type;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}