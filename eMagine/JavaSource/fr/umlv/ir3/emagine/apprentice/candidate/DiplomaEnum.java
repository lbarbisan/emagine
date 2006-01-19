package fr.umlv.ir3.emagine.apprentice.candidate;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DiplomaEnum extends EmagineEnum{
	public DiplomaEnum(){super();}
	public DiplomaEnum(String name) {
		super(name);
	}
}
