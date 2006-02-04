package fr.umlv.ir3.emagine.extraction;

import java.io.OutputStream;

import fr.umlv.ir3.emagine.util.EMagineException;

public interface Extractor {

	/**
	 * Extracts the given extractable, and uses the given outputStream to write its result.
	 * @param extractable the extractable to extract
	 * @param outputStream the outputStream where to write
	 * @throws EMagineException can throw this exception depending on the implementation
	 */
	public void extract(Extractable extractable, OutputStream outputStream) throws EMagineException;

}
