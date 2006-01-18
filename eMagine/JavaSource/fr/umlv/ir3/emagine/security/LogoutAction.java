package fr.umlv.ir3.emagine.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class LogoutAction extends BaseAction {
	public ActionForward logout(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		
		try {
			SessionManager.getInstance().killCurrentSession();
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);
		}
		
		return successIfNoErrors(mapping, request, errors);
	}
}
