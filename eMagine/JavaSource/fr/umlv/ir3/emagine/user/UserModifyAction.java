/**
 *
 */
package fr.umlv.ir3.emagine.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.BaseAction;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class UserModifyAction extends BaseAction {

	public ActionForward createUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the User's properties values
		UserModifyForm userModifyForm = (UserModifyForm) form;
		User user = new User();
		user.setEmail(userModifyForm.getEmail());
		user.setFirstName(userModifyForm.getFirstName());
		user.setLastName(userModifyForm.getLastName());
		user.setLogin(userModifyForm.getLogin());
		user.setPassword(userModifyForm.getPassword());	// The password check have been done in the form .validate(...) method

		// Create the new User
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();

		DAOManager.beginTransaction();
		try {
			userDAO.create(user);
			DAOManager.commitTransaction();

			// Retrieve the new id to the form
			userModifyForm.setId(user.getId());
			
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
			// and rollback the transaction
			DAOManager.rollBackTransaction();
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	public ActionForward modifyUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ActionMessages errors = new ActionMessages();
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		
		// Retrieve the User's properties values
		UserModifyForm userModifyForm = (UserModifyForm) form;
		User user = userDAO.retrieve(userModifyForm.getId());
		user.setEmail(userModifyForm.getEmail());
		user.setFirstName(userModifyForm.getFirstName());
		user.setLastName(userModifyForm.getLastName());
		user.setLogin(userModifyForm.getLogin());
		user.setPassword(userModifyForm.getPassword());		// The password check have been done in the form .validate(...) method

		// Update the User
		DAOManager.beginTransaction();
		try {
			userDAO.update(user);
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
