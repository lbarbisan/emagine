/**
 *@Persistence 50 %  
 */
package fr.umlv.ir3.emagine.util;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;


/**
 * @author Laurent
 */
@Embeddable(access = AccessType.FIELD)
public class Address {

	private static final long serialVersionUID = 7027284397861275888L;
	
	@ManyToOne()
	@Cascade(CascadeType.ALL)
	@JoinColumn(insertable=false, updatable=false, name="department_id")
	private DepartmentEnum department;
	@ManyToOne()
	@Cascade(CascadeType.ALL)
	@JoinColumn(insertable=false, updatable=false, name="country_id")
	private CountryEnum country;
	private String street;
	private String postalCode;
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public CountryEnum getCountry() {
		return country;
	}
	public void setCountry(CountryEnum country) {
		this.country = country;
	}
	public DepartmentEnum getDepartment() {
		return department;
	}
	public void setDepartment(DepartmentEnum department) {
		this.department = department;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}
