package fr.umlv.ir3.emagine.extraction.mailings;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class MailingListListForm extends SelectSearchForm<MailingList> {
	
	private static final long serialVersionUID = -2405706291327109100L;
	
	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
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
}
