package fr.umlv.ir3.emagine.extraction;

import java.io.OutputStream;

import fr.umlv.ir3.emagine.util.EMagineException;

public interface Extractor {

	public void extract(ExtractionParam extractionParam, OutputStream outputStream) throws EMagineException;

}
