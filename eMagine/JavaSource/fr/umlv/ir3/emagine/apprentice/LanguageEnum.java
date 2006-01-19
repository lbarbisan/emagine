package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;


@Entity(access = AccessType.FIELD)
public class LanguageEnum  extends EmagineEnum{
	protected LanguageEnum()
	{super();}
	public LanguageEnum(String string) {
		super(string);
	}
}
