/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

/**
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public enum NationalityEnum {
	FRENCH,
	ENGLISH
}
