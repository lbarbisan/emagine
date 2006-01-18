package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class UserSearchAction extends SearchAction {

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
		UserSearchForm userSearchForm = (UserSearchForm)form;

		// Retrieve all profiles and set them in the form
		try {
			userSearchForm.reset();
			userSearchForm.setProfiles(ManagerManager.getInstance().getProfileManager().findAll());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	
	

	/**
	 * The administrator wants to delete all the selected users.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		UserSearchForm userSearchForm = (UserSearchForm)form;
		UserManager userManager = ManagerManager.getInstance().getUserManager();
		
		// Delete the users
		DAOManager.beginTransaction();
		for (String idUser : userSearchForm.getCurrentSelectedIds()) {
			try {
				User user = userManager.retrieve(Long.parseLong(idUser));
				userManager.delete(user, true);
			} catch (EMagineException exception) {
				exception.printStackTrace();
				addEMagineExceptionError(errors, exception);
			}
		}
		
		// Search again
		search(mapping, form, request, response);
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	
	/**
	 * The administrator wants to search all the users matching his or her request.
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
		UserSearchForm userSearchForm = (UserSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve the searched users, and set them in the page 
		try {
			userSearchForm.setResults(manager.getUserManager().find(userSearchForm));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
