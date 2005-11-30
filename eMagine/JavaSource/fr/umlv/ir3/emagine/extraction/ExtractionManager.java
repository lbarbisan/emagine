package fr.umlv.ir3.emagine.extraction;

import java.io.OutputStream;

import fr.umlv.ir3.emagine.util.EMagineException;

public class ExtractionManager {

	public void extract(ExtractionParam extractionParam, OutputStream outputStream) throws EMagineException {
		Extractor extractor = ExtractionTypeFactory.getExtractor(extractionParam.getExtractionType());
		// TODO : gérer la sauvegarde de la configuration actuelle
		extractor.extract(extractionParam, outputStream);
	}
	
	//TODO : Use case « Configurer l'extraction d'une liste »	
	//TODO : Use case « Extraire une liste »
	

}
