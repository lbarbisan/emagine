package fr.umlv.ir3.emagine.util.base;

import java.io.PrintWriter;
import java.io.StringWriter;

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

import fr.umlv.ir3.emagine.security.HttpServletRequestAdapter;
import fr.umlv.ir3.emagine.security.SecurityFilterNotCorrectlyInitializedException;
import fr.umlv.ir3.emagine.security.SessionManager;
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
	 * @throws SecurityFilterNotCorrectlyInitializedException if the current Principal is not an EmaginePrincipal (the realm used is not correct)
     */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		SessionManager.getInstance().initThreadLocal(new HttpServletRequestAdapter(request));
		
		// Check if the action parameter is present, if not, redirect to the main page
		if (mapping.getParameter() != null && request.getParameter("action") == null) {
			log.info("No action parameter, redirecting to /");
			return new ActionForward("/", true);
		}
		
		return super.execute(mapping, form, request, response);
	}

	// ------------------------------------------------------ Protected Methods

	protected void addEMagineExceptionError(ActionMessages errors, EMagineException exception) {
		errors.add(
                ActionMessages.GLOBAL_MESSAGE,
                new ActionMessage(exception.getMessageId(), exception.getParams()));

		StringWriter writer = new StringWriter();
		exception.printStackTrace(new PrintWriter(writer));
		log.error(writer.getBuffer().toString());
	}

	
	/**
	 * Return the local or global forward named "failure" or null if there is no such forward.
	 * 
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "failure" or null if there is no such mapping.
	 */
	protected ActionForward successIfNoErrors(ActionMapping mapping, HttpServletRequest request, ActionMessages errors) {
		return forward(mapping, request, errors, Constants.SUCCESS, Constants.FAILURE);
	}
	
	/**
	 * Return the local or global forward named "failure" or null if there is no such forward.
	 * 
	 * @param mapping Our ActionMapping
	 * @return Return the mapping named "failure" or null if there is no such mapping.
	 */
	protected ActionForward viewFormIfNoErrors(ActionMapping mapping, HttpServletRequest request, ActionMessages errors) {
		return forward(mapping, request, errors, Constants.VIEW_FORM, Constants.FAILURE);
	}
	
	protected ActionForward findSuccess(ActionMapping mapping) {
		return mapping.findForward(Constants.SUCCESS);
	}

	protected ActionForward forward(ActionMapping mapping, HttpServletRequest request, ActionMessages errors, String successTarget, String failureTarget) {
		// Save errors if they exist
		if(!errors.isEmpty())
			this.saveErrors(request, errors);
		
		// All targets
		ActionForward actionForward = mapping.findForward(Constants.ALL_TARGETS);

		// Specificied target
		if (actionForward == null) {
			String from = request.getParameter(Constants.FROM);
			from = (from != null && !"".equals(from) ? "_from_" + from : "");
			actionForward = mapping.findForward((errors.isEmpty() ? successTarget : failureTarget) + from);
		}

		// Default target
		if (actionForward == null)
			actionForward = mapping.findForward(Constants.DEFAULT_TARGET);		
		
		log.info("Forward action '"+getClass().getName()+"' -> '" + (actionForward != null ? actionForward.getName() : null) + "'");
		
		return actionForward;
	}
}
