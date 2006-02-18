package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class ApprenticeSearchForm extends SelectSearchForm<Apprentice> implements ApprenticeSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String firstName;

	//@IsASearchParam
	private String lastName;
	
	/** List of all option courses **/
	private Collection <CourseOptionEnum> courseOptions;

	//@IsASearchParam
	private String idCourseOption;
	
	/** List of all years **/
	private Collection <YearEnum> years;

	//@IsASearchParam
	private String idYear;

	/** Use to DispacthAction **/
	private String action;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		firstName = "";
		lastName = "";
		courseOptions = null;
		idCourseOption = "";
		years = null;
		idYear = "";
		deletionForced = false;
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
	@IsASearchParam("apprentice.firstName")
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
	 * @return Returns the idCourseOption.
	 */
	@IsASearchParam(value = "apprentice.courseOption.id", type = Long.class)
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
	 * @return Returns the idYear.
	 */
	@IsASearchParam(value = "apprentice.year.id", type = Long.class)
	public String getIdYear() {
		return idYear;
	}

	/**
	 * @param idYear The idYear to set.
	 */
	public void setIdYear(String idYear) {
		this.idYear = idYear;
	}

	/**
	 * @return Returns the lastName.
	 */
	@IsASearchParam("apprentice.lastName")
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
	 * @return Returns the years.
	 */
	public Collection<YearEnum> getYears() {
		return years;
	}

	/**
	 * @param years The years to set.
	 */
	public void setYears(Collection<YearEnum> years) {
		this.years = years;
	}
}
