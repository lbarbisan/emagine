/**
 *
 */
package fr.umlv.ir3.emagine.apprentice.candidate;

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

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumManager;
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
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		try {
			// Retrieve the candidate we want to see (if he exists) 
			String idCandidate = request.getParameter("id");			
			if(idCandidate != null && !"".equals(idCandidate)) {
				Candidate candidate = managerManager.getCandidateManager().retrieve(Long.parseLong(idCandidate));
				candidateModifyForm.setIdCandidateToModify(idCandidate);
				candidateModifyForm.setFirstName(candidate.getFirstName());
				candidateModifyForm.setLastName(candidate.getLastName());
				candidateModifyForm.setCity(candidate.getBirthdayCity());
				candidateModifyForm.setPersMobile(candidate.getMobilePhone());
				candidateModifyForm.setPersEmail(candidate.getEmail());
				candidateModifyForm.setPersFax(candidate.getFax());
				candidateModifyForm.setPersPhone(candidate.getPhone());
				candidateModifyForm.setAdmissibility(candidate.isAccepted());
				candidateModifyForm.setFormation(candidate.isOtherFormation());
				
				// Sex
				if(candidate.getSex() != null) {
					candidateModifyForm.setIdSex(Long.toString(candidate.getSex().getId()));
				}
				// Birthday
				if(candidate.getBirthdayDate() != null) {
					candidateModifyForm.setBirth(dateToShow(candidate.getBirthdayDate()));		
				}
				//department of birth
				if(candidate.getBirthdayDepartment() != null) {
					candidateModifyForm.setIdDepartment(Long.toString(candidate.getBirthdayDepartment().getId()));
				}
				//country of birth
				if(candidate.getBirthdayCountry() != null) {
					candidateModifyForm.setIdCountry(Long.toString(candidate.getBirthdayCountry().getId()));
				}
				//nationality
				if(candidate.getNationality() != null) {
					candidateModifyForm.setIdNationality(Long.toString(candidate.getNationality().getId()));
				}
				//course option of the candidate
				if(candidate.getCourseOption() != null) {
					candidateModifyForm.setIdCourseOption(Long.toString(candidate.getCourseOption().getId()));	
				}
				//profession of the mother of candidate
				if(candidate.getProfessionMother() != null) {
					candidateModifyForm.setIdMother(Long.toString(candidate.getProfessionMother().getId()));
				}
				//profession of the father of candidate
				if(candidate.getProfessionFather() != null) {
					candidateModifyForm.setIdFather(Long.toString(candidate.getProfessionFather().getId()));
				}
				//center of formation
				if(candidate.getFormationCenter() != null) {
					candidateModifyForm.setIdCenter(Long.toString(candidate.getFormationCenter().getId()));	
				}
				//origin of the contact
				if(candidate.getContactOriginIG2K() != null) {
					candidateModifyForm.setIdContact(Long.toString(candidate.getContactOriginIG2K().getId()));
				}
				//last diploma
				if(candidate.getLastDiploma() != null) {
					candidateModifyForm.setIdDiploma(Long.toString(candidate.getLastDiploma().getId()));
				}
				//Last section of last diploma  
				if(candidate.getLastSection() != null) {
					candidateModifyForm.setIdSection(Long.toString(candidate.getLastSection().getId()));
				}
				//Level of entry
				if(candidate.getEntryLevel() != null) {
					candidateModifyForm.setIdLevel(Long.toString(candidate.getEntryLevel().getId()));					
				}
				if(candidate.getAddressPersonnal() != null) {
					if(candidate.getAddressPersonnal().getStreet() != null) {
					candidateModifyForm.setPersAdress(candidate.getAddressPersonnal().getStreet().toString());
					}

					if(candidate.getAddressPersonnal().getDepartment() != null) {
					candidateModifyForm.setIdPersDepartment(Long.toString(candidate.getAddressPersonnal().getDepartment().getId()));
					}

					if(candidate.getAddressPersonnal().getPostalCode() != null) {
						candidateModifyForm.setPersPostalCode(candidate.getAddressPersonnal().getPostalCode());
					}

					if(candidate.getAddressPersonnal().getCity() != null) {
						candidateModifyForm.setPersCity(candidate.getAddressPersonnal().getCity().toString());
					}
				}
								
				//Retrieve all formation centers and set them in the form
				candidateModifyForm.setCenters(ManagerManager.getInstance().getFormationCenterManager().findAll());

				//Retrieve all department and set them in the form
				candidateModifyForm.setDepartments((List<DepartmentEnum>)emagineEnumManager.findAll(DepartmentEnum.class));
				
				//Retrieve all courseOptions and set them in the form
				candidateModifyForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));
		
				//Retrieve all sexes and set them in the form
				candidateModifyForm.setSexes((List<SexEnum>)emagineEnumManager.findAll(SexEnum.class));
		
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
		EmagineEnumManager emagineEnumManager = managerManager.getEmagineEnumManager();
		
		//Update the Candidate
		try {
			Candidate candidate = candidateManager.retrieve(Long.parseLong(candidateModifyForm.getIdCandidateToModify()));
			candidate.setFirstName(candidateModifyForm.getFirstName());
			candidate.setLastName(candidateModifyForm.getLastName());
			candidate.setSex((SexEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdSex()), SexEnum.class));
			candidate.setBirthdayDate(stringToDate(candidateModifyForm.getBirth()));	
			candidate.setBirthdayCountry((CountryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdCountry()), CountryEnum.class));
			candidate.setNationality((NationalityEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdNationality()), NationalityEnum.class));
			candidate.setBirthdayDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdDepartment()), DepartmentEnum.class));
			candidate.setCourseOption((CourseOptionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdCourseOption()), CourseOptionEnum.class));
			candidate.setProfessionMother((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdMother()), ProfessionEnum.class));
			candidate.setProfessionFather((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdFather()), ProfessionEnum.class));
			candidate.setFormationCenter(centerManager.retrieve(Long.parseLong(candidateModifyForm.getIdCenter())));
			candidate.setContactOriginIG2K((ContactEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdContact()), ContactEnum.class));
			candidate.setLastDiploma((DiplomaEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdDiploma()), DiplomaEnum.class));
			candidate.setLastSection((SectionEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdSection()), SectionEnum.class));
			candidate.setEntryLevel((LevelEntryEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdLevel()), LevelEntryEnum.class));
			candidate.setBirthdayCity(candidateModifyForm.getCity());
			candidate.setAddressPersonnal(new Address());
			candidate.getAddressPersonnal().setStreet(candidateModifyForm.getPersAdress());
			candidate.getAddressPersonnal().setPostalCode(candidateModifyForm.getPersPostalCode());
			candidate.getAddressPersonnal().setCity(candidateModifyForm.getPersCity());
			candidate.getAddressPersonnal().setDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(candidateModifyForm.getIdDepartment()), DepartmentEnum.class));
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
