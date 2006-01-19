package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CourseOptionEnum extends EmagineEnum {
	protected CourseOptionEnum(){super();}
	public CourseOptionEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 7417210283191755013L;
}
