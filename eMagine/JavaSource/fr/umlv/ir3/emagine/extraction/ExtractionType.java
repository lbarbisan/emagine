package fr.umlv.ir3.emagine.extraction;


public enum ExtractionType {
	CSV ("text/comma-separated-values", "csv"),
	XLS ("Application/vnd.ms-excel", "xls");	// or application/msexcel ?
	
	private final String mimeType;
	private final String fileExtension;
	
	ExtractionType(String mimeType, String fileExtension) {
		this.mimeType = mimeType;
		this.fileExtension = fileExtension;
	}
	
	public String mimeType() { return mimeType; }
	public String fileExtension() { return fileExtension; }
}
