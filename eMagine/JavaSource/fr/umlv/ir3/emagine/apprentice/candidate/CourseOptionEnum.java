package fr.umlv.ir3.emagine.apprentice.candidate;

public enum CourseOptionEnum {
	MFPI("MFPI"),
	IR("IR"),
	MI("MI");
	
	private String name;
	private CourseOptionEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return this.toString();
	}
}
