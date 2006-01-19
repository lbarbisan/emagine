package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DepartmentEnum extends EmagineEnum{
	public DepartmentEnum(){super();}
	public DepartmentEnum(String name)
	{
		super(name);
	}
	private static final long serialVersionUID = -2714890313691705005L;
}
