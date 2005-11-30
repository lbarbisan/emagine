package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class UserSearchAction extends SearchAction {

	/**
	 * The administrator wants to search all the users matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public ActionForward searchUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		UserSearchForm userSearchForm = (UserSearchForm)form;
		ManagerManager manager = ManagerManager.getInstance();

		// Retrieve all profiles and set them in the form
		try {
			userSearchForm.setProfiles(manager.getProfileManager().getProfiles());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

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
