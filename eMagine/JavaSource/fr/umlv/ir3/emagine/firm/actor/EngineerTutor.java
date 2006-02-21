package fr.umlv.ir3.emagine.firm.actor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.Apprentice;

/**
 * 
 * @author Administrateur
 *@persitence Terminé
 */
@Entity(access = AccessType.FIELD)
public class EngineerTutor extends FirmActor {
	
	private static final long serialVersionUID = 3857030644896914550L;

	@OneToMany(	mappedBy = "engineerTutor")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Apprentice> apprentice = new ArrayList<Apprentice>();
	
	protected EngineerTutor(){}
	/**
	 * @param id
	 * @param version
	 * @param modifications
	 * @param events
	 * @param addressPersonnal
	 * @param birthdayDate
	 * @param birthdayCity
	 * @param birthdayCountry
	 * @param birthdayDepartment
	 * @param nationality
	 * @param sex
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param phone
	 * @param mobilePhone
	 * @param fax
	 * @param firm
	 * @param addressProfessional
	 * @param function constructor
	 */
	public EngineerTutor(FirmActor firmActor)
	{
		super(firmActor.getModifications(), firmActor.getEvents(), 
				firmActor.getAddressPersonnal(), firmActor.getBirthdayDate(), firmActor.getBirthdayCity(), 
				firmActor.getBirthdayCountry(), firmActor.getBirthdayDepartment(), firmActor.getNationality(),
				firmActor.getSex(), firmActor.getLastName(), firmActor.getFirstName(), firmActor.getEmail(),
				firmActor.getPhone(), firmActor.getMobilePhone(), firmActor.getFax(), firmActor.getFirm(),
				firmActor.getAddressProfessional(), firmActor.getFunction());
	}
	public List<Apprentice> getApprentice() {
		return apprentice;
	}
}
