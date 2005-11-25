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
import fr.umlv.ir3.emagine.util.EntityManager;

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
		user.setPassword(userModifyForm.getPassword());	// The password have been checked in the form .validate(...) method

		try {
			EntityManager.getInstance().getUserManager().createUser(user);
			// Retrieve the new id to the form
			userModifyForm.setId(user.getId());
			// TODO : createUser : Mail
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		ActionMessages errors = new ActionMessages();

		// Retrieve the User's properties values
		UserModifyForm userModifyForm = (UserModifyForm) form;
		User user = userDAO.retrieve(userModifyForm.getId());	// FIXME : pour récupérer un user, voir si on ne va pas plutôt passer le Form (ou une interface) dans la méthode UserManager.updateUser(...)
		user.setEmail(userModifyForm.getEmail());
		user.setFirstName(userModifyForm.getFirstName());
		user.setLastName(userModifyForm.getLastName());
		user.setLogin(userModifyForm.getLogin());
		user.setPassword(userModifyForm.getPassword());		// The password check have been done in the form .validate(...) method

		// Update the User
		try {
			EntityManager.getInstance().getUserManager().updateUser(user);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

}
