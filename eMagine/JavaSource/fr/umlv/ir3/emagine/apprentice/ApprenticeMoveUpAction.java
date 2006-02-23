/**
 *
 */
package fr.umlv.ir3.emagine.apprentice;

import java.util.List;

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

public class ApprenticeMoveUpAction extends BaseAction {

	/**
	 * The user wants to pass a apprentice(s) in an upper year.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward moveUp(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ApprenticeManager apprenticeManager = ManagerManager.getInstance().getApprenticeManager();
		ApprenticeSearchForm apprenticeSearchForm = (ApprenticeSearchForm) form;
		
		// move up the apprentices
		DAOManager.beginTransaction();

		try {
			List <Apprentice> apprentices = apprenticeManager.find(apprenticeSearchForm);
			apprenticeManager.moveUpApprentice(apprentices);
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}		
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}	
}
