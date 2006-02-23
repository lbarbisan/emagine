package fr.umlv.ir3.emagine.firm.actor;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class FirmActorModifyForm extends SelectSearchForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** FirmActor to modify **/
	private String idFirmActorToModify;

	/** Lastname **/
	private String lastname;

	/** Firstname **/
	private String firstname;

	/** Adresse **/
	private String adress;

	/** Postal Code **/
	private String postalCode;

	/** City **/
	private String city;

	/** Fix Phone **/
	private String fixPhone;

	/** Portable Phone **/
	private String portPhone;

	/** Fax **/
	private String fax;

	/** E-Mail **/
	private String mail;

	/** List of function **/
	private Collection <FunctionEnum> functions;

	/** Identifier of selected profession **/
	private String idFunction;

	/** List of department **/
	private Collection <DepartmentEnum> departments;

	/** Identifier of selected department **/
	private String idDepartment;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		
		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(lastname) || "".equals(firstname) || "".equals(adress) || "".equals(postalCode)
					|| "".equals(city) || "".equals(mail) || "".equals(idDepartment) || "".equals(idFunction)) {
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}
		}

		return errors;
	}

	/**
	 * Reset information
	 */
	public void reset() {
		idFirmActorToModify = "";
		lastname = "";
		firstname = "";
		adress = "";
		postalCode = "";
		city = "";
		fixPhone = "";
		portPhone = "";
		fax = "";
		mail = "";
		functions = null;
		idFunction = "";
		departments = null;
		idDepartment = "";
		action = "";
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
	 * @return Returns the adress.
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * @param adress The adress to set.
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return Returns the departments.
	 */
	public Collection<DepartmentEnum> getDepartments() {
		return departments;
	}

	/**
	 * @param departments The departments to set.
	 */
	public void setDepartments(Collection<DepartmentEnum> departments) {
		this.departments = departments;
	}

	/**
	 * @return Returns the fax.
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return Returns the firstname.
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname The firstname to set.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return Returns the fixPhone.
	 */
	public String getFixPhone() {
		return fixPhone;
	}

	/**
	 * @param fixPhone The fixPhone to set.
	 */
	public void setFixPhone(String fixPhone) {
		this.fixPhone = fixPhone;
	}

	/**
	 * @return Returns the idDepartment.
	 */
	public String getIdDepartment() {
		return idDepartment;
	}

	/**
	 * @param idDepartment The idDepartment to set.
	 */
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	/**
	 * @return Returns the idFirmActorToModify.
	 */
	public String getIdFirmActorToModify() {
		return idFirmActorToModify;
	}

	/**
	 * @param idFirmActorToModify The idFirmActorToModify to set.
	 */
	public void setIdFirmActorToModify(String idFirmActorToModify) {
		this.idFirmActorToModify = idFirmActorToModify;
	}

	/**
	 * @return Returns the idFunction.
	 */
	public String getIdFunction() {
		return idFunction;
	}

	/**
	 * @param idFunction The idFunction to set.
	 */
	public void setIdFunction(String idFunction) {
		this.idFunction = idFunction;
	}

	/**
	 * @return Returns the lastname.
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname The lastname to set.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return Returns the portPhone.
	 */
	public String getPortPhone() {
		return portPhone;
	}

	/**
	 * @param portPhone The portPhone to set.
	 */
	public void setPortPhone(String portPhone) {
		this.portPhone = portPhone;
	}

	/**
	 * @return Returns the postalCode.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode The postalCode to set.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return Returns the functions.
	 */
	public Collection<FunctionEnum> getFunctions() {
		return functions;
	}

	/**
	 * @param functions The functions to set.
	 */
	public void setFunctions(Collection<FunctionEnum> functions) {
		this.functions = functions;
	}

	/**
	 * @return Returns the mail.
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail The mail to set.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
}
