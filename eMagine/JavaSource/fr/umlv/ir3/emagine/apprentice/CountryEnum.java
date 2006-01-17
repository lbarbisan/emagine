package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CountryEnum extends EmagineEnum<CountryEnum> {
	
	private static final long serialVersionUID = 1448815442738936324L;
	
	public static CountryEnum enumFor(String name)
	{
		return (CountryEnum) list.get(name);
	}

	private String country;

	protected CountryEnum(){super();}
	public CountryEnum(String name, String country) {
		super(name);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
}
