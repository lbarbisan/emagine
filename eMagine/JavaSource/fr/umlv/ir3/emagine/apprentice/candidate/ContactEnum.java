package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class ContactEnum extends EmagineEnum{

	public ContactEnum(){super();}
	public ContactEnum(String name) {
		super(name);
	}
	private static final long serialVersionUID = -4625175739921564207L;

}
