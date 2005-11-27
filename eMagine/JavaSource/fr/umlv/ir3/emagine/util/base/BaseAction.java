package fr.umlv.ir3.emagine.util.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import fr.umlv.ir3.emagine.util.Constants;
import fr.umlv.ir3.emagine.util.EMagineException;

public class BaseAction extends DispatchAction {

	// ----------------------------------------------------- Instance Variables

	/**
	 * The <code>Log</code> instance for this application.
	 */
	protected Log log = LogFactory.getLog(Constants.PACKAGE);

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


}
