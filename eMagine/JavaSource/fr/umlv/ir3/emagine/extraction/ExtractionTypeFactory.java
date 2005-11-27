package fr.umlv.ir3.emagine.extraction;

import fr.umlv.ir3.emagine.util.EMagineException;

public class ExtractionTypeFactory {
	private static CSVExtractor csvExtractor = new CSVExtractor();
	private static XLSExtractor xlsExtractor = new XLSExtractor();
	
	public static Extractor getExtractor(ExtractionType extractionType) throws EMagineException {
		switch (extractionType) {
		case CSV:
			return csvExtractor;
		case XLS:
			return xlsExtractor;
		default:
			throw new EMagineException("exception.extraction.extractorNotFound");
		}
	}

	
}
