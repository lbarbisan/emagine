package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.apprentice.YearEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class AbsenceSearchForm extends SelectSearchForm<Absence> implements AbsenceSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String initDate;

	//@IsASearchParam
	private String endDate;
	
	/** List of all justifications **/
	private Collection <JustificationEnum> justifications;

	//@IsASearchParam	
	private String idJustification;
	
	/** Use to DispacthAction **/
	private String action;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		initDate="";
		endDate="";
		justifications=null;
		idJustification="";
		action="";
		deletionForced=false;
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
	 * @return Returns the endDate.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return Returns the idJustification.
	 */
	public String getIdJustification() {
		return idJustification;
	}

	/**
	 * @param idJustification The idJustification to set.
	 */
	public void setIdJustification(String idJustification) {
		this.idJustification = idJustification;
	}

	/**
	 * @return Returns the initDate.
	 */
	public String getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate The initDate to set.
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return Returns the justifications.
	 */
	public Collection<JustificationEnum> getJustifications() {
		return justifications;
	}

	/**
	 * @param justifications The justifications to set.
	 */
	public void setJustifications(Collection<JustificationEnum> justifications) {
		this.justifications = justifications;
	}
}
