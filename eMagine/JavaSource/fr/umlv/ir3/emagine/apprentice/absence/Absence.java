/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
public class Absence extends EditableEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2760061716558049781L;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "apprentice_id")
	private Apprentice apprentice;
	@Basic(temporalType = TemporalType.TIMESTAMP) 
	private Date startDate;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date endDate;
	@Transient
	private int numberOfworkedDays;
	private boolean justification;
	private String justificationComment;
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isJustification() {
		return justification;
	}
	public void setJustification(boolean justification) {
		this.justification = justification;
	}
	public String getJustificationComment() {
		return justificationComment;
	}
	public void setJustificationComment(String justificationComment) {
		this.justificationComment = justificationComment;
	}
	public int getNumberOfworkedDays() {
		return numberOfworkedDays;
	}
	public void setNumberOfworkedDays(int nbrOpenDay) {
		this.numberOfworkedDays = nbrOpenDay;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Apprentice getApprentice() {
		return apprentice;
	}
	public void setApprentice(Apprentice apprentice) {
		this.apprentice = apprentice;
	}
}