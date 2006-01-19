package fr.umlv.ir3.emagine.teachertutor;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;


/**
 * Form for Teacher
 * @author mmancel
 *
 */
public class TeacherTutorModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	/** Teacher firstname **/
	private String firstName;

	/** Teacher lastName **/
	private String lastName;
	
	/** Teacher address **/
	private String address;

	/** Teacher postalCode **/
	private String postalCode;

	/** Teacher city **/
	private String  city;

	/** Teacher idDepartment **/
	private String idDepartment;
	
	/** Teacher pupils list **/
	private Collection <DepartmentEnum> departments;

	/** Teacher pupils list **/
	private Collection <Apprentice> pupils;
	
	/** Teacher DispacthAction **/
	private String action;

	/** Teacher phone **/
	private String phone;

	/** Teacher cellular **/
	private String cellular;

	/** Teacher fax **/
	private String fax;

	/** Teacher mail **/
	private String mail;
	
	/** Teacher identifier to modify **/
	private String idTeacherTutorToModify;
	

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if("create".equals(action) || "show".equals(action) ) {
			if("".equals(firstName) || "".equals(lastName) || "".equals(address) || "".equals(postalCode) || "".equals(city) || "".equals(mail))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("teacherTutor.error.allRequiredFieldIsNotfillin"));
		}			
		return errors;
	}
	
	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		firstName = "";
		lastName = "";
		address = "";
		city= "";
		idDepartment = "";
		departments = null;
		postalCode= "";
		pupils = null;
		phone = "";
		cellular = "";
		fax = "";
		mail = "";
		idTeacherTutorToModify = "";
		action = "";
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
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return Returns the pupils.
	 */
	public Collection<Apprentice> getPupils() {
		return pupils;
	}

	/**
	 * @param pupils The pupils to set.
	 */
	public void setPupils(Collection<Apprentice> pupils) {
		this.pupils = pupils;
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
	 * @return Returns the cellular.
	 */
	public String getCellular() {
		return cellular;
	}

	/**
	 * @param cellular The cellular to set.
	 */
	public void setCellular(String cellular) {
		this.cellular = cellular;
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
	 * @return Returns the idTeacherTutorToModify.
	 */
	public String getIdTeacherTutorToModify() {
		return idTeacherTutorToModify;
	}

	/**
	 * @param idTeacherTutorToModify The idTeacherTutorToModify to set.
	 */
	public void setIdTeacherTutorToModify(String idTeacherTutorToModify) {
		this.idTeacherTutorToModify = idTeacherTutorToModify;
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
}

	
