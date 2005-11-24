package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
	//FIXME: Hibernate : List des étudiant bidirectionnal 
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy  = "teacherTutor")
	private List<Student> student;
	
	@Embedded
	private Address addressProfessional;
}
