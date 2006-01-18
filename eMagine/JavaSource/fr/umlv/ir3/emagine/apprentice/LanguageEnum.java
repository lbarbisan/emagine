package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;


@Entity(access = AccessType.FIELD)
public class LanguageEnum extends EmagineEnum<LanguageEnum> {
	
	private static final long serialVersionUID = -3760839927504476550L;
	public static LanguageEnum[] values()
	{
		return (LanguageEnum[]) list.values().toArray();
	}
	public static LanguageEnum valueOf(String name)
	{
		return (LanguageEnum)list.get(name);
	}
	
	protected LanguageEnum(String string) {
		super(string);
	}

	
}
