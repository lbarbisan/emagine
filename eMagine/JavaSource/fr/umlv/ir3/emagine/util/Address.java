/**
 *@Persistence 50 %  
 */
package fr.umlv.ir3.emagine.util;

import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import fr.umlv.ir3.emagine.student.DepartmentEnum;
import fr.umlv.ir3.emagine.student.CountryEnum;


/**
 * @author Laurent
 * 
 * @Persitence Reste les enum
 */
@Embeddable(access = AccessType.FIELD)
public class Address {

	private static final long serialVersionUID = 7027284397861275888L;
	
	private DepartmentEnum department;
	private CountryEnum country;
	private String street;
	private String postalCode;
	private String city;
}
