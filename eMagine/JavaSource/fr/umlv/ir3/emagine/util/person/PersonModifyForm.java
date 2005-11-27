package fr.umlv.ir3.emagine.util.person;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.base.BaseModifyForm;

public class PersonModifyForm extends BaseModifyForm {
	private static final long serialVersionUID = 2014238102681432978L;

	private Person entity = new Person();
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	@Override
	public Person getEntity() {
		return entity;
	}
	
	public String getEmail() {
		return entity.getEmail();
	}
	public void setEmail(String email) {
		entity.setEmail(email);
	}
	public String getFirstName() {
		return entity.getFirstName();
	}
	public void setFirstName(String firstName) {
		entity.setFirstName(firstName);
	}
	public Long getId() {
		return entity.getId();
	}
	public String getLastName() {
		return entity.getLastName();
	}
	public void setLastName(String lastName) {
		entity.setLastName(lastName);
	}
}
