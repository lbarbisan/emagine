package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class SexEnum extends EmagineEnum{
	public SexEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -1095519133732810748L;
}
