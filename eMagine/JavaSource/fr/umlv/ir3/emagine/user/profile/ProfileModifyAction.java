/**
 *
 */
package fr.umlv.ir3.emagine.user.profile;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

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
		ProfileModifyForm profileModifyForm = (ProfileModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		ProfileManager profileManager = managerManager.getProfileManager();
		
		try {
			// Retrieve the profile we want to see (if he exists) 
			String idProfile = request.getParameter("id");			
			if(idProfile != null && !"".equals(idProfile)) {
				List <String> rightsIdList = new LinkedList <String> ();
				Profile profile = profileManager.retrieve(Long.parseLong(idProfile));

				List <Right> rights = profile.getRights();
				if(!rights.isEmpty())
					for (Right right : rights)
						rightsIdList.add(Long.toString(right.getId()));

				profileModifyForm.setName(profile.getName());
				profileModifyForm.setDescription(profile.getDescription());
				profileModifyForm.setRightIds(rightsIdList.toArray(new String [0]));
				profileModifyForm.setIdProfileToModify(idProfile);
			}
			
			// Retrieve all profiles and set them in the form
			profileModifyForm.setRights(managerManager.getRightManager().findAll());

		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of profile.
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
		ProfileManager profileManager = managerManager.getProfileManager();
		RightManager rightManager = managerManager.getRightManager();
		ProfileModifyForm profileModifyForm = (ProfileModifyForm) form;

		// Update the Profile
		try {
			Profile profile = profileManager.retrieve(Long.parseLong(profileModifyForm.getIdProfileToModify()));
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
			
			profileManager.update(profile);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
