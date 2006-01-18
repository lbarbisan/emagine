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
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class UserModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		UserModifyForm userModifyForm = (UserModifyForm) form;
		
		try {
			// Retrieve the user we want to see (if he exists) 
			String idUser = request.getParameter("id");			
			if(idUser != null && !idUser.equalsIgnoreCase("")) {
				User user = managerManager.getUserManager().retrieve(Long.parseLong(idUser));
				userModifyForm.setUser(user);
				userModifyForm.setFirstName(user.getFirstName());
				userModifyForm.setLastName(user.getLastName());
				userModifyForm.setLogin(user.getLogin());
				userModifyForm.setPassword(user.getPassword());
				userModifyForm.setRepassword(user.getPassword());
				userModifyForm.setEmail(user.getEmail());
				userModifyForm.setIdProfile(Long.toString(user.getProfile().getId()));
			}
			
			// Retrieve all profiles and set them in the form
			userModifyForm.setProfiles(managerManager.getProfileManager().findAll());

		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	
	/**
	 * The administrator wants to modify the informations of user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */	
	public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();

		// Retrieve the User's properties values
		UserModifyForm2 userModifyForm = (UserModifyForm2) form;
		User user = userModifyForm.getEntity();	// The password check have been done in the form .validate(...) method

		// Update the User
		try {
			ManagerManager.getInstance().getUserManager().update(user);
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

	
	/**
	 * The administrator wants to delete this user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();
		UserModifyForm userModifyForm = (UserModifyForm) form;
		
		try {
			ManagerManager.getInstance().getUserManager().delete(userModifyForm.getUser());
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
