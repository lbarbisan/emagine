package fr.umlv.ir3.emagine.firm;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class JobModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Job to modify **/
	private String idJobToModify;

	/** Nombre de poste **/
	private String nbPostes;

	/** List of CourseOptionEnum **/
	private Collection <CourseOptionEnum> courseOptions;

	/** Identifier of selected Course Option **/
	private String idCourseOption;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(idCourseOption) || "".equals(nbPostes)) {
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}
			else {
				try {
					if(Integer.parseInt(nbPostes) <= 0)
						errors.add("nbPostesIsNotInteger", new ActionMessage("job.error.nbPostesIsNotInteger"));
				}
				catch (NumberFormatException e) {
					errors.add("nbPostesIsNotInteger", new ActionMessage("job.error.nbPostesIsNotInteger"));
				}
			}
		}

		return errors;
	}

	/**
	 * Reset information
	 */
	public void reset() {
		idJobToModify = "";
		idCourseOption = "";
		nbPostes = "";
		courseOptions = null;
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
	 * @return Returns the courseOptions.
	 */
	public Collection<CourseOptionEnum> getCourseOptions() {
		return courseOptions;
	}

	/**
	 * @param courseOptions The courseOptions to set.
	 */
	public void setCourseOptions(Collection<CourseOptionEnum> courseOptions) {
		this.courseOptions = courseOptions;
	}

	/**
	 * @return Returns the idCourseOption.
	 */
	public String getIdCourseOption() {
		return idCourseOption;
	}

	/**
	 * @param idCourseOption The idCourseOption to set.
	 */
	public void setIdCourseOption(String idCourseOption) {
		this.idCourseOption = idCourseOption;
	}

	/**
	 * @return Returns the idJobToModify.
	 */
	public String getIdJobToModify() {
		return idJobToModify;
	}

	/**
	 * @param idJobToModify The idJobToModify to set.
	 */
	public void setIdJobToModify(String idJobToModify) {
		this.idJobToModify = idJobToModify;
	}

	/**
	 * @return Returns the nbPostes.
	 */
	public String getNbPostes() {
		return nbPostes;
	}

	/**
	 * @param nbPostes The nbPostes to set.
	 */
	public void setNbPostes(String nbPostes) {
		this.nbPostes = nbPostes;
	}
}
