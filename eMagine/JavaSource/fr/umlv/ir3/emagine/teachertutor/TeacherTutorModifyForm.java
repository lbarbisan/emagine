package fr.umlv.ir3.emagine.teachertutor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.person.PersonModifyForm;

public class TeacherTutorModifyForm extends PersonModifyForm  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6326596143394397304L;
	
	private TeacherTutor entity = new TeacherTutor();
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO UserModifyForm.validate()
		return super.validate(mapping, request);
	}
	
	@Override
	public TeacherTutor getEntity() {
		return entity;
	}
}
