package fr.umlv.ir3.emagine.extraction;

import java.io.OutputStream;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;

public interface Extractor {

	public void extract(Extractable extractable, OutputStream outputStream) throws EMagineException;

}
