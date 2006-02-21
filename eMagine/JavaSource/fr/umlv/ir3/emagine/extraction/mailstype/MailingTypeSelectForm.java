package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class MailingTypeSelectForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;
	

	/** List of mailing type **/
	private List <MailingType> mailingTypes;
	
	/** Identifier of selected mailing type **/
	private String idMailingType;

	/** content of mail **/
	private String content;

	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		action = "";
		mailingTypes = null;
		idMailingType = "";
		content = "";
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
	 * @return Returns the idMailingType.
	 */
	public String getIdMailingType() {
		return idMailingType;
	}


	/**
	 * @param idMailingType The idMailingType to set.
	 */
	public void setIdMailingType(String idMailingType) {
		this.idMailingType = idMailingType;
	}


	/**
	 * @return Returns the mailingTypes.
	 */
	public List<MailingType> getMailingTypes() {
		return mailingTypes;
	}


	/**
	 * @param mailingTypes The mailingTypes to set.
	 */
	public void setMailingTypes(List<MailingType> mailingTypes) {
		this.mailingTypes = mailingTypes;
	}


	/**
	 * @return Returns the content.
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content The content to set.
	 */
	public void setContent(String content) {
		this.content = content;
	}


}
