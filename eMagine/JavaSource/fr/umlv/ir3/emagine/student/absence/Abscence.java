/**
 *  
 */
package fr.umlv.ir3.emagine.student.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
public class Abscence extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2760061716558049781L;
	
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "student_id")
	private Student student;
	@Basic(temporalType = TemporalType.TIMESTAMP) 
	private Date startDate;
	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date endDate;
	@Transient
	private int nbrOpenDay;
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
	public int getNbrOpenDay() {
		return nbrOpenDay;
	}
	public void setNbrOpenDay(int nbrOpenDay) {
		this.nbrOpenDay = nbrOpenDay;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
