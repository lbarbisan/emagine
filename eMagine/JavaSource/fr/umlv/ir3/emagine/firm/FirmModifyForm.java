package fr.umlv.ir3.emagine.firm;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;


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
	private String address;

	/** Firm postal code **/
	private String postalCode;
	
	/** Firm city **/
	private String city;
	
	/** Firm country **/
	private String country;
	
	/** Firm fixe phone **/
	private String phone;

	/** Firm web site **/
	private String web;

	/** Firm mail **/
	private String email;

	/** Firm fax **/
	private String fax;

	/** Identifier of selected firm parent **/
	private String idParentFirm;

	/** Identifier of selected firm parent **/
	private String nameParentFirm;

	/** List of child firms **/
	private Collection <Firm> childFirms;

	/** Identifier of selected department **/
	private String idDepartment;

	/** List of all departments **/
	private Collection <DepartmentEnum> departments;

	/** List of all events **/
	private Collection <Event> events;

	/** List of all jobs **/
	private Collection <Job> jobs;

	/** List of all jobs **/
	private Collection <FirmActor> actors;

	/** Use to DispacthAction **/
	private String action;


	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(name) || "".equals(address) || "".equals(postalCode) || "".equals(postalCode) || "".equals(city) || "".equals(web))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
		}			

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
		country = "";
		phone = "";
		web = "";
		email = "";
		fax = "";
		idParentFirm = "";
		nameParentFirm = "";
		childFirms = null;
		idDepartment = "";
		departments = null;
		events = null;
		jobs = null;
		actors = null;
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
	 * @return Returns the childFirms.
	 */
	public Collection<Firm> getChildFirms() {
		return childFirms;
	}

	/**
	 * @param childFirms The childFirms to set.
	 */
	public void setChildFirms(Collection<Firm> childFirms) {
		this.childFirms = childFirms;
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
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the events.
	 */
	public Collection<Event> getEvents() {
		return events;
	}

	/**
	 * @param events The events to set.
	 */
	public void setEvents(Collection<Event> events) {
		this.events = events;
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
	 * @return Returns the idParentFirm.
	 */
	public String getIdParentFirm() {
		return idParentFirm;
	}

	/**
	 * @param idParentFirm The idParentFirm to set.
	 */
	public void setIdParentFirm(String idParentFirm) {
		this.idParentFirm = idParentFirm;
	}

	/**
	 * @return Returns the jobs.
	 */
	public Collection<Job> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs The jobs to set.
	 */
	public void setJobs(Collection<Job> jobs) {
		this.jobs = jobs;
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
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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

	/**
	 * @return Returns the country.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country The country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return Returns the nameParentFirm.
	 */
	public String getNameParentFirm() {
		return nameParentFirm;
	}

	/**
	 * @param nameParentFirm The nameParentFirm to set.
	 */
	public void setNameParentFirm(String nameParentFirm) {
		this.nameParentFirm = nameParentFirm;
	}

	/**
	 * @return Returns the actors.
	 */
	public Collection<FirmActor> getActors() {
		return actors;
	}

	/**
	 * @param actors The actors to set.
	 */
	public void setActors(Collection<FirmActor> actors) {
		this.actors = actors;
	}
}
