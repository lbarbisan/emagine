package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class AbsenceCreateForm extends SelectSearchForm<Absence>{
	

	private static final long serialVersionUID = 1L;

	/** debute of absence **/
	private String initDate;

	/** end of absence **/
	private String endDate;
	
	/** List of all justifications **/
	private Collection <JustificationEnum> justifications;

	private String idJustification;
	
	/** comment about the absence **/
	private String comment;
	
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
		comment="";
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
