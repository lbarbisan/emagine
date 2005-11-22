/**
 *  
 */
package fr.umlv.ir3.emagine.student.absence;

import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Administrateur
 *
 */
@Entity(access = AccessType.FIELD)
@Table(name = "tbl_abscence",
		uniqueConstraints = @UniqueConstraint(columnNames={"date", "student"}))
public class Abscence extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8312730192742642372L;

	private Date date;

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
