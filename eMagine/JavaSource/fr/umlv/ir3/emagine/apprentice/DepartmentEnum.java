package fr.umlv.ir3.emagine.apprentice;

import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
public class DepartmentEnum extends EmagineEnum<DepartmentEnum>{

	public static final DepartmentEnum D01 =  new DepartmentEnum("D1", "Ain");
	public static final DepartmentEnum D02 =  new DepartmentEnum("D2", "Aisne");

	private static final long serialVersionUID = -3760839927504476550L;
	
	private String departementName;
	
	public DepartmentEnum(String string, String departementName) {
		super(string);
		this.departementName = departementName;
	}

	public String getDepartementName() {
		return departementName;
	}
}
