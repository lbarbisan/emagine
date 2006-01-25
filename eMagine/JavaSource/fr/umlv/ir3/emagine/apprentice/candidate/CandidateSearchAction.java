package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class CandidateSearchAction extends SearchAction {

	/**
	 * The administrator wants to show the search form.
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
		CandidateSearchForm candidateSearchForm = (CandidateSearchForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			candidateSearchForm.reset();
			
			//Retrieve all centers of formation and set them in the form
			candidateSearchForm.setCenters(ManagerManager.getInstance().getFormationCenterManager().findAll());
			
			//Retrieve all courseOptions and set them in the form
			candidateSearchForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));

		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The administrator wants to search all the candidates matching his or her request.
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
		CandidateSearchForm candidateSearchForm = (CandidateSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched candidate, and set them in the page 
		try {
			candidateSearchForm.setResults(manager.getCandidateManager().find(candidateSearchForm));
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
