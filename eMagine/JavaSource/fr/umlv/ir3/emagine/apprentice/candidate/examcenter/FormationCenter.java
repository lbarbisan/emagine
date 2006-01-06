/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.HibernateUtils;

/**
 * This class represent the Formation Center.
 * When a FormationCenter is deleted all rooms are also deleted
 * @author Laurent
 */
@Entity(access = AccessType.FIELD)
public class FormationCenter extends EditableEntity {
	
	private static final long serialVersionUID = 4966355951897961036L;
	
	private String name;
	@Embedded
	private Address address;
	private String phone;
	@OneToMany(cascade = {CascadeType.ALL},
			mappedBy = "formationCenter")
	private List<Room> rooms;
	@OneToMany(cascade = HibernateUtils.ALL_NOREMOVE,
			mappedBy = "formationCenter")
	private List<Candidate> candidates;
	
	/**
	 * @return Returns the address.
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address The address to set.
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return Returns the candidate.
	 */
	public List<Candidate> getCandidates() {
		return candidates;
	}
	/**
	 * @param candidates The candidate to set.
	 */
	public void setCandidate(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return Returns the rooms.
	 */
	public List<Room> getRooms() {
		return rooms;
	}
	/**
	 * @param rooms The rooms to set.
	 */
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
