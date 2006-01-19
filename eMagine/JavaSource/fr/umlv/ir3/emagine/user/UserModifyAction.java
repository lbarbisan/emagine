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

import fr.umlv.ir3.emagine.user.profile.ProfileManager;
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
			if(idUser != null && !"".equals(idUser)) {
				User user = managerManager.getUserManager().retrieve(Long.parseLong(idUser));
				userModifyForm.setIdUserToModify(idUser);
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
		return viewFormIfNoErrors(mapping, request, errors);
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
	public ActionForward modify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		UserManager userManager = managerManager.getUserManager();
		ProfileManager profileManager = managerManager.getProfileManager();
		UserModifyForm userModifyForm = (UserModifyForm) form;

		// Update the User
		try {
			User user = userManager.retrieve(Long.parseLong(userModifyForm.getIdUserToModify()));
			user.setLastName(userModifyForm.getLastName());
			user.setFirstName(userModifyForm.getFirstName());
			user.setLogin(userModifyForm.getLogin());
			user.setPassword(userModifyForm.getPassword());
			user.setEmail(userModifyForm.getEmail());
			user.setProfile(profileManager.retrieve(Long.parseLong(userModifyForm.getIdProfile())));
			userManager.update(user);
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
