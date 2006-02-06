/**
 *
 */
package fr.umlv.ir3.emagine.apprentice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class ApprenticeModifyAbsenceAction extends BaseAction {

	/**
	 * The user wants to show the details of apprentice absence.
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
		ApprenticeModifyForm apprenticeModifyAbsenceForm = (ApprenticeModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			// Retrieve the candidate we want to see (if he exists) 
			String idAbsence = request.getParameter("id");			
			if(idAbsence != null && !"".equals(idAbsence)) {
				Absence absence = managerManager.getAbsenceManager().retrieve(Long.parseLong(idAbsence));
				apprenticeModifyAbsenceForm.setIdAbsenceToModify(idAbsence);
				apprenticeModifyAbsenceForm.setInitDate(dateToShow(absence.getStartDate()));
				apprenticeModifyAbsenceForm.setEndDate(dateToShow(absence.getEndDate()));
				apprenticeModifyAbsenceForm.setComment(absence.getJustificationComment());
				//apprenticeModifyAbsenceForm.setIdJustification(absence.getJustification());
				//apprenticeModifyAbsenceForm.setNbDays(absence.getNumberOfWorkedDays().toString());
				
				// Justification
				if(absence.getJustificationComment() != null) {
					//apprenticeModifyAbsenceForm.setIdJustification(Long.toString(absence.getJustification().getId()));
				}
			}
			
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);	
		}
	
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The user wants to modify an absence of an apprentice.
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
		FormationCenterManager centerManager = managerManager.getFormationCenterManager();
		ApprenticeModifyForm candidateModifyForm = (ApprenticeModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		//Update the Candidate
		try {
			Absence absence = absenceManager.retrieve(Long.parseLong(candidateModifyForm.getIdAbsenceToModify()));
			absence.setStartDate(stringToDate(candidateModifyForm.getInitDate()));
			absence.setEndDate(stringToDate(candidateModifyForm.getEndDate()));
			//TODO c'est calculé: comment faire ? absence.setNumber...(candidateModifyForm.getNbDays());
			//TODO justification a repasser en enum et pas en boolean : il y a plus que 2 valeurs!!!
			//absence.setJustification(candidateModifyForm.getIdJustification());
			absence.setJustificationComment(candidateModifyForm.getComment());
			
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
		String stringDate = "";
		if (date != null) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy");
			stringDate = simpleDateFormat.format(date);
		}
		System.err.println(stringDate);
		return stringDate;
	}
}
