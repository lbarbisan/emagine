package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;


@Entity(access = AccessType.FIELD)
public class JustificationEnum  extends EmagineEnum{
	public JustificationEnum()
	{super();}
	public JustificationEnum(String string) {
		super(string);
	}
}