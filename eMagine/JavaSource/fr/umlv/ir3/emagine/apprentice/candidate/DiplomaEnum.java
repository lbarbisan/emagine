package fr.umlv.ir3.emagine.apprentice.candidate;

public enum DiplomaEnum {
	D1("Baccalauréat"),
	D2("IUT"),
	D3("BTS");
	
	private String name;
	private DiplomaEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
