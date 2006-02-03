package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.Collection;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;


/**
 * Form for Formation Center
 * @author mmancel
 *
 */
public class FormationCenterModifyForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	private String name;
	private String street;
	private String postalCode;
	private String city;
	private String phone;
	private Collection <Room> room;
	private String action;
	private String idFormationCenterToModify;
	private String idDepartment;
	private Collection <DepartmentEnum> departments;
	protected Set<String> selectedIds;
	protected String currentSelectedIds[];
	

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if("create".equals(action) || "show".equals(action) ) {
			if("".equals(name) || "".equals(idDepartment) || "".equals(street))
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
		street = "";
		postalCode = "";
		city = "";
		departments = null;
		idDepartment = "";
		idFormationCenterToModify = "";
		name = "";
		room = null;
		phone = "";
		currentSelectedIds = new String[0];
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
	public String getPhone() {
		return phone;
	}

	/**
	 * @param telephone The telephone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return Returns the address.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param address The address to set.
	 */
	public void setStreet(String address) {
		this.street = address;
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
	 * @return Returns the currentSelectedIds.
	 */
	public String[] getCurrentSelectedIds() {
		return currentSelectedIds;
	}

	/**
	 * @param currentSelectedIds The currentSelectedIds to set.
	 */
	public void setCurrentSelectedIds(String[] currentSelectedIds) {
		this.currentSelectedIds = currentSelectedIds;
	}

	/**
	 * @return Returns the selectedIds.
	 */
	public Set<String> getSelectedIds() {
		return selectedIds;
	}

	/**
	 * @param selectedIds The selectedIds to set.
	 */
	public void setSelectedIds(Set<String> selectedIds) {
		this.selectedIds = selectedIds;
	}
}

	
