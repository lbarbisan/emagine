package fr.umlv.ir3.emagine.user.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchAction;

public class ProfileListAction extends SearchAction {

	/**
	 * The administrator wants to show the search form.
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
		ProfileListForm profileListForm = (ProfileListForm)form;

		// Retrieve all profiles and set them in the form
		try {
			profileListForm.setProfiles(ManagerManager.getInstance().getProfileManager().findAll());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
		System.out.println("ok ici");

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
