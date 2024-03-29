/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy = "formationCenter")
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN} )
	private List<Room> rooms = new ArrayList<Room>();
	
	@OneToMany(mappedBy = "formationCenter")
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN} )
	private List<Candidate> candidates;
	
	@ManyToOne()
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
	@JoinColumn(name = "address_id")
	private Address address;
	
	private String name;
	private String phone;
	
	
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
	
	public String getAddressString(){
		String address;
		if(this.address==null){
			address="&nbsp;";
		}
		else{
			address = this.address.getStreet()+ " " + this.address.getPostalCode()+ " " +this.address.getCity()+ " ";
		}
		
		return address;
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
