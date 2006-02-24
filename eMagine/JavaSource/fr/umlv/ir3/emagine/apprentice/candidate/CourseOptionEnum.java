package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CourseOptionEnum extends EmagineEnum {
	
	public static final String MFPI = "MFPI";	
	public static final String IR   = "IR";						
	public static final String GM	= "GM";			
	public static final String EI	= "EI";
	public static final String GMU	= "GMU";
	
	public CourseOptionEnum(){super();}
	public CourseOptionEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 7417210283191755013L;
}
