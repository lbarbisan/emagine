package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class YearObtentionEnum extends EmagineEnum{
	public YearObtentionEnum(){super();}
	public YearObtentionEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -4417499791672060100L;

}
