package fr.umlv.ir3.emagine.teachertutor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TeacherTutorModifyForm extends ActionForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6326596143394397304L;
	
	//FIXME: Manque le "titre" par rapport au CDCF
	private TeacherTutor entity = new TeacherTutor();
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	public TeacherTutor getEntity() {
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
