package fr.umlv.ir3.emagine.apprentice.candidate;

public enum ProfessionEnum {
	TECHNICAL("Technical"),
	JUDE("Jude"),
	PROFESSOR("Professor");
	
	private String name;
	private ProfessionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
	
}
