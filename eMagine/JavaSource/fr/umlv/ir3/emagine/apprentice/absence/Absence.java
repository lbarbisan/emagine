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
import fr.umlv.ir3.emagine.util.base.EditableEntity;

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
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "apprentice_id")
	private Apprentice apprentice;
	@Basic(temporalType = TemporalType.TIMESTAMP) 
	private Date startDate;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date endDate;
	@Transient
	private int numberOfWorkedDays;
	private boolean justification;
	private String justificationComment;
	
	protected Absence(){super();}
	public Absence(boolean justification ,
					String justificationComment,
					Date startDate,
					Date endDate)
	{
		super();
		this.justification = justification;
		this.justificationComment = justificationComment;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
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
	public int getNumberOfWorkedDays() {
		return numberOfWorkedDays;	// TODO : calculer en live le nombre de jour travaillés
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
