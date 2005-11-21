/**
 *  
 */
package fr.umlv.ir3.emagine.student.abscence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.core.BaseEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
@Table(name = "tbl_abscence")
public class Abscence extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8312730192742642372L;

	Date date;
	
	@ManyToOne
	private Student student;

	/**
	 * @return Returns the student.
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student The student to set.
	 */
	public void setStudent(Student student) {
		this.student = student;
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
	
}
