package fr.umlv.ir3.emagine.event;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class EventSearchForm extends SelectSearchForm<Event> implements EventSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String dateBegin;

	//@IsASearchParam
	private String dateEnd;

	//@IsASearchParam
	private String idType;

	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;

	/** List of all department **/
	private Collection <EventTypeEnum> types;
	
	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		dateBegin = "";
		dateEnd = "";
		deletionForced = false;
		types = null;
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
	 * @return Returns the dateBegin.
	 */
	public String getDateBegin() {
		return dateBegin;
	}


	/**
	 * @param dateBegin The dateBegin to set.
	 */
	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}


	/**
	 * @return Returns the dateEnd.
	 */
	public String getDateEnd() {
		return dateEnd;
	}


	/**
	 * @param dateEnd The dateEnd to set.
	 */
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}


	/**
	 * @return Returns the idType.
	 */
	public String getIdType() {
		return idType;
	}


	/**
	 * @param idType The idType to set.
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}


	/**
	 * @return Returns the types.
	 */
	public Collection<EventTypeEnum> getTypes() {
		return types;
	}


	/**
	 * @param types The types to set.
	 */
	public void setTypes(Collection<EventTypeEnum> types) {
		this.types = types;
	}

	
}
