package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class SectionEnum extends EmagineEnum{
	protected SectionEnum(){super();}
	public SectionEnum(String name) {
		super(name);
	}
}
