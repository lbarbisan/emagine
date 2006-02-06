package fr.umlv.ir3.emagine.firm;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;


/**
 * Use to Use Create Form
 * @author jrenaudi
 *
 */
public class FirmModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Firm to modify **/
	private String idFirmToModify;
	
	/** Firm name **/
	private String name;

	/** Firm address **/
	private String street;

	/** Firm address **/
	private String address;

	/** Firm postal code **/
	private String postalCode;
	
	/** Firm city **/
	private String city;
	
	/** Firm portable phone **/
	private String portable;
		
	/** Firm fixe phone **/
	private String fixe;

	/** Firm web site **/
	private String web;

	/** Identifier of selected firm parent **/
	private String idParent;

	/** List of all firms **/
	private Collection <Firm> firms;

	/** Identifier of selected department **/
	private String idDepartment;

	/** List of all departments **/
	private Collection <DepartmentEnum> departments;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		/*
		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(name) || "".equals(address) || "".equals(fixe) || "".equals(postalCode) || "".equals(city) || "".equals(web))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
		}
		*/			

		return errors;
	}

	/**
	 * Reset information
	 */
	public void reset() {
		idFirmToModify = "";
		name = "";
		address = "";
		postalCode = "";
		city = "";
		portable = "";
		fixe = "";
		web = "";
		idParent = "";
		firms = null;
		idDepartment = "";
		departments = null;
		action = "";
	}
	
	
	/**
	 * @return Returns the fixe.
	 */
	public String getFixe() {
		return fixe;
	}

	/**
	 * @param fixe The fixe to set.
	 */
	public void setFixe(String fixe) {
		this.fixe = fixe;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return Returns the address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address The address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
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
	public void setPostalCode(String login) {
		this.postalCode = login;
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
	public void setCity(String password) {
		this.city = password;
	}


	/**
	 * @return Returns the portable.
	 */
	public String getPortable() {
		return portable;
	}

	/**
	 * @param portable The portable to set.
	 */
	public void setPortable(String repassword) {
		this.portable = repassword;
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
	 * @return Returns the idFirmToModify.
	 */
	public String getIdFirmToModify() {
		return idFirmToModify;
	}

	/**
	 * @param idFirmToModify The idFirmToModify to set.
	 */
	public void setIdFirmToModify(String idFirmToModify) {
		this.idFirmToModify = idFirmToModify;
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
	 * @return Returns the firms.
	 */
	public Collection<Firm> getFirms() {
		return firms;
	}

	/**
	 * @param firms The firms to set.
	 */
	public void setFirms(Collection<Firm> firms) {
		this.firms = firms;
	}

	/**
	 * @return Returns the idParent.
	 */
	public String getIdParent() {
		return idParent;
	}

	/**
	 * @param idParent The idParent to set.
	 */
	public void setIdParent(String idParent) {
		this.idParent = idParent;
	}

	/**
	 * @return Returns the web.
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web The web to set.
	 */
	public void setWeb(String web) {
		this.web = web;
	}
}
