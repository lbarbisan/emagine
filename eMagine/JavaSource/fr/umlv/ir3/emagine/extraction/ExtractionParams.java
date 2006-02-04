package fr.umlv.ir3.emagine.extraction;

/**
 * Parameters of an extraction. It's an extraction config with an extra method to know if the user wants to save that config or not.
 * @author aogier
 */
public interface ExtractionParams extends ExtractionConfig {
	/**
	 * @return <code>true</code> if the user wants to save the configuration, <code>false</code> otherwise.
	 */
	public boolean isSaveConfig();
}