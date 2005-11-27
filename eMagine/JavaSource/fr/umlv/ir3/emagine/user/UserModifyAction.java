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

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EntityManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class UserModifyAction extends BaseAction {

	public ActionForward createUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the User's properties values
		UserModifyForm userModifyForm = (UserModifyForm) form;
		User user = userModifyForm.getEntity();	// The password have been checked in the form .validate(...) method

		try {
			EntityManager.getInstance().getUserManager().createUser(user);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	public ActionForward updateUser(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ActionMessages errors = new ActionMessages();

		// Retrieve the User's properties values
		UserModifyForm userModifyForm = (UserModifyForm) form;
		User user = userModifyForm.getEntity();	// The password check have been done in the form .validate(...) method

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
