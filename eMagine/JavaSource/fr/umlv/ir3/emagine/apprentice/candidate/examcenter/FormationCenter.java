/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.modification.EditableEntity;
import fr.umlv.ir3.emagine.util.Address;

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
	//FIXME : lbarbisan - Contrainte Unique sur l'addresse de la salle
	private Address address;
	private String phone;
	@OneToMany(mappedBy = "formationCenter")
	@Cascade(CascadeType.ALL )
	private List<Room> rooms = new ArrayList<Room>();
	@OneToMany(mappedBy = "formationCenter")
	@Cascade(CascadeType.ALL)
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
	
	public String getCity(){
		return "aaa";
	}
	
	public void setCity(String city){
		this.address.setCity(city);
	}
	
	public int getNbRooms(){
		return this.rooms.size();
	}
	
	public int getNbAvailable(){
		int nbAvaible=0;
		for (Iterator iter = rooms.iterator(); iter.hasNext();) {
			Room element = (Room) iter.next();
			nbAvaible+=element.getNumberOfFreeSits();
		}
		return nbAvaible;
	}
}
