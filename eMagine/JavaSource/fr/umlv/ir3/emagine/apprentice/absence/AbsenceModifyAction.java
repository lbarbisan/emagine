/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeModifyForm;
import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.util.DateOperations;
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

				// Retrieve the absence to modify
				Absence absence = managerManager.getAbsenceManager().retrieve(Long.parseLong(id));

				// Reset all form
				absenceModifyForm.reset();

				// Set infos
				absenceModifyForm.setIdAbsenceToModify(absence.getId().toString());
				
				if(absence.getStartDate() != null) {
					absenceModifyForm.setInitDate(DateOperations.dateToShow(absence.getStartDate()));		
				}
				if(absence.getEndDate() != null) {
					absenceModifyForm.setEndDate(DateOperations.dateToShow(absence.getEndDate()));		
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
		ApprenticeManager apprenticeManager = managerManager.getApprenticeManager();
		AbsenceModifyForm absenceModifyForm = (AbsenceModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();

		
		// Update the absence
		try {
			Absence absence = absenceManager.retrieve(Long.parseLong(absenceModifyForm.getIdAbsenceToModify()));
			Apprentice apprentice = apprenticeManager.retrieve(
					Long.parseLong(
							((ApprenticeModifyForm)request.getSession().getAttribute("apprenticeModifyForm")).getIdApprenticeToModify()));
			// Set values
			absence.setStartDate(DateOperations.stringToDate(absenceModifyForm.getInitDate()));
			absence.setEndDate(DateOperations.stringToDate(absenceModifyForm.getEndDate()));
			absence.setJustification((JustificationEnum) emagineEnumManager.retrieve(Long.parseLong(absenceModifyForm.getIdJustification()), JustificationEnum.class));
			absence.setComment(absenceModifyForm.getComment());
									
			apprenticeManager.addAbsence(apprentice, absence);
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}

        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
}
