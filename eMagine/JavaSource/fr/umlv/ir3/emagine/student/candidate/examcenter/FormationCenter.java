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
import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * @author Laurent
 * @persitence Terminé - Vérifier les contrainte unique, et la clef primaire
 */
@Entity(access = AccessType.FIELD)
public class FormationCenter extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4966355951897961036L;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Candidate> getCandidate() {
		return candidate;
	}
	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}
