package fr.umlv.ir3.emagine.entreprise.actor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

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
	//FIXME : Bidirectionnal
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "engineerTutor")
	private List<Student> student;

}
