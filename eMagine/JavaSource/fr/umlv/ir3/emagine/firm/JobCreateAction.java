package fr.umlv.ir3.emagine.firm;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class JobCreateAction extends BaseAction {

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
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		JobModifyForm jobModifyForm = (JobModifyForm) form;
		
		// Retrieve all profiles and set them in the form
		try {
			jobModifyForm.reset();
			jobModifyForm.setCourseOptions((List<CourseOptionEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(CourseOptionEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The administrator wants to create a firm.
	 * 
	 * @param mapping The ActionMapping used to select this instance
	 * @param form The optional ActionForm bean for this request (if any)
	 * @param request The HTTP request we are processing
	 * @param response The HTTP response we are creating
	 * @return an ActionForward instance describing where and how control should be forwarded, or null if the response has already been completed.
	 * @throws Exception if an exception occurs
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		JobModifyForm jobModifyForm = (JobModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		FirmManager firmManager = managerManager.getFirmManager();
		
		try {
			// Init job
			Job job = new Job();
			Firm firm = firmManager.retrieve(Long.parseLong(((FirmModifyForm) request.getSession().getAttribute("companyModifyForm")).getIdFirmToModify()));
			
			// Set values
			if(jobModifyForm.getIdCourseOption() != null && !"".equals(jobModifyForm.getIdCourseOption()))
					job.setCursus((CourseOptionEnum) managerManager.getEmagineEnumManager().retrieve(Long.parseLong(jobModifyForm.getIdCourseOption()), CourseOptionEnum.class));

			if(jobModifyForm.getNbPostes() != null && !"".equals(jobModifyForm.getNbPostes()))
					job.setNbPlace(jobModifyForm.getNbPostes() == null || "".equals(jobModifyForm.getNbPostes()) ? 0 : Integer.parseInt(jobModifyForm.getNbPostes()));

			job.setFirm(firm);
			
			// Create a firm
			firm.getJobs().add(job);
			firmManager.update(firm);
			
			errors.add("confirm", new ActionMessage("job.create.confirm"));
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
