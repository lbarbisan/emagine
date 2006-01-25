package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class CandidateSearchForm extends SelectSearchForm<Candidate> implements CandidateSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String firstName;

	//@IsASearchParam
	private String lastName;

	//@IsASearchParam
	private String idCenter;

	//@IsASearchParam
	private String idCourseOption;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;

	/** List of all option courses **/
	private Collection <CourseOptionEnum> courseOptions;

	/** List of all formation centers **/
	private Collection <FormationCenter> centers;

	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		firstName = "";
		lastName = "";
		centers = null;
		idCenter = "";
		deletionForced = false;
		idCourseOption = "";
		courseOptions = null;
		action = "";
		super.reset();
	}
	
	
	/**
	 * @return Returns the deletionForced.
	 */
	public boolean isDeletionForced() {
		return deletionForced;
	}
	/**
	 * @param deletionForced The deletionForced to set.
	 */
	public void setDeletionForced(boolean deletionForced) {
		this.deletionForced = deletionForced;
	}
	/**
	 * @return Returns the firstName.
	 */
	@IsASearchParam("candidate.firstName")
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
	@IsASearchParam("candidate.lastName")
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
	public void setAction(String dispatch) {
		this.action = dispatch;
	}


	/**
	 * @return Returns the centers.
	 */
	public Collection<FormationCenter> getCenters() {
		return centers;
	}


	/**
	 * @param centers The centers to set.
	 */
	public void setCenters(Collection<FormationCenter> centers) {
		this.centers = centers;
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
	 * @return Returns the idCenter.
	 */
	@IsASearchParam(value="candidate.formationCenter.id",type=Long.class)
	public String getIdCenter() {
		return idCenter;
	}


	/**
	 * @param idCenter The idCenter to set.
	 */
	public void setIdCenter(String idCenter) {
		this.idCenter = idCenter;
	}


	/**
	 * @return Returns the idOptionCourse.
	 */
	@IsASearchParam(value="candidate.courseOption.id",type=Long.class)
	public String getIdCourseOption() {
		return idCourseOption;
	}


	/**
	 * @param idOptionCourse The idOptionCourse to set.
	 */
	public void setIdCourseOption(String idCourseOption) {
		this.idCourseOption = idCourseOption;
	}

}
