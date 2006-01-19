package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class ProfessionEnum extends EmagineEnum{
	public ProfessionEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = 2480527798733878755L;
}
