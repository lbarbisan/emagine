package fr.umlv.ir3.emagine.apprentice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class ApprenticeSearchAction extends SearchAction {

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
		ApprenticeSearchForm apprenticeSearchForm = (ApprenticeSearchForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			apprenticeSearchForm.reset();
			
			//Retrieve all years of formation and set them in the form
			apprenticeSearchForm.setYears((List<YearEnum>)emagineEnumManager.findAll(YearEnum.class));
			
			//Retrieve all courseOptions and set them in the form
			apprenticeSearchForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));

		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The user wants to search all the apprentices matching his request.
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
		ApprenticeSearchForm apprenticeSearchForm = (ApprenticeSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched apprentices, and set them in the page 
		try {
			apprenticeSearchForm.setResults(manager.getApprenticeManager().find(apprenticeSearchForm));
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The user wants to exclude several apprentice.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward exclude(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ApprenticeSearchForm apprenticeSearchForm = (ApprenticeSearchForm)form;
	
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);	
	}
}
