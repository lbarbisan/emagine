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

import fr.umlv.ir3.emagine.apprentice.Contact;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class CandidateCreateAction extends BaseAction {

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		CandidateModifyForm candidateModifyForm = (CandidateModifyForm) form;
		
		try {
			candidateModifyForm.reset();
			
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
			//log.trace(candidateCreateForm.isFormation());


		}catch (EMagineException exception) {
			//log.error(exception);
			addEMagineExceptionError(errors, exception);
		}

		// Report back any errors, and exit if any
		return successIfNoErrors(mapping, request, errors);

	}

	
	/**
	 * The administrator wants to search all the users matching his or her request.
	 * @param params the search parameters
	 * @param request the request
	 */
	public ActionForward create(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		CandidateModifyForm candidateForm = (CandidateModifyForm) form;
		
		ManagerManager managerManager = ManagerManager.getInstance();
		CandidateManager candidateManager = managerManager.getCandidateManager();
		FormationCenterManager centerManager = managerManager.getFormationCenterManager();

		// Init candidate
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateForm.getFirstName());
		candidate.setLastName(candidateForm.getLastName());
		candidate.setSex(SexEnum.valueOf(candidateForm.getIdSex()));
		candidate.setBirthdayDate(StringToDate(candidateForm.getBirth()));		
		candidate.setBirthdayCountry(CountryEnum.valueOf(candidateForm.getIdCountry()));
		candidate.setNationality(NationalityEnum.valueOf(candidateForm.getIdNationality()));
		//TODO candidate.setBirthdayDepartment(DepartmentEnum.valueOf(candidateForm.getIdDepartment()));
		candidate.setCourseOption(CourseOptionEnum.valueOf(candidateForm.getIdCourseOption()));
		candidate.setProfessionMother(ProfessionEnum.valueOf(candidateForm.getIdMother()));
		candidate.setProfessionFather(ProfessionEnum.valueOf(candidateForm.getIdFather()));
		candidate.setFormationCenter(centerManager.retrieve(Long.parseLong(candidateForm.getIdCenter())));
		//TODO candidate.setContactOriginIG2K(ContactEnum.valueOf(candidateForm.getIdContact()));
		//TODO candidate.setLastDiploma(DiplomaEnum.valueOf(candidateForm.getIdDiploma()));
		//TODO candidate.setLastSection(LastSectionEnum.valueOf(candidateForm.getIdSection()));
		candidate.setEntryLevel(LevelEntryEnum.valueOf(candidateForm.getIdLevel()));
		candidate.setBirthdayCity(candidateForm.getCity());
		candidate.setAddressPersonnal(new Address());
		candidate.getAddressPersonnal().setStreet(candidateForm.getPersAdress());
		candidate.getAddressPersonnal().setPostalCode(candidateForm.getPersPostalCode());
		candidate.getAddressPersonnal().setCity(candidateForm.getPersCity());
		candidate.getAddressPersonnal().setDepartment(DepartmentEnum.valueOf(candidateForm.getIdPersDepartment()));
		candidate.setMobilePhone(candidateForm.getPersMobile());
		candidate.setEmail(candidateForm.getPersEmail());
		candidate.setFax(candidateForm.getPersFax());
		candidate.setPhone(candidateForm.getPersPhone());
		candidate.setAccepted(candidateForm.isAdmissibility());
		candidate.setOtherFormation(candidateForm.isFormation());
		

		// Create a candidate
		try {
			candidateManager.create(candidate);
			errors.add("confirm", new ActionMessage("candidate.create.confirm"));
		} catch (EMagineException exception) {
			addEMagineExceptionError(errors, exception);
		}

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
