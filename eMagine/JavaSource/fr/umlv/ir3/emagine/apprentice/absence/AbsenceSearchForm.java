package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.util.DateOperations;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class AbsenceSearchForm extends SelectSearchForm<Absence> implements AbsenceSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String startDate;

	//@IsASearchParam
	private String endDate;
	
	/** List of all justifications **/
	private Collection <JustificationEnum> justifications;

	//@IsASearchParam	
	private String idJustification;
	
	/** Identifier of apprentice to modify **/
	private String idApprenticeToModify;
	
	/** Identifier of absence to modify **/
	private String idAbsenceToModify;
	
	/** Use to idApprentice **/
	private String action;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("search".equals(action)) {
			if(DateOperations.checkStringDate(startDate) || DateOperations.checkStringDate(endDate)){
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("absence.error.date.conflict"));
			}
		}

		return errors;
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		startDate="";
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
	@IsASearchParam(value = "absence.endDate", type = Long.class)
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
	@IsASearchParam(value = "absence.justification.id", type = Long.class)
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

	/**
	 * @return Returns the startDate.
	 */
	@IsASearchParam(value = "absence.startDate", type = Long.class)
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return Returns the idAbsenceToModify.
	 */
	public String getIdAbsenceToModify() {
		return idAbsenceToModify;
	}

	/**
	 * @param idAbsenceToModify The idAbsenceToModify to set.
	 */
	public void setIdAbsenceToModify(String idAbsenceToModify) {
		this.idAbsenceToModify = idAbsenceToModify;
	}

	/**
	 * @return Returns the idApprenticeToModify.
	 */
	public String getIdApprenticeToModify() {
		return idApprenticeToModify;
	}

	/**
	 * @param idApprenticeToModify The idApprenticeToModify to set.
	 */
	public void setIdApprenticeToModify(String idApprenticeToModify) {
		this.idApprenticeToModify = idApprenticeToModify;
	}

}
