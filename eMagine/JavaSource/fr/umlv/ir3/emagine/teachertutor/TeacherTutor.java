package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;
/**
 * This class represent a teacher tutor for a student
 * @author eMagine
 */
@Entity(access = AccessType.FIELD)
public class TeacherTutor extends Person {

	private static final long serialVersionUID = -6468325376386661021L;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy  = "teacherTutor")
	private List<Student> student;
	
	@Embedded
	private Address addressProfessional;

	/**
	 * @return the professional address for this teacher tutor, the professional 
	 * address is the faculty address
	 */
	public Address getAddressProfessional() {
		return addressProfessional;
	}
	
	/**
	 * @param addressProfessional the professional address for this teacher tutor, the professional 
	 * address is the faculty address, this field can't be null
	 */
	//TODO : Créer un constructeur qui prend en paramètre une addressprofessional 
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}

	/**
	 * @return the student's list of this teacher tutor, the list can be null
	 */
	public List<Student> getStudent() {
		return student;
	}

	protected void setStudent(List<Student> student) {
		this.student = student;
	}
}
