package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Address;


/**
 * Form for Formation Center
 * @author mmancel
 *
 */
public class FormationCenterModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	private String name;
	private Address address;
	private String telephone;
	private Collection <Room> room;
	private String action;
	private String idFormationCenterToModify;
	private String idDepartment;
	private Collection <DepartmentEnum> departments;
	

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if("create".equals(action) || "show".equals(action) ) {
			if("".equals(name) || "".equals(idDepartment) || "".equals(address))
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
		}			
		return errors;
	}
	
	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		idDepartment = "";
		action = "";
		address = new Address();
		departments = null;
		idDepartment = "";
		idFormationCenterToModify = "";
		name = "";
		room = null;
		telephone = "";
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
	 * @return Returns the idFormationCenterToModify.
	 */
	public String getIdFormationCenterToModify() {
		return idFormationCenterToModify;
	}

	/**
	 * @param idFormationCenterToModify The idFormationCenterToModify to set.
	 */
	public void setIdFormationCenterToModify(String idFormationCenterToModify) {
		this.idFormationCenterToModify = idFormationCenterToModify;
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
	 * @return Returns the room.
	 */
	public Collection<Room> getRoom() {
		return room;
	}

	/**
	 * @param room The room to set.
	 */
	public void setRoom(Collection<Room> room) {
		this.room = room;
	}

	/**
	 * @return Returns the telephone.
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone The telephone to set.
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress(){
		return address.getStreet();
	}
	
	public void setAddress(String street){
		address.setStreet(street);
	}
	
	public String getPostalCode(){
		return address.getPostalCode();
	}
	
	public void setPostalCode(String postalCode){
		address.setPostalCode(postalCode);
	}
	
	public String getCity(){
		return address.getCity();
	}
	
	public void setCity(String city){
		address.setCity(city);
	}
}

	
