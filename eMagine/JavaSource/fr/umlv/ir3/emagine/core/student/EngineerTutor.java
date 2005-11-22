package fr.umlv.ir3.emagine.core.student;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.core.BaseEntity;


@Entity(access = AccessType.FIELD)
@Table(name = "tbl_engineertutor")

public class EngineerTutor extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3857030644896914550L;
	
	@OneToMany(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@OrderBy("name")
	private List<Student> student;

	/**
	 * @return Returns the student.
	 */
	public List<Student> getStudent() {
		return student;
	}

	/**
	 * @param student The student to set.
	 */
	public void setStudent(List<Student> student) {
		this.student = student;
	}
}
