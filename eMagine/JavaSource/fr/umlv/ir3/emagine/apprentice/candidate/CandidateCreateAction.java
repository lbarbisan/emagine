package fr.umlv.ir3.emagine.apprentice.candidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseAction;

public class CandidateCreateAction extends BaseAction {

	public ActionForward show(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionMessages errors = new ActionMessages();
		ManagerManager managerManager = ManagerManager.getInstance();
		CandidateModifyForm candidateModifyForm = (CandidateModifyForm) form;
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			candidateModifyForm.reset();
			
			//Retrieve all formation centers and set them in the form
			candidateModifyForm.setCenters(managerManager.getFormationCenterManager().findAll());

			//Retrieve all department and set them in the form
			candidateModifyForm.setDepartments((List<DepartmentEnum>)emagineEnumManager.findAll(DepartmentEnum.class));
			
			//Retrieve all courseOptions and set them in the form
			candidateModifyForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));
	
			//Retrieve all sexes and set them in the form
			System.err.println(emagineEnumManager.findAll(SexEnum.class));
			List<SexEnum> sexes = (List<SexEnum>)emagineEnumManager.findAll(SexEnum.class);
			candidateModifyForm.setIdSex(Long.toString(sexes.get(0).getId()));
			candidateModifyForm.setSexes(sexes);
	
			//Retrieve all diplomas and set them in the form		
			candidateModifyForm.setDiplomas((List<DiplomaEnum>)emagineEnumManager.findAll(DiplomaEnum.class));

			//Retrieve all sections for the diploma and set them in the form
			candidateModifyForm.setSections((List<SectionEnum>)emagineEnumManager.findAll(SectionEnum.class));
			
			//Retrieve all nationalities and set them in the form
			candidateModifyForm.setNationalities((List<NationalityEnum>)emagineEnumManager.findAll(NationalityEnum.class));

			//Retrieve all levels and set them in the form
			candidateModifyForm.setLevels((List<LevelEntryEnum>)emagineEnumManager.findAll(LevelEntryEnum.class));

			//Retrieve all professions and set them in the form
			candidateModifyForm.setProfessions((List<ProfessionEnum>)emagineEnumManager.findAll(ProfessionEnum.class));
			
			//Retrieve all countries and set them in the form
			candidateModifyForm.setCountries((List<CountryEnum>)emagineEnumManager.findAll(CountryEnum.class));
			
			//Retrieve all department and set them in the form
			candidateModifyForm.setContacts((List<ContactEnum>)emagineEnumManager.findAll(ContactEnum.class));
		
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
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();

		// Init candidate
		Candidate candidate = new Candidate();
		candidate.setFirstName(candidateForm.getFirstName());
		candidate.setLastName(candidateForm.getLastName());
		candidate.setSex((SexEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdSex()), SexEnum.class));
		candidate.setBirthdayDate(stringToDate(candidateForm.getBirth()));	
		candidate.setBirthdayCountry((CountryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdCountry()), CountryEnum.class));
		candidate.setNationality((NationalityEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdNationality()), NationalityEnum.class));
		candidate.setBirthdayDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdDepartment()), DepartmentEnum.class));
		candidate.setCourseOption((CourseOptionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdCourseOption()), CourseOptionEnum.class));
		candidate.setProfessionMother((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdMother()), ProfessionEnum.class));
		candidate.setProfessionFather((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdFather()), ProfessionEnum.class));
		//TODO candidate.setFormationCenter(centerManager.retrieve(Long.parseLong(candidateForm.getIdCenter())), ProfessionEnum.class);
		//TODO candidate.setContactOriginIG2K(new Contact((ContactEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdContact()), ContactEnum.class)));
		candidate.setLastDiploma((DiplomaEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdDiploma()), DiplomaEnum.class));
		candidate.setLastSection((SectionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdSection()), SectionEnum.class));
		candidate.setEntryLevel((LevelEntryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdLevel()), LevelEntryEnum.class));
		candidate.setBirthdayCity(candidateForm.getCity());
		candidate.setAddressPersonnal(new Address());
		candidate.getAddressPersonnal().setStreet(candidateForm.getPersAdress());
		candidate.getAddressPersonnal().setPostalCode(candidateForm.getPersPostalCode());
		candidate.getAddressPersonnal().setCity(candidateForm.getPersCity());
		candidate.getAddressPersonnal().setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdDepartment()), DepartmentEnum.class));
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

	private Date stringToDate(String stringDate) {
		Date date = null;
		System.err.println(stringDate);
		if (stringDate != "") {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yy-MM-dd hh:mm:ss:nn");
			date = Calendar.getInstance().getTime();
			try {
				date = simpleDateFormat.parse(stringDate);
				System.err.println(date);
			} catch (ParseException e) {
			}
		}
		return date;
	}
}
