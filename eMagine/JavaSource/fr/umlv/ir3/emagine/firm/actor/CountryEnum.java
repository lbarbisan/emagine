package fr.umlv.ir3.emagine.firm.actor;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CountryEnum extends EmagineEnum{
	public CountryEnum(){super();}
	public CountryEnum(String string) {
		super(string);
	}
	private static final long serialVersionUID = 1448815442738936324L;				
}
