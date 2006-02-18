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
	
	public static final String MOD_GENERAL =		"Changement adresse";
	public static final String MOD_TUTOR_TEACHER = 	"Changement de Tuteur Enseignant";
	public static final String MOD_TUTOR_FIRM = 	"Changement de Tuteur Ingénieur";
	public static final String SEND_MAIL = 			"Envoi mail";
	public static final String SEND_POSTAL_MAIL = 	"Envoi courrier";
	
	public EventTypeEnum(){super();}
	public EventTypeEnum(String name) {
		super(name);
	}
	private static final long serialVersionUID = 8431738569570314082L;
	
}
