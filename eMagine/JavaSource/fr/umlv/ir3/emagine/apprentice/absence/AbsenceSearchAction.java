package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.firm.FirmSearchForm;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class AbsenceSearchAction extends SearchAction {

	/**
	 * The user wants to show the search form.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		AbsenceSearchForm absenceSearchForm = (AbsenceSearchForm)form;

		// Retrieve all justifications and set them in the form
		try {
			absenceSearchForm.reset();
			absenceSearchForm.setJustifications((List<JustificationEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(JustificationEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The user wants to search all the absence matching his or her request.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		AbsenceSearchForm absenceSearchForm = (AbsenceSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched users, and set them in the page 
		try {
			absenceSearchForm.setResults(manager.getAbsenceManager().find(absenceSearchForm));
			absenceSearchForm.setJustifications((List<JustificationEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(JustificationEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
