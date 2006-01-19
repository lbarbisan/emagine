package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;

import org.apache.struts.action.ActionForm;


public class FormationCenterListForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Use to DispacthAction **/
	private String action;
	
	private Collection<FormationCenter> centers;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		action = "";
		centers = null;
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


}
