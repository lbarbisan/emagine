package fr.umlv.ir3.emagine.firm;

import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class FirmSearchForm extends SelectSearchForm<Firm> implements FirmSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String name;

	//@IsASearchParam
	private String idDepartment;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;

	/** List of all department **/
	private Collection <DepartmentEnum> departments;
	
	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		name = "";
		deletionForced = false;
		idDepartment = "";
		departments = null;
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
	@IsASearchParam(value = "firm.address.department.id",type = Long.class)
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
	 * @return Returns the name.
	 */
	@IsASearchParam("firm.name")
	public String getName() {
		return name;
	}


	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
