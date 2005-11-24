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
}
