package fr.umlv.ir3.emagine.util.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Constants;
import fr.umlv.ir3.emagine.util.EMagineException;

public class BaseAction extends DispatchAction {

	// ----------------------------------------------------- Instance Variables

	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory.getLog(Constants.PACKAGE);
	
    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     * It saves also the current user in the SessionManager
     *
     * @param mapping The ActionMapping used to select this instance
     * @param form The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if an exception occurs
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		User currentUser = (User)request.getSession().getAttribute(Constants.LOGGED_IN_USER_KEY);
		if (currentUser != null) {
			SessionManager.getInstance().setCurrentUser(currentUser);
		}
		return super.execute(mapping, form, request, response);
	}

	// ------------------------------------------------------ Protected Methods

	/**
	 * Return the local or global forward named "failure"
	 * or null if there is no such forward.
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "failure" or null if there is no such mapping.
	 */
	protected ActionForward findFailure(ActionMapping mapping) {
		return (mapping.findForward(Constants.FAILURE));
	}

	/**
	 * Return the mapping labeled "success"
	 * or null if there is no such mapping.
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "success" or null if there is no such mapping.
	 */
	protected ActionForward findSuccess(ActionMapping mapping) {
		return (mapping.findForward(Constants.SUCCESS));
	}
	

	protected void addEMagineExceptionError(ActionMessages errors, EMagineException exception) {
		errors.add(
                ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage(exception.getMessageId()));
	}
	
	protected ActionForward successIfNoErrors(ActionMapping mapping, HttpServletRequest request, ActionMessages errors) {
        if (!errors.isEmpty()) {
            this.saveErrors(request, errors);
            return (mapping.getInputForward());
        }
		return findSuccess(mapping);
	}
	
	/**
	 * Extracts the selected list, with selected columns (fields) into the selected file format
	 */
	//FIXME:Faire les extractions pour chaque Form
	/*public Extractable extract(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		// Retrieve the extraction's properties values
		ExtractionForm extractionForm = (ExtractionForm)form;

		try {
			response.setContentType(extractionForm.getExtractionType().mimeType());
			ManagerManager.getInstance().getExtractionManager().extract(extractionForm, response.getOutputStream());
		} catch (EMagineException exception) {
			// save the error
			addEMagineExceptionError(errors, exception);
		}
		
        if (!errors.isEmpty()) {
            this.saveErrors(request, errors);
            return (mapping.getInputForward());
        }
        return null;
	}*/	


}
