/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableEntity;

/**
 * This class represent an abscence. 
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"apprentice_id", "startDate", "endDate" })})
public class Absence extends EditableEntity {
	
	private static final long serialVersionUID = -2760061716558049781L;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name = "apprentice_id", nullable = false)
	private Apprentice apprentice;
	@Basic(temporalType = TemporalType.TIMESTAMP) 
	@Column(nullable=false)
	private Date startDate;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date endDate;
	private boolean justification=false;
	private String justificationComment;
	
	/**
	 * Constructor reserved for hibernate
	 */
	protected Absence(){super();}
	
	/**
	 * @return Returns the apprentice.
	 */
	public Apprentice getApprentice() {
		return apprentice;
	}

	/**
	 * @param apprentice The apprentice to set.
	 */
	public void setApprentice(Apprentice apprentice) {
		this.apprentice = apprentice;
	}

	/**
	 * @return Returns the endDate.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This parameter must be set.
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * By default, this parameter is set to false
	 * @return Returns the justification.
	 */
	public boolean isJustification() {
		return justification;
	}

	/**
	 * @param justification The justification to set.
	 */
	public void setJustification(boolean justification) {
		this.justification = justification;
	}

	/**
	 * @return Returns the justificationComment.
	 */
	public String getJustificationComment() {
		return justificationComment;
	}

	/**
	 * @param justificationComment The justificationComment to set.
	 */
	public void setJustificationComment(String justificationComment) {
		this.justificationComment = justificationComment;
	}

	/**
	 * @return Returns the startDate.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This parameter must be set.
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return Returns the numberOfWorkedDays.
	 */
	//FIXME : Ticket #13 Mettre en place l'algorithme de calcule du nombre de jour travailler
	public int getNumberOfWorkedDays() {
		return 0;
	}

	/**
	 * Create an absence with the default specfied parameter
	 * @param justification true if this absence is justified, false otherwise
	 * @param justificationComment comment for this justification, it can be null
	 * @param startDate abscence's start date
	 * @param endDate abscence's end date
	 * @throws IllegalArgumentException, if the startDate is gretter than endDate
	 */
	
	public Absence(boolean justification ,
					String justificationComment,
					Date startDate,
					Date endDate)
	{
		super();
		this.justification = justification;
		this.justificationComment = justificationComment;
		if(startDate.after(endDate))
		{
			throw new IllegalArgumentException("startDate must be lower than endDate"); 
		}
		else
		{
			this.startDate = startDate;
			this.endDate = endDate;
		}
	}
}
