package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;

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

public class ProfileCreateAction extends BaseAction {

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
		ProfileModifyForm profileModifyForm = (ProfileModifyForm) form;
		
		profileModifyForm.reset();
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The administrator wants to create a profile.
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
		ManagerManager managerManager = ManagerManager.getInstance();
		ProfileManager profileManager = managerManager.getProfileManager();
		RightManager rightManager = managerManager.getRightManager();
		ProfileModifyForm profileModifyForm = (ProfileModifyForm) form;

		// Update the Profile
		try {
			Profile profile = new Profile();
			profile.setName(profileModifyForm.getName());
			profile.setDescription(profileModifyForm.getDescription());
			
			profile.setRights(new ArrayList<Right>());
			for (String idRight : profileModifyForm.getRightIds()) {
				try {
					profile.addRights(rightManager.retrieve(Long.parseLong(idRight)));
				}
				catch(EMagineException exception) {
					addEMagineExceptionError(errors, exception);
				}
			}
			
			// Create a profile
			profileManager.create(profile);

			errors.add("confirm", new ActionMessage("profile.create.confirm")); // TODO A revoir
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
