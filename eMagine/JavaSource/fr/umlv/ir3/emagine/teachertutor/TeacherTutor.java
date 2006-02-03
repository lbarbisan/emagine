package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * This class represent a teacher tutor for a apprentice
 * @author eMagine
 */
@Entity(access = AccessType.FIELD)
public class TeacherTutor extends Person {

	private static final long serialVersionUID = 3578189435879585726L;

	@OneToMany(mappedBy = "teacherTutor")
	@Cascade(CascadeType.ALL)
	@Column(unique = true)
	private List<Apprentice> apprentice;

	@OneToOne()
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "addressProfessional_id")
	@Column(unique = true)
	private Address addressProfessional = new Address();

	/**
	 * @return the professional address for this teacher tutor, the professional
	 * address is the faculty address
	 */
	public Address getAddressProfessional() {
		return addressProfessional;
	}

	/**
	 * @param addressProfessional the professional address for this teacher tutor, the professional
	 * address is the faculty address, this field can't be null
	 */
	//TODO : Cr�er un constructeur qui prend en param�tre une addressprofessional 
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}

	/**
	 * @return the apprentice's list of this teacher tutor, the list can be null
	 */
	public List<Apprentice> getApprentice() {
		return apprentice;
	}

	protected void setApprentice(List<Apprentice> apprentice) {
		this.apprentice = apprentice;
	}
}
