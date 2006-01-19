package fr.umlv.ir3.emagine.apprentice.candidate;

public enum SectionEnum {
	S1("Informatique"),
	S2("Scientificque"),
	S3("STT");
	
	private String name;
	private SectionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
