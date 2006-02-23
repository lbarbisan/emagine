package fr.umlv.ir3.emagine.extraction.mailings;


public class MailingSearchForm extends MailForm {
	private static final long serialVersionUID = -1688420083542388407L;
	
	public String getExtractionTitleKey() {
		return "mailing."+extractionEntityName+".title";
	}

	
}
