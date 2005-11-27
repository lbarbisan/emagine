/**
 *  
 */
package fr.umlv.ir3.emagine.util.person;


import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import fr.umlv.ir3.emagine.student.CountryEnum;
import fr.umlv.ir3.emagine.student.DepartmentEnum;
import fr.umlv.ir3.emagine.student.NationalityEnum;
import fr.umlv.ir3.emagine.student.SexEnum;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
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
public class Person extends BaseEntity {

	private static final long serialVersionUID = 4072133161366106454L;
		
    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="department", column = @Column(name="personnaldepartment")),
        @AttributeOverride(name="country", column = @Column(name="personnalcountry")),
        @AttributeOverride(name="street", column = @Column(name="personnalstreet")),
        @AttributeOverride(name="postalCode", column = @Column(name="personnalpostalCode")),
        @AttributeOverride(name="city", column = @Column(name="personnalcity"))})
	private Address addressPersonnal;

	@Basic(temporalType = TemporalType.TIMESTAMP)
	private Date birthdayDate;
	private String birthdayCity;
	private CountryEnum birthdayCountry;
	private DepartmentEnum birthdayDepartment;
	private NationalityEnum nationality;
	private SexEnum sex;
	private String lastName;
	private String firstName;
	private String email;
	private String phone;
	private String mobilePhone;
	private String Fax;
	
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
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
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
