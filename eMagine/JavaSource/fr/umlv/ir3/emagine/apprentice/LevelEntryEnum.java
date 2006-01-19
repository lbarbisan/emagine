package fr.umlv.ir3.emagine.apprentice;

<<<<<<< .mine
import javax.persistence.AccessType;
import javax.persistence.Entity;

import fr.umlv.ir3.emagine.util.EmagineEnum;

@Entity(access = AccessType.FIELD)
=======
>>>>>>> .r503
public class LevelEntryEnum extends EmagineEnum{
	public LevelEntryEnum(String string) {
		super(string);
	}
	L1("bac"),
	L2("+2"),
	L3("+3");
	
	private String name;
	private LevelEntryEnum(String name) {
		this.name = name;
	}

<<<<<<< .mine
	private static final long serialVersionUID = 5852967568688412340L;
=======
	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
>>>>>>> .r503
}
