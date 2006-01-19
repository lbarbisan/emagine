package fr.umlv.ir3.emagine.extraction;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class ViewEnum extends EmagineEnum{

	private static final long serialVersionUID = 7685541972504739777L;
	protected ViewEnum(){super();}
	public ViewEnum(String string) {
		super(string);
	}
}
