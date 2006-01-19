package fr.umlv.ir3.emagine.apprentice;

public enum LevelEntryEnum {
	L1("bac"),
	L2("+2"),
	L3("+3");
	
	private String name;
	private LevelEntryEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
