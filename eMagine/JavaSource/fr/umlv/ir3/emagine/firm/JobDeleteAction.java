/**
 *
 */
package fr.umlv.ir3.emagine.firm;

import java.util.LinkedList;
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

public class JobDeleteAction extends BaseAction {

	/**
	 * The administrator wants to delete all several jobs.
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
		FirmManager firmManager = ManagerManager.getInstance().getFirmManager();
		JobManager jobManager = ManagerManager.getInstance().getJobManager();
		
		// Delete the firms
		DAOManager.beginTransaction();
		String [] ids = request.getParameterValues("currentSelectedIds");

		
		if(ids != null && ids.length > 0) {
			List <Job> jobsToRemove = new LinkedList <Job> ();
			Firm firm = firmManager.retrieve(
					Long.parseLong(
							((FirmModifyForm)request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify()));
			
			for (String id : ids) {
				try {
					jobsToRemove.add(jobManager.retrieve(Long.parseLong(id)));
				} catch (EMagineException exception) {
					exception.printStackTrace();
					addEMagineExceptionError(errors, exception);
				}
			}
			
			if(!jobsToRemove.isEmpty()) {
				firm.getJobs().removeAll(jobsToRemove);
				firmManager.update(firm);
			}
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
