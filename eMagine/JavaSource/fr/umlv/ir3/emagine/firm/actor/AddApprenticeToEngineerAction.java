/**
 *
 */
package fr.umlv.ir3.emagine.firm.actor;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeSearchForm;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.FirmModifyForm;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class AddApprenticeToEngineer extends BaseAction {

	/**
	 * The administrator wants to add a pupills.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		FirmActorManager firmActorManager = ManagerManager.getInstance().getFirmActorManager();
		ApprenticeManager apprenticeManager = ManagerManager.getInstance().getApprenticeManager();
		
		// Delete the firms
		DAOManager.beginTransaction();
		String [] ids = request.getParameterValues("currentSelectedIds");
		FirmActorModifyForm actorForm = (FirmActorModifyForm) request.getSession().getAttribute("firmActorModifyForm"); 
		
		if(ids != null && ids.length > 0) {
			FirmActor actor = firmActorManager.retrieve(Long.parseLong(actorForm.getIdFirmActorToModify()));
			for (String id : ids) {
				try {
					actor.add(apprenticeManager.retrieve(Long.parseLong(id)));
				} catch (EMagineException exception) {
					addEMagineExceptionError(errors, exception);
				}
			}
			
			if(!firmActorsToRemove.isEmpty()) {
				firmManager.removeFirmActors(firm , firmActorsToRemove);
			}
			
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
