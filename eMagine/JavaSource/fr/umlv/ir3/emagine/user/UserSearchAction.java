package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.core.user.User;
import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser;
import fr.umlv.ir3.emagine.dao.ProfileDAO;
import fr.umlv.ir3.emagine.dao.UserDAO;
import fr.umlv.ir3.emagine.util.core.SearchAction;

public class UserSearchAction extends SearchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		searchUsers((UserSearchForm)form, request);
		return mapping.findForward("success"); // TODO : pageDestination
	}

	/**
	 * The administrator wants to search all the users matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public void searchUsers(UserSearchForm form, HttpServletRequest request) {
		DAOFactory currentDAOFactory = DAOFactoryChooser.getCurrentDAOFactory();

		// Retrieve all profiles and set them in the form
		ProfileDAO profileDAO = currentDAOFactory.getProfileDAO();
		form.setProfiles(profileDAO.getProfiles());

		// Retrieve the searched users, and set them in the page 
		UserDAO userDAO = currentDAOFactory.getUserDAO();
		List<User> users = userDAO.getUsers(form);
		form.setResults(users);
	}
}
