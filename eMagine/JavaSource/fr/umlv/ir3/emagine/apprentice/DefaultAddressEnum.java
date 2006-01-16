package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DefaultAddressEnum extends EmagineEnum<DefaultAddressEnum> {
	
	public static final DefaultAddressEnum PROFESSIONNAL = new DefaultAddressEnum("Professionnal");
	public static final DefaultAddressEnum ACADEMIC = new DefaultAddressEnum("Academic");
	public static final DefaultAddressEnum PERSONNAL = new DefaultAddressEnum("Personnal");
	
	private static final long serialVersionUID = -3760839927504476550L;
	
	protected DefaultAddressEnum(String string) {
		super(string);
	}

	
}
