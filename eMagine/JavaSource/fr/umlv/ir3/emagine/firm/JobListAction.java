package fr.umlv.ir3.emagine.firm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class JobListAction extends BaseAction {

	/**
	 * The administrator wants to show a new create form.
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
		JobListForm jobListForm = (JobListForm) form;
		
		// Retrieve all profiles and set them in the form
		try {
			jobListForm.reset();
			jobListForm.setResults(
					ManagerManager.getInstance().getFirmManager().retrieve(
							Long.parseLong(((FirmModifyForm)request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify())).getJobs());
		
		System.out.println(ManagerManager.getInstance().getFirmManager().retrieve(Long.parseLong(((FirmModifyForm)request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify())).getJobs().size());
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
}
