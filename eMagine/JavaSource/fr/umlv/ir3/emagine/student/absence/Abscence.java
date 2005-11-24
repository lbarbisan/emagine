/**
 *  
 */
package fr.umlv.ir3.emagine.student.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
public class Abscence extends BaseEntity {
	
	private Date startDate;
	private Date endDate;
	@Transient
	private int nbrOpenDay;
	private boolean justification;
	private String justificationComment;
	
	//FIXME: Bidirectionnals
	@ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private Student student;
	
}
