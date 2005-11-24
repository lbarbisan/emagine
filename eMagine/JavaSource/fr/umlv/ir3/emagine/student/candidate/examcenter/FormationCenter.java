/**
 *  
 */
package fr.umlv.ir3.emagine.student.candidate.examcenter;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.student.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.BaseEntity;

/**
 * @author Laurent
 * @persitence Terminé - Vérifier les contrainte unique, et la clef primaire
 */
@Entity(access = AccessType.FIELD)
public class FormationCenter extends BaseEntity {
	
	private String name;
	@Embedded
	private Address address;
	private String phone;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "formationCenter")
	private List<Room> rooms;
	//TODO : Hibernate - est-ce necessaire le candidat ?
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
			mappedBy = "formationCenter")
	private List<Candidate> candidate;

}
