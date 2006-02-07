/**
 *  
 */
package fr.umlv.ir3.emagine.util.person;


import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {
		"lastname",
		"firstname",
		"email"
		}))
public class Person extends EventableEntity {

	private static final long serialVersionUID = 4072133161366106454L;
		
	@OneToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressPersonnal_id")
	@Column(unique = true)
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
	
	
	
	protected Person(Long id, Long version, List<Modification> modifications, List<Event> events, Address addressPersonnal, Date birthdayDate, String birthdayCity, CountryEnum birthdayCountry, DepartmentEnum birthdayDepartment, NationalityEnum nationality, SexEnum sex, String lastName, String firstName, String email, String phone, String mobilePhone, String fax) {	
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
	
	protected Person() {};
	
	public Address getAddressPersonnal() {
		return addressPersonnal;
	}
	public void setAddressPersonnal(Address addressPersonnal) {
		this.addressPersonnal = addressPersonnal;
	}
	public String getBirthdayCity() {
		return birthdayCity;
	}
	public void setBirthdayCity(String birthdayCity) {
		this.birthdayCity = birthdayCity;
	}
	public CountryEnum getBirthdayCountry() {
		return birthdayCountry;
	}
	public void setBirthdayCountry(CountryEnum birthdayCountry) {
		this.birthdayCountry = birthdayCountry;
	}
	public Date getBirthdayDate() {
		return birthdayDate;
	}
	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	public DepartmentEnum getBirthdayDepartment() {
		return birthdayDepartment;
	}
	public void setBirthdayDepartment(DepartmentEnum birthdayDepartment) {
		this.birthdayDepartment = birthdayDepartment;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public NationalityEnum getNationality() {
		return nationality;
	}
	public void setNationality(NationalityEnum nationality) {
		this.nationality = nationality;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public SexEnum getSex() {
		return sex;
	}
	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

}
