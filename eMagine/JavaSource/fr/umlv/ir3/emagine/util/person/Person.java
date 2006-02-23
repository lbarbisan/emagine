/**
 *  
 */
package fr.umlv.ir3.emagine.util.person;


import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.EventableEntity;
;

/**
 * @author Laurent
 *@Persitence 50 Reste enum
 */
@Entity(access = AccessType.FIELD)
public class Person extends EventableEntity {

	private static final long serialVersionUID = 4072133161366106454L;
		
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressPersonnal_id")
	private Address addressPersonnal = new Address();

	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date birthdayDate;
	
	private String birthdayCity;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="birthdayCountry_id")
	private CountryEnum birthdayCountry;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="birthdayDepartment_id")
	private DepartmentEnum birthdayDepartment;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="nationality_id")
	private NationalityEnum nationality;
	
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="sex_id")
	private SexEnum sex;
	
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
	private String mobilePhone;
	private String fax;
	
	protected Person( List<Modification> modifications, List<Event> events, Address addressPersonnal, Date birthdayDate, String birthdayCity, CountryEnum birthdayCountry, DepartmentEnum birthdayDepartment, NationalityEnum nationality, SexEnum sex, String lastName, String firstName, String email, String phone, String mobilePhone, String fax) {	
		super(modifications, events);
		this.addressPersonnal = addressPersonnal;
		this.birthdayDate = birthdayDate;
		this.birthdayCity = birthdayCity;
		this.birthdayCountry = birthdayCountry;
		this.birthdayDepartment = birthdayDepartment;
		this.nationality = nationality;
		this.sex = sex;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phone = phone;
		this.mobilePhone = mobilePhone;
		this.fax = fax;
	}
	
	protected Person() {}

	/**
	 * @return Returns the addressPersonnal.
	 */
	public Address getAddressPersonnal() {
		return addressPersonnal;
	}

	/**
	 * @param addressPersonnal The addressPersonnal to set.
	 */
	public void setAddressPersonnal(Address addressPersonnal) {
		this.addressPersonnal = addressPersonnal;
	}

	/**
	 * @return Returns the birthdayCity.
	 */
	public String getBirthdayCity() {
		return birthdayCity;
	}

	/**
	 * @param birthdayCity The birthdayCity to set.
	 */
	public void setBirthdayCity(String birthdayCity) {
		this.birthdayCity = birthdayCity;
	}

	/**
	 * @return Returns the birthdayCountry.
	 */
	public CountryEnum getBirthdayCountry() {
		return birthdayCountry;
	}

	/**
	 * @param birthdayCountry The birthdayCountry to set.
	 */
	public void setBirthdayCountry(CountryEnum birthdayCountry) {
		this.birthdayCountry = birthdayCountry;
	}

	/**
	 * @return Returns the birthdayDate.
	 */
	public Date getBirthdayDate() {
		return birthdayDate;
	}

	/**
	 * @param birthdayDate The birthdayDate to set.
	 */
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	/**
	 * @return Returns the birthdayDepartment.
	 */
	public DepartmentEnum getBirthdayDepartment() {
		return birthdayDepartment;
	}

	/**
	 * @param birthdayDepartment The birthdayDepartment to set.
	 */
	public void setBirthdayDepartment(DepartmentEnum birthdayDepartment) {
		this.birthdayDepartment = birthdayDepartment;
	}

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the fax.
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Returns the mobilePhone.
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @param mobilePhone The mobilePhone to set.
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return Returns the nationality.
	 */
	public NationalityEnum getNationality() {
		return nationality;
	}

	/**
	 * @param nationality The nationality to set.
	 */
	public void setNationality(NationalityEnum nationality) {
		this.nationality = nationality;
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
	 * @return Returns the sex.
	 */
	public SexEnum getSex() {
		return sex;
	}

	/**
	 * @param sex The sex to set.
	 */
	public void setSex(SexEnum sex) {
		this.sex = sex;
	};
	/**
	 * @return Returns the full name of the person.
	 */
	public String getFullName() {
		return firstName+ " " +lastName;
	}

}
