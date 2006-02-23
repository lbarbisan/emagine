package fr.umlv.ir3.emagine.extraction.mailings;

import fr.umlv.ir3.emagine.extraction.PropertiesExtractionForm;



/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class MailingListCreationForm extends PropertiesExtractionForm {
	
	private static final long serialVersionUID = -186202906893568954L;
	
	protected String comment;
	protected String title;
	

	/**
	 * @return Returns the comment.
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment The comment to set.
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return Returns the title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title The title to set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getExtractionTitleKey() {
		return "mailing."+extractionEntityName+".title";
	}
	
}
