package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import fr.umlv.ir3.emagine.Constants;
import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.DAOFactoryChooser;
import fr.umlv.ir3.emagine.dao.ProfileDAO;
import fr.umlv.ir3.emagine.dao.UserDAO;
import fr.umlv.ir3.emagine.util.CollectionScroller;

public class UserSearchAction extends DispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		searchUsers((UserSearchForm)form, request);
		return mapping.findForward("pageDestination"); // TODO : pageDestination
	}
	
	public void searchUsers(UserSearchForm form, HttpServletRequest request) {
		DAOFactory currentDAOFactory = DAOFactoryChooser.getCurrentDAOFactory();

		// Retrieve all profiles and set them in the form
		ProfileDAO profileDAO = currentDAOFactory.getProfileDAO();
		form.setProfiles(profileDAO.getProfiles());

		// Retrieve the searched users, and set them in the page 
		UserDAO userDAO = currentDAOFactory.getUserDAO();
		Collection<User> users = userDAO.getUsers(form);
		request.setAttribute(Constants.USER_SEARCH_USERS, new CollectionScroller<User>(users));
	}
}
