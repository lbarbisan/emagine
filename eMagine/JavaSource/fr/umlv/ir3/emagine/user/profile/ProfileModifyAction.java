/**
 *
 */
package fr.umlv.ir3.emagine.user.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class ProfileModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of profile.
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
		ProfileModifyForm profileModifyForm = (ProfileModifyForm) form;
		
		try {
			// Retrieve the user we want to see (if he exists) 
			String idProfile = request.getParameter("id");			
			if(idProfile != null && !"".equals(idProfile)) {
				Profile profile = managerManager.getProfileManager().retrieve(Long.parseLong(idProfile));
				profileModifyForm.setIdUserToModify(idProfile);
				profileModifyForm.setFirstName(profile.getFirstName());
				profileModifyForm.setLastName(profile.getLastName());
				profileModifyForm.setLogin(profile.getLogin());
				profileModifyForm.setPassword(profile.getPassword());
				profileModifyForm.setRepassword(profile.getPassword());
				profileModifyForm.setEmail(profile.getEmail());
				profileModifyForm.setIdProfile(Long.toString(profile.getProfile().getId()));
			}
			
			// Retrieve all profiles and set them in the form
			profileModifyForm.setProfiles(managerManager.getProfileManager().findAll());

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
		ProfileModifyForm userModifyForm = (ProfileModifyForm) form;

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
			if("exceptions.mailManager.sendMail.messagingException".equals(exception.getMessageId()))
				errors.add("mail", new ActionMessage("user.create.error.mail"));
			else
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
