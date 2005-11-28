/**
 *
 */
package fr.umlv.ir3.emagine.teachertutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class TeacherTutorModifyAction extends BaseAction {

	public ActionForward createUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the teacher tutor's properties values
		TeacherTutorModifyForm teacherTutorModifyForm = (TeacherTutorModifyForm) form;
		TeacherTutor teacherTutor = teacherTutorModifyForm.getEntity();

		try {
			ManagerManager.getInstance().getTeacherTutorManager().createTeacherTutor(teacherTutor);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ActionMessages errors = new ActionMessages();

		// Retrieve the teacher tutor's properties values
		TeacherTutorModifyForm teacherTutorModifyForm = (TeacherTutorModifyForm) form;
		TeacherTutor teacherTutor = teacherTutorModifyForm.getEntity();

		// Update the User
		try {
			ManagerManager.getInstance().getTeacherTutorManager().updateTeacherTutor(teacherTutor);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

}
