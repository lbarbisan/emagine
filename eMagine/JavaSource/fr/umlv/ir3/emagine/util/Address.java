/**
 *@Persistence 50 %  
 */
package fr.umlv.ir3.emagine.util;

import javax.persistence.AccessType;
import javax.persistence.Embeddable;


/**
 * @author Laurent
 * 
 * @Persitence Reste les enum
 */
@Embeddable(access = AccessType.FIELD)
public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7027284397861275888L;
	private String street;
	private String postalCode;
	private String city;
	//FIXME : Hiernate - Enum
	/*private DepartmentEnum department;
	private CountryEnum country;*/
}
