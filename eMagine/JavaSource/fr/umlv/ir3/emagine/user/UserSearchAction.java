package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.user.profile.ProfileDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.SearchAction;

public class UserSearchAction extends SearchAction {

	/**
	 * The administrator wants to search all the users matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public ActionForward searchUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		UserSearchForm userSearchForm = (UserSearchForm)form;
		DAOManager manager = DAOManager.getInstance();

		// FIXME : pour les searchs et getAll, voir comment les mettre dans le UserManager (les mettre ?)
		
		// Retrieve all profiles and set them in the form
		ProfileDAO profileDAO = manager.getProfileDAO();
		try {
			userSearchForm.setProfiles(profileDAO.getProfiles());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

		// Retrieve the searched users, and set them in the page 
		UserDAO userDAO = manager.getUserDAO();
		try {
			List<User> users = userDAO.getUsers(userSearchForm);
			userSearchForm.setResults(users);
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
