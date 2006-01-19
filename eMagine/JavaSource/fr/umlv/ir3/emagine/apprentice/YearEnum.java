package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class YearEnum extends EmagineEnum{
	public YearEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -4417499791672060100L;

}
