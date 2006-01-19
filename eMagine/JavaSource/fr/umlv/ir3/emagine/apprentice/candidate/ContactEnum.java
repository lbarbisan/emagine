package fr.umlv.ir3.emagine.apprentice.candidate;

public enum ContactEnum {
	C1("Internet"),
	C2("Lycée, IUT"),
	C3("JPO");
	
	private String name;
	private ContactEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
