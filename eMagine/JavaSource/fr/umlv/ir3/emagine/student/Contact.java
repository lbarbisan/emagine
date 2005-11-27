/**
 *  
 */
package fr.umlv.ir3.emagine.student;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * @author Laurent
 * @persistence Terminé
 */
@Entity(access = AccessType.FIELD)
public class Contact extends Person{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3225117135146637878L;
	//TODO : Hibernate - y-a-til d'autre champ
	@OneToMany(cascade = {CascadeType.PERSIST , CascadeType.MERGE},
				mappedBy = "contactOriginIG2K")
	private List<Candidate> candidates;
	
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
 
}
