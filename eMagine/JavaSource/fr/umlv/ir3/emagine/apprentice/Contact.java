/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * @author Laurent
 * @persistence Terminé
 */
@Entity(access = AccessType.FIELD)
public class Contact extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3225117135146637878L;
	//TODO : Hibernate - y-a-til d'autre champ
	@OneToMany(mappedBy = "contactOriginIG2K")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Candidate> candidates;
	public List<Candidate> getCandidates() {
		return candidates;
	}
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
 
}
