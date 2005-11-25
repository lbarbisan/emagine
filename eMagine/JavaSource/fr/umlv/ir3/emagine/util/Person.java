/**
 *  
 */
package fr.umlv.ir3.emagine.util;


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

}
