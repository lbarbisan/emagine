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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeModifyForm;
import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.DateOperations;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class AbsenceCreateAction extends BaseAction {

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
		AbsenceModifyForm absenceModifyForm = (AbsenceModifyForm) form;
		
		// Retrieve all justifications and set them in the form
		try {
			absenceModifyForm.reset();
			absenceModifyForm.setJustifications((List<JustificationEnum>)ManagerManager.getInstance().getEmagineEnumManager().findAll(JustificationEnum.class));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}
		
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}
	
	
	/**
	 * The user wants to create a firm.
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
		AbsenceModifyForm absenceModifyForm = (AbsenceModifyForm) form;
		ManagerManager managerManager = ManagerManager.getInstance();
		ApprenticeManager apprenticeManager = managerManager.getApprenticeManager();
		
		try {
			// Init Absence
			Absence absence = new Absence();
			Apprentice apprentice = apprenticeManager.retrieve(Long.parseLong(((ApprenticeModifyForm) request.getSession().getAttribute("apprenticeModifyForm")).getIdApprenticeToModify()));
			
			// Set values

			if(absenceModifyForm.getIdJustification() != null && !"".equals(absenceModifyForm.getIdJustification()))
					absence.setJustification((JustificationEnum) managerManager.getEmagineEnumManager().retrieve(Long.parseLong(absenceModifyForm.getIdJustification()), JustificationEnum.class));

			if(absenceModifyForm.getInitDate() != null && !"".equals(absenceModifyForm.getInitDate()))
				absence.setStartDate(DateOperations.stringToDate(absenceModifyForm.getInitDate()));

			if(absenceModifyForm.getEndDate() != null && !"".equals(absenceModifyForm.getEndDate()))
				absence.setEndDate(DateOperations.stringToDate(absenceModifyForm.getEndDate()));			
			
			absence.setComment(absenceModifyForm.getComment());
			absence.setApprentice(apprentice);
			
			// Create a apprentice
			apprenticeManager.addAbsence(apprentice, absence);
			
			errors.add("confirm", new ActionMessage("absence.create.confirm"));
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
