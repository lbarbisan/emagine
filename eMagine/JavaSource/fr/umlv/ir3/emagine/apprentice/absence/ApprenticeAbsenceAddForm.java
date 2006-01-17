package fr.umlv.ir3.emagine.apprentice.absence;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class ApprenticeAbsenceAddForm extends SelectSearchForm<Absence>{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String initDate;
	private String endDate;
	private String comment;
	private String nbdays;
	private String justification;
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getInitDate() {
		return initDate;
	}
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNbdays() {
		return nbdays;
	}
	public void setNbdays(String nbdays) {
		this.nbdays = nbdays;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	
	
	
}
