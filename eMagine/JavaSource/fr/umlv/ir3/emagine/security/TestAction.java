package fr.umlv.ir3.emagine.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.Constants;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class TestAction extends BaseAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();

		// Retrieve all profiles and set them in the form
		try {
			User user = (User)request.getSession().getAttribute(Constants.LOGGED_IN_USER_KEY);
			System.out.println("TestAction. User loggué : "+user.getLogin()+" / "+user.getPassword());
		} catch (Exception exception) {
			addEMagineExceptionError(errors, new EMagineException("exception.unkown", exception));
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}

}
