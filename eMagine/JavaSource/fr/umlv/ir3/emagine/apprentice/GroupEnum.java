package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class GroupEnum extends EmagineEnum{
	
	public static final String G1A	= 	"1A";	
	public static final String G1B  =	"1B";						
	public static final String G2A	= 	"2A";			
	public static final String G2B	= 	"2B";
	
	public GroupEnum(){super();}
	public GroupEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -4417499791672060100L;

}
