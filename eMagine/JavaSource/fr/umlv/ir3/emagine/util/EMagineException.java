package fr.umlv.ir3.emagine.util;

public class EMagineException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1731887239893501794L;

	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 */
	public EMagineException(String messageId) {
		super(messageId);
		// TODO EMagineException() Not Implemented
	}

	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 * @param cause The cause
	 */
	public EMagineException(String messageId, Throwable cause) {
		super(messageId, cause);
		// TODO EMagineException() Not Implemented
	}

	/**
	 * Gets the name of this exception string property
	 * @return
	 */
	public String getMessageId() {
		return getMessage();
	}
}
