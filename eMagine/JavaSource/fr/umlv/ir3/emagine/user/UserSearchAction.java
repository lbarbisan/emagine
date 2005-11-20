package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.Constants;
import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser;
import fr.umlv.ir3.emagine.dao.ProfileDAO;
import fr.umlv.ir3.emagine.dao.UserDAO;

public class UserSearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		searchUsers((IUserSearchForm)form, request);
		return mapping.findForward("success"); // TODO : pageDestination
	}
	
	/**
	 * The administrator wants to search all the users matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public void searchUsers(IUserSearchForm params, HttpServletRequest request) {
		DAOFactory currentDAOFactory = DAOFactoryChooser.getCurrentDAOFactory();

		// Retrieve all profiles and set them in the form
		ProfileDAO profileDAO = currentDAOFactory.getProfileDAO();
		params.setProfiles(profileDAO.getProfiles());

		// Retrieve the searched users, and set them in the page 
		UserDAO userDAO = currentDAOFactory.getUserDAO();
		Collection<User> users = userDAO.getUsers(params);
		request.setAttribute(Constants.USER_SEARCH_USERS, users);
	}
}
