/**
 *  
 */
package fr.umlv.ir3.emagine.util;


import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Laurent
 *@Persitence 50 Reste enum
 */
@Entity(access = AccessType.FIELD)
public class Person extends BaseEntity {

	private static final long serialVersionUID = 4072133161366106454L;
	
	private String lastName;
	private String firstName;
	//FIXME : Hibernate - Enum
	/*private SexEnum sex;*/
	private Date birthdayDate;
	private String birthdayCity;
	/*private CountryEnum birthdayCountry;
	private DepartmentEnum birthdayDepartment;
	private NationalityEnum nationality;*/
	
	//@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    //@JoinColumn(name="address_fk")
    @Embedded
	private Address addressPersonnal;
	private String email;
	private String phone;
	private String mobilePhone;
	private String Fax;

}
