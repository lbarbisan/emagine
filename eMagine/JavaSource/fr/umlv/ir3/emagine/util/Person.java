/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import sun.util.calendar.BaseCalendar.Date;
import fr.umlv.ir3.emagine.student.Address;
import fr.umlv.ir3.emagine.student.CountryEnum;
import fr.umlv.ir3.emagine.student.DepartmentEnum;
import fr.umlv.ir3.emagine.student.NationalityEnum;
import fr.umlv.ir3.emagine.student.SexEnum;

/**
 * @author Laurent
 *
 */
public class Person extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4072133161366106454L;
	
	private String lastName;
	private String firstName;
	private SexEnum sex;
	private Date birthdayDate;
	private String birthdayCity;
	private CountryEnum birthdayCountry;
	private DepartmentEnum birthdayDepartment;
	private NationalityEnum nationality;
	private Address addressPersonnal;
	private String email;
	private String phone;
	private String mobilePhone;
	private String Fax;

}
