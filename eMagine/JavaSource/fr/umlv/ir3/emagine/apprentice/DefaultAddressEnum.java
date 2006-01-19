package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DefaultAddressEnum extends EmagineEnum{
	protected DefaultAddressEnum(){super();}
	public DefaultAddressEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -3760839927504476550L;
}
