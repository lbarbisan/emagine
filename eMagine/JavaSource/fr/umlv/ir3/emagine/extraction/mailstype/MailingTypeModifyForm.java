package fr.umlv.ir3.emagine.extraction.mailstype;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class MailingTypeModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Firm to modify **/
	private String idMailingTypeToModify;
	
	/** Title **/
	private String title;

	/** Joined File **/
	private FormFile attachment;
	
	/** Comment **/
	private String comment;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(title))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));

		}			

		return errors;
	}

	/**
	 * Reset information
	 */
	public void reset() {
		idMailingTypeToModify = "";
		title = "";
		attachment = null;
		comment = "";
		action = "";
	}

	/**
	 * @return Returns the action.
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action The action to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return Returns the attachment.
	 */
	public FormFile getAttachment() {
		return attachment;
	}

	/**
	 * @param attachment The attachment to set.
	 */
	public void setAttachment(FormFile attachment) {
		this.attachment = attachment;
	}

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
	 * @return Returns the idMailingTypeToModify.
	 */
	public String getIdMailingTypeToModify() {
		return idMailingTypeToModify;
	}

	/**
	 * @param idMailingTypeToModify The idMailingTypeToModify to set.
	 */
	public void setIdMailingTypeToModify(String idMailingTypeToModify) {
		this.idMailingTypeToModify = idMailingTypeToModify;
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
}
