/**
 *  
 */
package fr.umlv.ir3.emagine.apprentice;


import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

/**
 * @author Laurent
 *
 */
@Entity(access=AccessType.FIELD)
public class NationalityEnum extends EmagineEnum{
	public NationalityEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 729255237916282703L;
}
