package fr.umlv.ir3.emagine.apprentice;

<<<<<<< .mine
import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class SexEnum extends EmagineEnum{
	public SexEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -1095519133732810748L;
=======

public enum SexEnum {
	MALE("homme"),
	FEMALE("femme");
	
	private String name;
	private SexEnum(String name) {
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
