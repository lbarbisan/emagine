/**
 *  
 */
package fr.umlv.ir3.emagine.util;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * @author Laurent
 */
@Entity(access = AccessType.FIELD)
public class Address extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7027284397861275888L;
	private String street;
	private String country;
}
