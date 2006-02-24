package fr.umlv.ir3.emagine.apprentice.candidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.DateOperations;
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
		candidate.setBirthdayDate(DateOperations.stringToDate(candidateForm.getBirth()));	
		candidate.setBirthdayCity(candidateForm.getCity());
		candidate.setEmail(candidateForm.getPersEmail());
		candidate.setFax(candidateForm.getPersFax());
		candidate.setPhone(candidateForm.getPersPhone());
		candidate.setAccepted(candidateForm.isAdmissibility());
		candidate.setOtherFormation(candidateForm.isFormation());
		candidate.setMobilePhone(candidateForm.getPersMobile());
		
		if(candidateForm.getIdSex()!= null && !"".equals(candidateForm.getIdSex()))
			candidate.setSex((SexEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdSex()), SexEnum.class));

		if(candidateForm.getIdCountry()!= null && !"".equals(candidateForm.getIdCountry()))
			candidate.setBirthdayCountry((CountryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdCountry()), CountryEnum.class));
		
		if(candidateForm.getIdNationality()!= null && !"".equals(candidateForm.getIdNationality()))
			candidate.setNationality((NationalityEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdNationality()), NationalityEnum.class));
		
		if(candidateForm.getIdDepartment()!= null && !"".equals(candidateForm.getIdDepartment()))
			candidate.setBirthdayDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdDepartment()), DepartmentEnum.class));
		
		if(candidateForm.getIdCourseOption()!= null && !"".equals(candidateForm.getIdCourseOption()))
			candidate.setCourseOption((CourseOptionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdCourseOption()), CourseOptionEnum.class));
		
		if(candidateForm.getIdMother()!= null && !"".equals(candidateForm.getIdMother()))
			candidate.setProfessionMother((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdMother()), ProfessionEnum.class));
		
		if(candidateForm.getIdFather()!= null && !"".equals(candidateForm.getIdFather()))
			candidate.setProfessionFather((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdFather()), ProfessionEnum.class));
		
		if(candidateForm.getIdCenter()!= null && !"".equals(candidateForm.getIdCenter()))
			candidate.setFormationCenter(centerManager.retrieve(Long.parseLong(candidateForm.getIdCenter())));
		
		if(candidateForm.getIdContact()!= null && !"".equals(candidateForm.getIdContact()))
			candidate.setContactOriginIG2K((ContactEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdContact()), ContactEnum.class));
		
		if(candidateForm.getIdDiploma()!= null && !"".equals(candidateForm.getIdDiploma()))
			candidate.setLastDiploma((DiplomaEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdDiploma()), DiplomaEnum.class));
		
		if(candidateForm.getIdSection()!= null && !"".equals(candidateForm.getIdSection()))
			candidate.setLastSection((SectionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdSection()), SectionEnum.class));
		
		if(candidateForm.getIdLevel()!= null && !"".equals(candidateForm.getIdLevel()))
			candidate.setEntryLevel((LevelEntryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateForm.getIdLevel()), LevelEntryEnum.class));

		
		// Create an address
		Address address = null;
		if(	(candidateForm.getPersPostalCode() != null && !"".equals(candidateForm.getPersPostalCode()))
				|| (candidateForm.getPersAdress() != null && !"".equals(candidateForm.getPersAdress()))
				|| (candidateForm.getPersCity() != null && !"".equals(candidateForm.getPersCity()))
				|| (candidateForm.getIdDepartment() != null && !"".equals(candidateForm.getIdDepartment()))) {
			
			address = (candidate.getAddressPersonnal() == null ? new Address() : candidate.getAddressPersonnal());
			address.setCity(candidateForm.getPersCity());
			address.setPostalCode(candidateForm.getPersPostalCode());
			address.setStreet(candidateForm.getPersAdress());
			address.setDepartment(candidateForm.getIdDepartment() != null && !"".equals(candidateForm.getIdDepartment())
				? (DepartmentEnum) ManagerManager.getInstance().getEmagineEnumManager().retrieve(Long.parseLong(candidateForm.getIdDepartment()),DepartmentEnum.class) : null);
		}

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
}
