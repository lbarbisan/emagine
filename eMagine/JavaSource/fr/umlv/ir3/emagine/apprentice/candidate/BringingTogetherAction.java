package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.firm.RapprochementSearchParams;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.ParameterInfo;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class BringingTogetherAction extends SearchAction {

	/**
	 * The user wants to show the bringing together form.
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
		BringingTogetherForm bringingTogetherForm = (BringingTogetherForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			bringingTogetherForm.reset();
			
			//Retrieve all courseOptions and set them in the form
			bringingTogetherForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));

		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The user wants to bringing together the candidates matching his or her request.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward bringingTogether(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		BringingTogetherForm bringingTogetherForm = (BringingTogetherForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched candidate, and set them in the page
		/*
		try {
			//TODO faire la fonction de rapprochement !!
			bringingTogetherForm.setResults(manager.getFirmManager().find(bringingTogetherForm));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		*/
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
