/**
 *
 */
package fr.umlv.ir3.emagine.apprentice;

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

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class ApprenticeModifyAction extends BaseAction {

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
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		ApprenticeModifyForm apprenticeModifyForm = (ApprenticeModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			
			/**
			 * Datas concerning the absences of an apprentice
			 */
			/*//Retrieve the absence we want to see (if it exists) 
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
			}*/
			String idApprentice = request.getParameter("id");			
			if(idApprentice != null && !"".equals(idApprentice)) {
				Apprentice apprentice = managerManager.getApprenticeManager().retrieve(Long.parseLong(idApprentice));
				apprenticeModifyForm.setIdApprenticeToModify(idApprentice);
				
				if(apprentice.getAddressPersonnal() != null) {
					if(apprentice.getAddressPersonnal().getStreet() != null) {
					apprenticeModifyForm.setPersAddress(apprentice.getAddressPersonnal().getStreet().toString());
					}
					
					if(apprentice.getAddressPersonnal().getDepartment() != null) {
						apprenticeModifyForm.setIdPersDepartment(Long.toString(apprentice.getAddressPersonnal().getDepartment().getId()));
					}
					
					if(apprentice.getAddressPersonnal().getPostalCode() != null) {
						apprenticeModifyForm.setPersPostalCode(apprentice.getAddressPersonnal().getPostalCode());
					}
					if(apprentice.getAddressPersonnal().getCity() != null) {
						apprenticeModifyForm.setPersCity(apprentice.getAddressPersonnal().getCity().toString());
					}
				}
				apprenticeModifyForm.setPersEmail(apprentice.getEmail());
				apprenticeModifyForm.setPersPhone(apprentice.getPhone());
				apprenticeModifyForm.setPersMobile(apprentice.getMobilePhone());
				apprenticeModifyForm.setPersFax(apprentice.getFax());

				if(apprentice.getAddressProfessional() != null) {
					if(apprentice.getAddressProfessional().getStreet() != null) {
					apprenticeModifyForm.setProfAddress(apprentice.getAddressProfessional().getStreet().toString());
					}
					
					if(apprentice.getAddressProfessional().getDepartment() != null) {
						apprenticeModifyForm.setIdProfDepartment(Long.toString(apprentice.getAddressProfessional().getDepartment().getId()));
					}
					
					if(apprentice.getAddressProfessional().getPostalCode() != null) {
						apprenticeModifyForm.setProfPostalCode(apprentice.getAddressProfessional().getPostalCode());
					}
					if(apprentice.getAddressProfessional().getCity() != null) {
						apprenticeModifyForm.setProfCity(apprentice.getAddressProfessional().getCity().toString());
					}
				}
				apprenticeModifyForm.setProfEmail(apprentice.getProfEmail());
				apprenticeModifyForm.setProfPhone(apprentice.getProfPhone());
				apprenticeModifyForm.setProfMobile(apprentice.getProfMobile());
				apprenticeModifyForm.setProfFax(apprentice.getProfFax());
				
				if(apprentice.getAddressAcademic() != null) {
					if(apprentice.getAddressAcademic().getStreet() != null) {
					apprenticeModifyForm.setAcaAddress(apprentice.getAddressAcademic().getStreet().toString());
					}
					
					if(apprentice.getAddressAcademic().getDepartment() != null) {
						apprenticeModifyForm.setIdAcaDepartment(Long.toString(apprentice.getAddressAcademic().getDepartment().getId()));
					}
					
					if(apprentice.getAddressAcademic().getPostalCode() != null) {
						apprenticeModifyForm.setAcaPostalCode(apprentice.getAddressAcademic().getPostalCode());
					}
					if(apprentice.getAddressAcademic().getCity() != null) {
						apprenticeModifyForm.setProfCity(apprentice.getAddressAcademic().getCity().toString());
					}
				}
				apprenticeModifyForm.setAcaEmail(apprentice.getAcaEmail());
				apprenticeModifyForm.setAcaPhone(apprentice.getAcaPhone());
				apprenticeModifyForm.setAcaMobile(apprentice.getAcaMobile());
				apprenticeModifyForm.setAcaFax(apprentice.getAcaFax());
			
				//Retrieve all department and set them in the form
				apprenticeModifyForm.setDepartments((List<DepartmentEnum>)emagineEnumManager.findAll(DepartmentEnum.class));
				
				//Retrieve all address types and set them in the form
				apprenticeModifyForm.setDefaultAddresses((List<DefaultAddressEnum>)emagineEnumManager.findAll(DefaultAddressEnum.class));
				
				// default address
				if(apprentice.getDefaultAddress() != null) {
					apprenticeModifyForm.setIdDefaultAddress(Long.toString(apprentice.getDefaultAddress().getId()));
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
		//AbsenceManager absenceManager = managerManager.getAbsenceManager();
		ApprenticeManager apprenticeManager = managerManager.getApprenticeManager();
		ApprenticeModifyForm apprenticeModifyForm = (ApprenticeModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		//Update the apprentice
		try {
			/*Absence absence = absenceManager.retrieve(Long.parseLong(candidateModifyForm.getIdAbsenceToModify()));
			absence.setStartDate(stringToDate(candidateModifyForm.getInitDate()));
			absence.setEndDate(stringToDate(candidateModifyForm.getEndDate()));
			//TODO c'est calculé: comment faire ? absence.setNumber...(candidateModifyForm.getNbDays());
			//TODO justification a repasser en enum et pas en boolean : il y a plus que 2 valeurs!!!
			absence.setJustification(candidateModifyForm.getIdJustification());
			absence.setJustificationComment(candidateModifyForm.getComment());*/
			
			
			Apprentice apprentice = apprenticeManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdApprenticeToModify()));
			
			/* Datas concerning the address tab*/
			apprentice.setDefaultAddress((DefaultAddressEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdDefaultAddress()), DefaultAddressEnum.class));
			
			apprentice.getAddressPersonnal().setStreet(apprenticeModifyForm.getPersAddress());
			apprentice.getAddressPersonnal().setPostalCode(apprenticeModifyForm.getPersPostalCode());
			apprentice.getAddressPersonnal().setCity(apprenticeModifyForm.getPersCity());
			apprentice.getAddressPersonnal().setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdPersDepartment()), DepartmentEnum.class));
			apprentice.setMobilePhone(apprenticeModifyForm.getPersMobile());
			apprentice.setEmail(apprenticeModifyForm.getPersEmail());
			apprentice.setFax(apprenticeModifyForm.getPersFax());
			apprentice.setPhone(apprenticeModifyForm.getPersPhone());
			
			apprentice.getAddressProfessional().setStreet(apprenticeModifyForm.getProfAddress());
			apprentice.getAddressProfessional().setPostalCode(apprenticeModifyForm.getProfPostalCode());
			apprentice.getAddressProfessional().setCity(apprenticeModifyForm.getProfCity());
			if (!"".equals(apprenticeModifyForm.getIdProfDepartment())){
					apprentice.getAddressProfessional().setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdProfDepartment()), DepartmentEnum.class));
			}
			apprentice.setMobilePhone(apprenticeModifyForm.getProfMobile());
			apprentice.setEmail(apprenticeModifyForm.getProfEmail());
			apprentice.setFax(apprenticeModifyForm.getProfFax());
			apprentice.setPhone(apprenticeModifyForm.getProfPhone());

			apprentice.getAddressAcademic().setStreet(apprenticeModifyForm.getAcaAddress());
			apprentice.getAddressAcademic().setPostalCode(apprenticeModifyForm.getAcaPostalCode());
			apprentice.getAddressAcademic().setCity(apprenticeModifyForm.getAcaCity());
			if (!"".equals(apprenticeModifyForm.getIdAcaDepartment())){
				apprentice.getAddressAcademic().setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdAcaDepartment()), DepartmentEnum.class));
			}
			apprentice.setMobilePhone(apprenticeModifyForm.getAcaMobile());
			apprentice.setEmail(apprenticeModifyForm.getAcaEmail());
			apprentice.setFax(apprenticeModifyForm.getAcaFax());
			apprentice.setPhone(apprenticeModifyForm.getAcaPhone());
		
			/* Datas concerning the schooling tab*/
			
			
			
			
			
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
