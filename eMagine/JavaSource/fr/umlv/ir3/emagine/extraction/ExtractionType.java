package fr.umlv.ir3.emagine.extraction;

public enum ExtractionType {
	CSV ("text/comma-separated-values"),
	XLS ("application/msexcel");
	
	private final String mimeType;
	
	ExtractionType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public String mimeType() { return mimeType; }
}
