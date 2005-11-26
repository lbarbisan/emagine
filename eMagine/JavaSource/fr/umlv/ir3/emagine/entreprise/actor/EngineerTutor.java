package fr.umlv.ir3.emagine.entreprise.actor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.Student;

/**
 * 
 * @author Administrateur
 *@persitence Terminé
 */
@Entity(access = AccessType.FIELD)
public class EngineerTutor extends EntrepriseActor {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3857030644896914550L;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "engineerTutor")
	private List<Student> student;
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}

}
