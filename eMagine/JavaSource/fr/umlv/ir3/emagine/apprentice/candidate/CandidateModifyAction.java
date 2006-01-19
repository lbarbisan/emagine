/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class CandidateModifyAction extends BaseAction {

	/**
	 * The administrator wants to show the details of candidate.
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
		CandidateModifyForm candidateModifyForm = (CandidateModifyForm) form;
		
		try {
			// Retrieve the candidate we want to see (if he exists) 
			String idCandidate = request.getParameter("id");			
			if(idCandidate != null && !"".equals(idCandidate)) {
				Candidate candidate = managerManager.getCandidateManager().retrieve(Long.parseLong(idCandidate));
				candidateModifyForm.setLastName(candidateModifyForm.getLastName());
				candidateModifyForm.setIdSex(Long.toString(candidate.getSex().getId()));
				//TODO mettre au bon format la date!!
				candidateModifyForm.setBirth(candidate.getBirthdayDate().toString());		
				candidateModifyForm.setIdCountry(Long.toString(candidate.getBirthdayCountry().getId()));
				candidateModifyForm.setIdNationality(Long.toString(candidate.getNationality().getId()));
				candidateModifyForm.setIdDepartment(Long.toString(candidate.getBirthdayDepartment().getId()));
				candidateModifyForm.setIdCourseOption(Long.toString(candidate.getCourseOption().getId()));
				candidateModifyForm.setIdMother(Long.toString(candidate.getProfessionMother().getId()));
				candidateModifyForm.setIdFather(Long.toString(candidate.getProfessionFather().getId()));
				candidateModifyForm.setIdCenter(Long.toString(candidate.getFormationCenter().getId()));
				//TODO candidateModifyForm.setContactOriginIG2K(ContactEnum.valueOf(candidateModifyForm.getIdContact()));
				//TODO candidateModifyForm.setLastDiploma(DiplomaEnum.valueOf(candidateModifyForm.getIdDiploma()));
				//TODO candidateModifyForm.setLastSection(LastSectionEnum.valueOf(candidateModifyForm.getIdSection()));
				/*candidateModifyForm.setEntryLevel(LevelEntryEnum.valueOf(candidateModifyForm.getIdLevel()));
				candidateModifyForm.setBirthdayCity(candidateModifyForm.getCity());
				candidateModifyForm.setAddressPersonnal(new Address());
				candidateModifyForm.getAddressPersonnal().setStreet(candidateModifyForm.getPersAdress());
				candidateModifyForm.getAddressPersonnal().setPostalCode(candidateModifyForm.getPersPostalCode());
				candidateModifyForm.getAddressPersonnal().setCity(candidateModifyForm.getPersCity());
				candidateModifyForm.getAddressPersonnal().setDepartment(DepartmentEnum.valueOf(candidateModifyForm.getIdPersDepartment()));
				candidateModifyForm.setMobilePhone(candidateModifyForm.getPersMobile());
				candidateModifyForm.setEmail(candidateModifyForm.getPersEmail());
				candidateModifyForm.setFax(candidateModifyForm.getPersFax());
				candidateModifyForm.setPhone(candidateModifyForm.getPersPhone());
				candidateModifyForm.setAccepted(candidateModifyForm.isAdmissibility());
				candidateModifyForm.setOtherFormation(candidateModifyForm.isFormation());
				
				//Retrieve all formation centers and set them in the form
				candidateModifyForm.setCenters(ManagerManager.getInstance().getFormationCenterManager().findAll());

				//Retrieve all department and set them in the form
				candidateModifyForm.setDepartments(Arrays.asList(DepartmentEnum.values()));
				
				//Retrieve all courseOptions and set them in the form
				candidateModifyForm.setCourseOptions(Arrays.asList(CourseOptionEnum.values()));
		
				//Retrieve all sexes and set them in the form
				candidateModifyForm.setSexes(Arrays.asList(SexEnum.values()));
		
				//Retrieve all diplomas and set them in the form		
				candidateModifyForm.setDiplomas(Arrays.asList(DiplomaEnum.values()));

				//Retrieve all sections for the diploma and set them in the form
				candidateModifyForm.setSections(Arrays.asList(SectionEnum.values()));
				
				//Retrieve all nationalities and set them in the form
				candidateModifyForm.setNationalities(Arrays.asList(NationalityEnum.values()));

				//Retrieve all levels and set them in the form
				candidateModifyForm.setLevels(Arrays.asList(LevelEntryEnum.values()));

				//Retrieve all professions and set them in the form
				candidateModifyForm.setProfessions(Arrays.asList(ProfessionEnum.values()));
				
				//Retrieve all countries and set them in the form
				candidateModifyForm.setCountries(Arrays.asList(CountryEnum.values()));
				
				//Retrieve all department and set them in the form
				candidateModifyForm.setContacts(Arrays.asList(ContactEnum.values()));
			
				candidateModifyForm.setIdSex((SexEnum.MALE).getId());
		*/

			}
			
		} catch (EMagineException exception) {
			exception.printStackTrace();
			addEMagineExceptionError(errors, exception);	
		}
	
        // Report back any errors, and exit if any
		return viewFormIfNoErrors(mapping, request, errors);
	}

	/**
	 * The administrator wants to modify the informations of user.
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
		CandidateManager candidateManager = managerManager.getCandidateManager();
		FormationCenterManager centerManager = managerManager.getFormationCenterManager();
		CandidateModifyForm candidateModifyForm = (CandidateModifyForm) form;

		// Update the Candidate
		/*try {
			Candidate candidate = candidateManager.retrieve(Long.parseLong(candidateModifyForm.getIdCandidateToModify()));
			candidate.setFirstName(candidateModifyForm.getFirstName());
			candidate.setLastName(candidateModifyForm.getLastName());
			candidate.setSex(SexEnum.valueOf(candidateModifyForm.getIdSex()));
			candidate.setBirthdayDate(StringToDate(candidateModifyForm.getBirth()));		
			candidate.setBirthdayCountry(CountryEnum.valueOf(candidateModifyForm.getIdCountry()));
			candidate.setNationality(NationalityEnum.valueOf(candidateModifyForm.getIdNationality()));
			//TODO candidate.setBirthdayDepartment(DepartmentEnum.valueOf(candidateModifyForm.getIdDepartment()));
			candidate.setCourseOption(CourseOptionEnum.valueOf(candidateModifyForm.getIdCourseOption()));
			candidate.setProfessionMother(ProfessionEnum.valueOf(candidateModifyForm.getIdMother()));
			candidate.setProfessionFather(ProfessionEnum.valueOf(candidateModifyForm.getIdFather()));
			candidate.setFormationCenter(centerManager.retrieve(Long.parseLong(candidateModifyForm.getIdCenter())));
			//TODO candidate.setContactOriginIG2K(ContactEnum.valueOf(candidateModifyForm.getIdContact()));
			//TODO candidate.setLastDiploma(DiplomaEnum.valueOf(candidateModifyForm.getIdDiploma()));
			//TODO candidate.setLastSection(LastSectionEnum.valueOf(candidateModifyForm.getIdSection()));
			candidate.setEntryLevel(LevelEntryEnum.valueOf(candidateModifyForm.getIdLevel()));
			candidate.setBirthdayCity(candidateModifyForm.getCity());
			candidate.setAddressPersonnal(new Address());
			candidate.getAddressPersonnal().setStreet(candidateModifyForm.getPersAdress());
			candidate.getAddressPersonnal().setPostalCode(candidateModifyForm.getPersPostalCode());
			candidate.getAddressPersonnal().setCity(candidateModifyForm.getPersCity());
			candidate.getAddressPersonnal().setDepartment(DepartmentEnum.valueOf(candidateModifyForm.getIdPersDepartment()));
			candidate.setMobilePhone(candidateModifyForm.getPersMobile());
			candidate.setEmail(candidateModifyForm.getPersEmail());
			candidate.setFax(candidateModifyForm.getPersFax());
			candidate.setPhone(candidateModifyForm.getPersPhone());
			candidate.setAccepted(candidateModifyForm.isAdmissibility());
			candidate.setOtherFormation(candidateModifyForm.isFormation());			
			candidateManager.update(candidate);
			
		} catch (EMagineException exception) {
				addEMagineExceptionError(errors, exception);
		}
*/
        // Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);
	}
	private Date StringToDate(String stringDate)
	{
	    
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	    Date date = Calendar.getInstance().getTime();
	    
	    try{
	        date = simpleDateFormat.parse(stringDate);
	    }catch(ParseException e){}     
	  
	    return date;
	}
}
