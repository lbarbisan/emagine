/**
 *
 */
package fr.umlv.ir3.emagine.firm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class JobModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of job.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		JobModifyForm jobModifyForm = (JobModifyForm) form;
		
		try {
			// Retrieve the firm we want to see (if he exists) 
			String id = request.getParameter("id");			
			if(id != null && !"".equals(id)) {

				// Retrieve the job to modify
				Job job = managerManager.getJobManager().retrieve(Long.parseLong(id));

				// Reset all form
				jobModifyForm.reset();

				// Set infos
				jobModifyForm.setIdJobToModify(job.getId().toString());
				
				if(job.getCursus() != null)
					jobModifyForm.setIdCourseOption(job.getCursus().getId().toString());

				if(job.getNbPlace() != null)
					jobModifyForm.setNbPostes(job.getNbPlace().toString());
			}

			jobModifyForm.setCourseOptions((List<CourseOptionEnum>)managerManager.getEmagineEnumManager().findAll(CourseOptionEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of firm.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */	
	public ActionForward modify(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception  {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		JobManager jobManager = managerManager.getJobManager();
		JobModifyForm jobModifyForm = (JobModifyForm) form;

		// Update the job
		try {
			Job job = jobManager.retrieve(Long.parseLong(jobModifyForm.getIdJobToModify()));

			// Set values
			job.setCursus(jobModifyForm.getIdCourseOption() == null || "".equals(jobModifyForm.getIdCourseOption()) ? null :  (CourseOptionEnum) managerManager.getEmagineEnumManager().retrieve(Long.parseLong(jobModifyForm.getIdCourseOption()), CourseOptionEnum.class));
			job.setNbPlace(jobModifyForm.getNbPostes() == null || "".equals(jobModifyForm.getNbPostes()) ? 0 : Integer.parseInt(jobModifyForm.getNbPostes()));
						
			jobManager.update(job);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
