package fr.umlv.ir3.emagine.apprentice.candidate.room;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


/**
 * Form for Formation Center
 * @author mmancel
 *
 */
public class RoomModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	private String idRoomToModify;
	private String action;
	private String name;
	private String capacity;
	private String nbDispo;
	private String idCenter;
	

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if("create".equals(action) || "show".equals(action) ) {
			if("".equals(name) || "".equals(capacity))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
		}			
		return errors;
	}
	
	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		action = "";
		name = "";
		idRoomToModify = "";
		capacity = "";
		nbDispo = "";
		//idCenter = "";
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
	 * @return Returns the capacity.
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity The capacity to set.
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return Returns the idRoomToModify.
	 */
	public String getIdRoomToModify() {
		return idRoomToModify;
	}

	/**
	 * @param idRoomToModify The idRoomToModify to set.
	 */
	public void setIdRoomToModify(String idRoomToModify) {
		this.idRoomToModify = idRoomToModify;
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
	 * @return Returns the nbDispo.
	 */
	public String getNbDispo() {
		return nbDispo;
	}

	/**
	 * @param nbDispo The nbDispo to set.
	 */
	public void setNbDispo(String nbDispo) {
		this.nbDispo = nbDispo;
	}

	/**
	 * @return Returns the idCenter.
	 */
	public String getIdCenter() {
		return idCenter;
	}

	/**
	 * @param idCenter The idCenter to set.
	 */
	public void setIdCenter(String id) {
		this.idCenter = id;
	}
}

	
