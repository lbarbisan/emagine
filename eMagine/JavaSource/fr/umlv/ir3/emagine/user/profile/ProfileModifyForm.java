package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class ProfileModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;


	/** Profile to modify **/
	private String idProfileToModify;

	/** User to modify **/
	private String name;
	
	/** User firstname **/
	private String description;

	/** Identifier of selected rights **/
	private String[] rightIds;

	/** List of all rights **/
	private Collection <Right> rights;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(name))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
		}			

		return errors;
	}

	/**
	 * Reset information
	 */
	public void reset() {
		name = "";
		description = "";
		rightIds = null;
		rights = null;
		idProfileToModify = "";
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
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the rightIds.
	 */
	public String[] getRightIds() {
		return rightIds;
	}

	/**
	 * @param rightIds The rightIds to set.
	 */
	public void setRightIds(String[] rightIds) {
		this.rightIds = rightIds;
	}

	/**
	 * @return Returns the rights.
	 */
	public Collection<Right> getRights() {
		return rights;
	}

	/**
	 * @param rights The rights to set.
	 */
	public void setRights(Collection<Right> rights) {
		this.rights = rights;
	}

	/**
	 * @return Returns the idProfileToModify.
	 */
	public String getIdProfileToModify() {
		return idProfileToModify;
	}

	/**
	 * @param idProfileToModify The idProfileToModify to set.
	 */
	public void setIdProfileToModify(String idProfileToModify) {
		this.idProfileToModify = idProfileToModify;
	}
	
	
}
