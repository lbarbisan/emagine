package fr.umlv.ir3.emagine.extraction.mailstype;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class MailingTypeListForm extends SelectSearchForm<MailingType> {
	
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
