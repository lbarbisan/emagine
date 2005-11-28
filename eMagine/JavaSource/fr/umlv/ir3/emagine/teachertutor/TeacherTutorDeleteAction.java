package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class TeacherTutorDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all the selected teacher tutor
	 * @param form the ActionForm containing the request parameters
	 * @param request the request
	 */
	public ActionForward deleteTeachersTutor(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the collection of teacher tutor to delete
		TeacherTutorSearchForm userSearchForm = (TeacherTutorSearchForm) form;
		List<TeacherTutor> teachersTutor = userSearchForm.getResults();

		// Delete the teacher tutor
		DAOManager.beginTransaction();
		try {
			ManagerManager.getInstance().getTeacherTutorManager().deleteTeacherTutor(teachersTutor);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
