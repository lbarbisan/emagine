package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;
import fr.umlv.ir3.emagine.util.Person;

@Entity(access = AccessType.FIELD)
public class TeacherTutor extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6468325376386661021L;
	//FIXME : Student
	/*@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@OrderBy("name")
	private List<Student> student;*/
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="address_fk")
	private Address addressProfessional;
}
