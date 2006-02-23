package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;


/**
 * Form for Teacher
 * @author mmancel
 *
 */
public class TeacherTutorSearchForm extends SelectSearchForm<TeacherTutor> implements TeacherTutorSearchParams {
	
	private static final long serialVersionUID = -2405706291327109100L;

	/** Teacher firstname **/
	private String firstName;

	/** Teacher lastName **/
	private String lastName;

	/** action **/
	private String action;
	
	
	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		firstName = "";
		lastName = "";
		action = "";
		super.reset();
	}

	/**
	 * @return Returns the firstName.
	 */
	@IsASearchParam("teachertutor.firstName")
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return Returns the lastName.
	 */
	@IsASearchParam("teachertutor.lastName")
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

}