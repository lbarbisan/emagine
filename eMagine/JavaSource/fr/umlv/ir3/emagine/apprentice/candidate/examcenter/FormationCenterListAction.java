package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class FormationCenterListAction extends SearchAction {

	/**
	 * The administrator wants to list all profiles.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		FormationCenterListForm formationCenterListForm = (FormationCenterListForm)form;
		try {
			formationCenterListForm.setResults(ManagerManager.getInstance().getFormationCenterManager().findAll());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
