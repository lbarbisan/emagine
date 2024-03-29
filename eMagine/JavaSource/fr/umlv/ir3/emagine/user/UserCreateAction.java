package fr.umlv.ir3.emagine.user;

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

public class UserCreateAction extends BaseAction {

	/**
	 * The administrator wants to show a new create form.
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
		UserModifyForm userModifyForm = (UserModifyForm) form;
		
		// Retrieve all profiles and set them in the form
		try {
			userModifyForm.reset();
			userModifyForm.setProfiles(ManagerManager.getInstance().getProfileManager().findAll());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The administrator wants to create an user.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		UserModifyForm userModifyForm = (UserModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		UserManager userManager = managerManager.getUserManager();
		ProfileManager profilManager = managerManager.getProfileManager();
		
		try {
			// Init user
			User user = new User();
			user.setFirstName(userModifyForm.getFirstName());
			user.setLastName(userModifyForm.getLastName());
			user.setLogin(userModifyForm.getLogin());
			user.setPassword(userModifyForm.getPassword());
			user.setEmail(userModifyForm.getEmail());
			user.setProfile(profilManager.retrieve(Long.parseLong(userModifyForm.getIdProfile())));

			// Create an user
			userManager.create(user);

			errors.add("confirm", new ActionMessage("user.create.confirm")); // TODO A revoir
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
