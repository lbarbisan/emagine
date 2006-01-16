/**
 *  
 */
package fr.umlv.ir3.emagine.event;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

/**
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public class EventTypeEnum extends EmagineEnum{
	
	public static final EventTypeEnum ERROR = new EventTypeEnum("ERROR");
	public static final EventTypeEnum WARNING = new EventTypeEnum("WARNING");
	public static final EventTypeEnum INFO = new EventTypeEnum("INFO");
	public static final EventTypeEnum MODIFICATION = new EventTypeEnum("MODIFICATION");
	
	protected EventTypeEnum(String name) {
		super(name);
	}

	private static final long serialVersionUID = 8431738569570314082L;
	
}
