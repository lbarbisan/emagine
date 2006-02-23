package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.Collection;

import fr.umlv.ir3.emagine.extraction.PropertiesExtractionForm;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingType;

public class MailForm extends PropertiesExtractionForm {
	private static final long serialVersionUID = -5240024157544833994L;
	
	protected Collection<MailingType> mailingTypes;
	protected String mailingTypeId;
	protected MailingType mailingType;
	
	/**
	 * @return Returns the mailingType.
	 */
	public MailingType getMailingType() {
		return mailingType;
	}
	/**
	 * @param mailingType The mailingType to set.
	 */
	public void setMailingType(MailingType mailingType) {
		this.mailingType = mailingType;
	}
	/**
	 * @return Returns the mailingTypeId.
	 */
	public String getMailingTypeId() {
		return mailingTypeId;
	}
	/**
	 * @param mailingTypeId The mailingTypeId to set.
	 */
	public void setMailingTypeId(String mailingTypeId) {
		this.mailingTypeId = mailingTypeId;
	}
	/**
	 * @return Returns the mailingTypes.
	 */
	public Collection<MailingType> getMailingTypes() {
		return mailingTypes;
	}
	/**
	 * @param mailingTypes The mailingTypes to set.
	 */
	public void setMailingTypes(Collection<MailingType> mailingTypes) {
		this.mailingTypes = mailingTypes;
	}
	
	public String getExtractionTitleKey() {
		return "mail."+extractionEntityName+".title";
	}

	
}
