/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.absence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.firm.Job;
import fr.umlv.ir3.emagine.firm.JobManager;
import fr.umlv.ir3.emagine.firm.JobModifyForm;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class AbsenceModifyAction extends BaseAction {

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
		AbsenceModifyForm absenceModifyForm = (AbsenceModifyForm) form;
		
		try {
			// Retrieve the apprentice we want to see (if he exists) 
			String id = request.getParameter("id");			
			if(id != null && !"".equals(id)) {

				// Retrieve the  to modify
				Absence absence = managerManager.getAbsenceManager().retrieve(Long.parseLong(id));

				// Reset all form
				absenceModifyForm.reset();

				// Set infos
				absenceModifyForm.setIdAbsenceToModify(absence.getId().toString());
				
				if(absence.getStartDate() != null) {
					absenceModifyForm.setInitDate(dateToShow(absence.getStartDate()));		
				}
				if(absence.getEndDate() != null) {
					absenceModifyForm.setEndDate(dateToShow(absence.getEndDate()));		
				}
				if(absence.getJustification() != null)
					absenceModifyForm.setIdJustification(((Long)absence.getJustification().getId()).toString());

				if(absence.getComment() != null)
					absenceModifyForm.setComment(absence.getComment().toString());
			}
			absenceModifyForm.setJustifications((List<JustificationEnum>)managerManager.getEmagineEnumManager().findAll(JustificationEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The user wants to modify the informations of firm.
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
		AbsenceManager absenceManager = managerManager.getAbsenceManager();
		AbsenceModifyForm absenceModifyForm = (AbsenceModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();

		// Update the job
		try {
			Absence absence = absenceManager.retrieve(Long.parseLong(absenceModifyForm.getIdAbsenceToModify()));

			// Set values
			absence.setStartDate(stringToDate(absenceModifyForm.getInitDate()));
			absence.setEndDate(stringToDate(absenceModifyForm.getEndDate()));
			absence.setJustification((JustificationEnum) emagineEnumManager.retrieve(Long.parseLong(absenceModifyForm.getIdJustification()), JustificationEnum.class));
			absence.setComment(absenceModifyForm.getComment());
									
			absenceManager.update(absence);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	private Date stringToDate(String stringDate) {
		Date date = null;
		System.err.println(stringDate);
		if (stringDate != "") {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:ss:SSS");
			date = Calendar.getInstance().getTime();
			try {
				date = simpleDateFormat.parse(stringDate);
				System.err.println(date);
			} catch (ParseException e) {
			}
		}
		return date;
	}

	private String dateToShow(Date date) {
		System.out.println("date de date to show avant :"+date);
		String stringDate = "";
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
			stringDate = simpleDateFormat.format(date);
		}
		System.err.println("date de date to show apres :"+date);
		return stringDate;
	}
}
