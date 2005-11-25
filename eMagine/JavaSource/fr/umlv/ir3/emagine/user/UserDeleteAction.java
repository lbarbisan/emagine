package fr.umlv.ir3.emagine.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.BaseAction;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class UserDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all the selected users
	 * @param form the ActionForm containing the request parameters
	 * @param request the request
	 */
	public ActionForward deleteUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		
		// Retrieve the collection of users to delete
		UserSearchForm userSearchForm = (UserSearchForm) form;
		List<User> users = userSearchForm.getResults();

		// Delete the users
		DAOManager.beginTransaction();
		try {
			userDAO.deleteUsers(users);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
			// and rollback the transaction
			DAOManager.rollBackTransaction();
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
