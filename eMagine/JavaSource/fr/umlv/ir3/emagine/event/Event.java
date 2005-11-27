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
public class Event extends BaseEntity{

	private static final long serialVersionUID = -9082348519478717464L;

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@OrderBy("id")
	private List<BaseEntity> sources;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date startDate;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date endDate;
	private String Title;
	private String comment;
	private EventTypeEnum type;
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<BaseEntity> getSources() {
		return sources;
	}
	public void setSources(List<BaseEntity> sources) {
		this.sources = sources;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
