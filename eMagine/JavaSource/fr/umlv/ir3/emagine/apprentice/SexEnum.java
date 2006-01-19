package fr.umlv.ir3.emagine.apprentice;


public enum SexEnum {
	MALE("homme"),
	FEMALE("femme");
	
	private String name;
	private SexEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
