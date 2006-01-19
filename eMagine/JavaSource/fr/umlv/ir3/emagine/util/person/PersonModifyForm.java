package fr.umlv.ir3.emagine.util.person;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.modification.EditableForm;

public abstract class PersonModifyForm<ObjectType extends Person> extends EditableForm<Person> {
	private static final long serialVersionUID = 2014238102681432978L;

	private ObjectType entity; // = new Person();
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO ProfileModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	@Override
	public ObjectType getEntity() {
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
