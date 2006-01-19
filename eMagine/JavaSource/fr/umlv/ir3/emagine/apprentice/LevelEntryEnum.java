package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class LevelEntryEnum extends EmagineEnum{
	public LevelEntryEnum(){super();}
	public LevelEntryEnum(String string) {
		super(string);
	}
}
