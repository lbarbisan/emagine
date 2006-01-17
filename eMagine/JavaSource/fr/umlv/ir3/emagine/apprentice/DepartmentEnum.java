package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DepartmentEnum extends EmagineEnum<DepartmentEnum>{

	private static final long serialVersionUID = -3760839927504476550L;	
	
	public static DepartmentEnum enumFor(String name)
	{
		return (DepartmentEnum) list.get(name);
	}
	
	
	private String departementName;
	
	protected DepartmentEnum(){super();}
	
	public DepartmentEnum(String string, String departementName) {
		super(string);
		this.departementName = departementName;
	}
	
	public String getDepartementName() {
		return departementName;
	}
}
