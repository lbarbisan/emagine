package fr.umlv.ir3.emagine.apprentice;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ApprenticeModifyForm extends ActionForm {

	private static final long serialVersionUID = -1120295787399332929L;
	
	/*****************************************
	 *
	 * Part of the form concerned by the absence tab :
	 * 
	******************************************/
	
	/** Identifier of candidate to modify **/
	private String idAbsenceToModify;
	
	/** absence initial date **/
	private String initDate;
	
	/** absence end date **/
	private String endDate;
	
	/** absence number of days **/
	private String nbDays;
	
	/** List of all justifications **/
	//TODO private Collection <JustificationEnum> justifications;
	
	/** Identifier of selected justification **/
	private String idJustification;

	/** absence comment **/
	private String comment ;

	/*****************************************
	 *
	 * Part of the form concerned by the adress tab :
	 * 
	******************************************/
	
	/** Identifier of candidate to modify **/
	private String idApprenticeToModify;
	
	/** personnal adress **/
	private String persAdress;
	
	/** personnal postal code **/
	private String persPostalCode;

	/** personnal city **/
	private String persCity;
	
	/** personnal department **/
	private String persDepartment;

	/** personnal phone **/
	private String persPhone;

	/** personnal mobile phone **/
	private String persMobile;

	/** personnal fax **/
	private String persFax;

	/** personnal eMail **/
	private String persEmail;
	
	/** professional adress **/
	private String profAdress;
	
	/** professional postal code **/
	private String profPostalCode;

	/** professional city **/
	private String profCity;
	
	/** professional department **/
	private String profDepartment;

	/** professional phone **/
	private String profPhone;

	/** professional mobile phone **/
	private String profMobile;

	/** professional fax **/
	private String profFax;

	/** professional eMail **/
	private String profEmail;

	/** academic adress **/
	private String acaAdress;
	
	/** academic postal code **/
	private String acaPostalCode;

	/** academic city **/
	private String acaCity;
	
	/** academic department **/
	private String acaDepartment;

	/** academic phone **/
	private String acaPhone;

	/** academic mobile phone **/
	private String acaMobile;

	/** academic fax **/
	private String acaFax;

	/** academic eMail **/
	private String acaEmail;

	/** Use to action **/
	private String action;

	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(initDate) || "".equals(endDate) || "".equals(idJustification)){
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}
			else {
			/* TODO if (!isValide(initDate) || !isValide(endDate) ){
				errors.add("wrongDateFormat", new ActionMessage("candidate.error.wrongDateFormat"));
				}
			*/
			}
		}

		return errors;
	}

/*	private boolean isValide(String date) {
		//FIXME créer une méthode vérifiant le format
	}
*/

	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		initDate = ""; //TODO mettre la date du jour ?
		endDate = ""; //TODO mettre la date du jour ?
		nbDays = "";
		//justifications = null;
		idJustification = "";
		comment = "";
		persAdress = "";
		persCity = "";
		persDepartment = "";
		persEmail ="";
		persFax = "";
		persMobile = "";
		persPhone ="";
		persPostalCode = "";
		profAdress = "";
		profCity = "";
		profDepartment = "";
		profEmail ="";
		profFax = "";
		profMobile = "";
		profPhone ="";
		profPostalCode = "";
		acaAdress = "";
		acaCity = "";
		acaDepartment = "";
		acaEmail ="";
		acaFax = "";
		acaMobile = "";
		acaPhone ="";
		acaPostalCode = "";
		action = "";
		idAbsenceToModify = "";
		idApprenticeToModify = "";
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
	 * @return Returns the nbDays.
	 */
	public String getNbDays() {
		return nbDays;
	}

	/**
	 * @param nbDays The nbDays to set.
	 */
	public void setNbDays(String nbDays) {
		this.nbDays = nbDays;
	}

	/**
	 * @return Returns the acaAdress.
	 */
	public String getAcaAdress() {
		return acaAdress;
	}

	/**
	 * @param acaAdress The acaAdress to set.
	 */
	public void setAcaAdress(String acaAdress) {
		this.acaAdress = acaAdress;
	}

	/**
	 * @return Returns the acaCity.
	 */
	public String getAcaCity() {
		return acaCity;
	}

	/**
	 * @param acaCity The acaCity to set.
	 */
	public void setAcaCity(String acaCity) {
		this.acaCity = acaCity;
	}

	/**
	 * @return Returns the acaDepartment.
	 */
	public String getAcaDepartment() {
		return acaDepartment;
	}

	/**
	 * @param acaDepartment The acaDepartment to set.
	 */
	public void setAcaDepartment(String acaDepartment) {
		this.acaDepartment = acaDepartment;
	}

	/**
	 * @return Returns the acaEmail.
	 */
	public String getAcaEmail() {
		return acaEmail;
	}

	/**
	 * @param acaEmail The acaEmail to set.
	 */
	public void setAcaEmail(String acaEmail) {
		this.acaEmail = acaEmail;
	}

	/**
	 * @return Returns the acaFax.
	 */
	public String getAcaFax() {
		return acaFax;
	}

	/**
	 * @param acaFax The acaFax to set.
	 */
	public void setAcaFax(String acaFax) {
		this.acaFax = acaFax;
	}

	/**
	 * @return Returns the acaMobile.
	 */
	public String getAcaMobile() {
		return acaMobile;
	}

	/**
	 * @param acaMobile The acaMobile to set.
	 */
	public void setAcaMobile(String acaMobile) {
		this.acaMobile = acaMobile;
	}

	/**
	 * @return Returns the acaPhone.
	 */
	public String getAcaPhone() {
		return acaPhone;
	}

	/**
	 * @param acaPhone The acaPhone to set.
	 */
	public void setAcaPhone(String acaPhone) {
		this.acaPhone = acaPhone;
	}

	/**
	 * @return Returns the acaPostalCode.
	 */
	public String getAcaPostalCode() {
		return acaPostalCode;
	}

	/**
	 * @param acaPostalCode The acaPostalCode to set.
	 */
	public void setAcaPostalCode(String acaPostalCode) {
		this.acaPostalCode = acaPostalCode;
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

	/**
	 * @return Returns the persAdress.
	 */
	public String getPersAdress() {
		return persAdress;
	}

	/**
	 * @param persAdress The persAdress to set.
	 */
	public void setPersAdress(String persAdress) {
		this.persAdress = persAdress;
	}

	/**
	 * @return Returns the persCity.
	 */
	public String getPersCity() {
		return persCity;
	}

	/**
	 * @param persCity The persCity to set.
	 */
	public void setPersCity(String persCity) {
		this.persCity = persCity;
	}

	/**
	 * @return Returns the persDepartment.
	 */
	public String getPersDepartment() {
		return persDepartment;
	}

	/**
	 * @param persDepartment The persDepartment to set.
	 */
	public void setPersDepartment(String persDepartment) {
		this.persDepartment = persDepartment;
	}

	/**
	 * @return Returns the persEmail.
	 */
	public String getPersEmail() {
		return persEmail;
	}

	/**
	 * @param persEmail The persEmail to set.
	 */
	public void setPersEmail(String persEmail) {
		this.persEmail = persEmail;
	}

	/**
	 * @return Returns the persFax.
	 */
	public String getPersFax() {
		return persFax;
	}

	/**
	 * @param persFax The persFax to set.
	 */
	public void setPersFax(String persFax) {
		this.persFax = persFax;
	}

	/**
	 * @return Returns the persMobile.
	 */
	public String getPersMobile() {
		return persMobile;
	}

	/**
	 * @param persMobile The persMobile to set.
	 */
	public void setPersMobile(String persMobile) {
		this.persMobile = persMobile;
	}

	/**
	 * @return Returns the persPhone.
	 */
	public String getPersPhone() {
		return persPhone;
	}

	/**
	 * @param persPhone The persPhone to set.
	 */
	public void setPersPhone(String persPhone) {
		this.persPhone = persPhone;
	}

	/**
	 * @return Returns the persPostalCode.
	 */
	public String getPersPostalCode() {
		return persPostalCode;
	}

	/**
	 * @param persPostalCode The persPostalCode to set.
	 */
	public void setPersPostalCode(String persPostalCode) {
		this.persPostalCode = persPostalCode;
	}

	/**
	 * @return Returns the profAdress.
	 */
	public String getProfAdress() {
		return profAdress;
	}

	/**
	 * @param profAdress The profAdress to set.
	 */
	public void setProfAdress(String profAdress) {
		this.profAdress = profAdress;
	}

	/**
	 * @return Returns the profCity.
	 */
	public String getProfCity() {
		return profCity;
	}

	/**
	 * @param profCity The profCity to set.
	 */
	public void setProfCity(String profCity) {
		this.profCity = profCity;
	}

	/**
	 * @return Returns the profDepartment.
	 */
	public String getProfDepartment() {
		return profDepartment;
	}

	/**
	 * @param profDepartment The profDepartment to set.
	 */
	public void setProfDepartment(String profDepartment) {
		this.profDepartment = profDepartment;
	}

	/**
	 * @return Returns the profEmail.
	 */
	public String getProfEmail() {
		return profEmail;
	}

	/**
	 * @param profEmail The profEmail to set.
	 */
	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}

	/**
	 * @return Returns the profFax.
	 */
	public String getProfFax() {
		return profFax;
	}

	/**
	 * @param profFax The profFax to set.
	 */
	public void setProfFax(String profFax) {
		this.profFax = profFax;
	}

	/**
	 * @return Returns the profMobile.
	 */
	public String getProfMobile() {
		return profMobile;
	}

	/**
	 * @param profMobile The profMobile to set.
	 */
	public void setProfMobile(String profMobile) {
		this.profMobile = profMobile;
	}

	/**
	 * @return Returns the profPhone.
	 */
	public String getProfPhone() {
		return profPhone;
	}

	/**
	 * @param profPhone The profPhone to set.
	 */
	public void setProfPhone(String profPhone) {
		this.profPhone = profPhone;
	}

	/**
	 * @return Returns the profPostalCode.
	 */
	public String getProfPostalCode() {
		return profPostalCode;
	}

	/**
	 * @param profPostalCode The profPostalCode to set.
	 */
	public void setProfPostalCode(String profPostalCode) {
		this.profPostalCode = profPostalCode;
	}

}
