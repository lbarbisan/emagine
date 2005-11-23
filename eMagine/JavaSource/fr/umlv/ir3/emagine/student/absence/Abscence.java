/**
 *  
 */
package fr.umlv.ir3.emagine.student.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
@Table(name = "tbl_abscence",
		uniqueConstraints = @UniqueConstraint(columnNames={"date", "student"}))
public class Abscence extends BaseEntity {
	
	private Date startDate;
	private Date endDate;
	//FIXME : Solve - Calculé en java
	private int nbrOpenDay;
	private boolean justification;
	private String justificationComment;
	
	private Student sutent;
	
}
