package fr.umlv.ir3.emagine.teachertutor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class TeacherTutorSearchAction extends SearchAction {

	/**
	 * The user wants to search all the teacher tutor matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public ActionForward searchTeacherTutor(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		TeacherTutorSearchForm teacherTutorSearchForm = (TeacherTutorSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched teacher tutor, and set them in the page 
		try {
			teacherTutorSearchForm.setResults(manager.getTeacherTutorManager().getTeachersTutor(teacherTutorSearchForm));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
