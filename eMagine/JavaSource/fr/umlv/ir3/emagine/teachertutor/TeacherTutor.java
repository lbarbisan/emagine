package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.Person;
/**
 * 
 * @author Administrateur
 *@Persistance 50%
 */
@Entity(access = AccessType.FIELD)
public class TeacherTutor extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6468325376386661021L;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy  = "teacherTutor")
	private List<Student> student;
	
	@Embedded
	private Address addressProfessional;

	public Address getAddressProfessional() {
		return addressProfessional;
	}

	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
}
