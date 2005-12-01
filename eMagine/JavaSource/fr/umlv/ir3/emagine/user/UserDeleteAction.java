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
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class UserDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all the selected users
	 * @param form the ActionForm containing the request parameters
	 * @param request the request
	 */
	public ActionForward deleteUsers(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the collection of users to delete
		UserSearchForm userSearchForm = (UserSearchForm) form;
		User user = userSearchForm.getSelectedUser();
		boolean deletionForced = userSearchForm.isDeletionForced();

		// Delete the users
		DAOManager.beginTransaction();
		try {
			ManagerManager.getInstance().getUserManager().delete(user, deletionForced);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
