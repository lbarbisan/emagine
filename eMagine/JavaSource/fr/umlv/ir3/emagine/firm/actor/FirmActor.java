package fr.umlv.ir3.emagine.firm.actor;

import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;

@Entity(access = AccessType.FIELD)
public class FirmActor extends Person {
	
	private static final long serialVersionUID = 6962218814666233077L;

	@ManyToOne()
	@JoinColumn(name = "firm_id")
	private Firm firm;
	
	@OneToOne()	
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressPersonnal_id")
	private Address addressProfessional;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="function_id")
	private FunctionEnum function;
	
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
	public FirmActor(List<Modification> modifications, List<Event> events, Address addressPersonnal, Date birthdayDate, String birthdayCity, CountryEnum birthdayCountry, DepartmentEnum birthdayDepartment, NationalityEnum nationality, SexEnum sex, String lastName, String firstName, String email, String phone, String mobilePhone, String fax, Firm firm, Address addressProfessional, FunctionEnum function) {
		super(modifications, events, addressPersonnal, birthdayDate,
				birthdayCity, birthdayCountry, birthdayDepartment, nationality, sex,
				lastName, firstName, email, phone, mobilePhone, fax);
		this.firm = firm;
		this.addressProfessional = addressProfessional;
		this.function = function;
	}

	public FirmActor()
	{
		
	}

	/**
	 * @return Returns the function.
	 */
	public FunctionEnum getFunction() {
		return function;
	}
	/**
	 * @param function The function to set.
	 */
	public void setFunction(FunctionEnum function) {
		this.function = function;
	}
	/**
	 * @return Returns the addressProfessional.
	 */
	public Address getAddressProfessional() {
		return addressProfessional;
	}
	/**
	 * @param addressProfessional The addressProfessional to set.
	 */
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}
	/**
	 * @return Returns the firm.
	 */
	public Firm getFirm() {
		return firm;
	}
	/**
	 * @param firm The firm to set.
	 */
	public void setFirm(Firm firm) {
		this.firm = firm;
	}
}
