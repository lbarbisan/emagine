/**
 *
 */
package fr.umlv.ir3.emagine.user.profile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class ProfileDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all several profiles.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ProfileManager profileManager = ManagerManager.getInstance().getProfileManager();
		
		// Delete the users
		DAOManager.beginTransaction();
		String [] ids = request.getParameterValues("currentSelectedIds");
		
		if(ids != null && ids.length > 0) {
			for (String idProfile : ids) {
				try {
					Profile profile = profileManager.retrieve(Long.parseLong(idProfile));
					profileManager.delete(profile); // TODO A faire la redirection + controle d'administrateur existe encore
				} catch (EMagineException exception) {
					addEMagineExceptionError(errors, exception);
				}
			}
		}
		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}	
}
