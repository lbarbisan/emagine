package fr.umlv.ir3.emagine.apprentice.candidate;

<<<<<<< .mine
import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CourseOptionEnum extends EmagineEnum {
	public CourseOptionEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 7417210283191755013L;
=======
public enum CourseOptionEnum {
	MFPI("MFPI"),
	IR("IR"),
	MI("MI");
	
	private String name;
	private CourseOptionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
>>>>>>> .r503
}
