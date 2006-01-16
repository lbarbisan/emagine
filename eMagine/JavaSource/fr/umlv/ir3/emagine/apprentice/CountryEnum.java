package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class CountryEnum extends EmagineEnum<CountryEnum> {
	
	public static final CountryEnum FR = new CountryEnum("France", "France");
	public static final CountryEnum EN = new CountryEnum("England", "England");

	private String country;
	
	public CountryEnum(String name, String country) {
		super(name);
		this.country = country;
	}
	private static final long serialVersionUID = 1448815442738936324L;

	public String getCountry() {
		return country;
	}
}
