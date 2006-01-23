package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class BringingTogetherForm extends SelectSearchForm<Candidate> implements BringingTogetherParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	//@IsASearchParam
	private String idCourseOption;
	
	/** List of all option courses **/
	private Collection <CourseOptionEnum> courseOptions;

	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		idCourseOption = "";
		courseOptions = null;
		action = "";
		super.reset();
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
	 * @return Returns the idOptionCourse.
	 */
	@IsASearchParam("candidate.courseOption.id")
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
