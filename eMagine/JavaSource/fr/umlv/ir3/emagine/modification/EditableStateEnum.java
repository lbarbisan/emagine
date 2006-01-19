package fr.umlv.ir3.emagine.modification;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class EditableStateEnum extends EmagineEnum{
	public EditableStateEnum(String string) {
		super(string);
	}

	private static final long serialVersionUID = -9162090228191512215L;
}
