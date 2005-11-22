package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.umlv.ir3.emagine.util.DAOManager;

public class UserDeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		deleteUsers(((UserSearchForm)form).getResults(), request);
		return mapping.findForward("success"); // TODO : pageDestination
	}
	
	/**
	 * The administrator wants to delete all the selected users
	 * @param form the ActionForm containing the request parameters
	 * @param request the request
	 */
	public void deleteUsers(Collection<User> users, HttpServletRequest request) {
		// Retrieve the searched users, and delete them from database
		UserDAO userDAO = DAOManager.getUserDAO();
		DAOManager.beginTransaction();
		userDAO.deleteUsers(users);
		DAOManager.commitTransaction();
	}
}
