package fr.umlv.ir3.emagine.util;


public class EMagineException extends Exception {
	protected String messageId;
	protected String[] params;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1731887239893501794L;

	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 */
	public EMagineException(String messageId) {
		super();
		this.messageId = messageId;
	}

	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 * @param cause The cause
	 */
	public EMagineException(String messageId, Throwable cause) {
		super(cause);
		this.messageId = messageId;
	}
	
	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 * @param params The parameters for the message of that exception
	 */
	public EMagineException(String messageId, String... params) {
		super();
		this.params = params;
		this.messageId = messageId;
	}

	/**
	 * An eMagine Exception.
	 * @param messageId The name of this exception string property
	 * @param cause The cause
	 * @param params The parameters for the message of that exception
	 */
	public EMagineException(String messageId, Throwable cause, String... params) {
		super(cause);
		this.params = params;
		this.messageId = messageId;
	}
	
	@Override
	public String getMessage() {
		try {
			final String message = Bundles.getMessageResources().getMessage(messageId, params);
			if (message == null) {
				return getBaseMessage();
			}
			return message;
		} catch (Exception e) {
			return getBaseMessage();
		}
	}
	
	public String getBaseMessage() {
		StringBuilder builder = new StringBuilder(messageId);
		if (params != null) {
			for (String param : params) {
				builder.append(" ["+param+"]");
			}
		}
		return builder.toString();
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
}
