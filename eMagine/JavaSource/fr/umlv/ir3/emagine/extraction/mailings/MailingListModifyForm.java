package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.util.person.Person;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class MailingListModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Firm to modify **/
	private String idMailingListToModify;
	
	/** Title **/
	private String title;
	
	/** Comment **/
	private String comment;

	/** Joined File **/
	private List <Person> personns;

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
		idMailingListToModify = "";
		title = "";
		personns = null;
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
	 * @return Returns the idMailingListToModify.
	 */
	public String getIdMailingListToModify() {
		return idMailingListToModify;
	}

	/**
	 * @param idMailingListToModify The idMailingListToModify to set.
	 */
	public void setIdMailingListToModify(String idMailingListToModify) {
		this.idMailingListToModify = idMailingListToModify;
	}

	/**
	 * @return Returns the personns.
	 */
	public List<Person> getPersonns() {
		return personns;
	}

	/**
	 * @param personns The personns to set.
	 */
	public void setPersonns(List<Person> personns) {
		this.personns = personns;
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
