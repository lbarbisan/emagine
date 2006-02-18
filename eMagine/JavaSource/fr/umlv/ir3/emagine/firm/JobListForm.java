package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class JobListForm extends SelectSearchForm<Job> {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;
	
	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		deletionForced = false;
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
