/**
 *
 */
package fr.umlv.ir3.emagine.apprentice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import fr.umlv.ir3.emagine.apprentice.candidate.ContactEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.DiplomaEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.ProfessionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.SectionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.YearObtentionEnum;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
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
			 * Commons datas for the apprentice
			 */		
			
			//apprenticeModifyForm.setTab();
			
			String idApprentice = request.getParameter("id");			
			if(idApprentice != null && !"".equals(idApprentice)) {
				Apprentice apprentice = managerManager.getApprenticeManager().retrieve(Long.parseLong(idApprentice));
				apprenticeModifyForm.setIdApprenticeToModify(idApprentice);
				
				/**
				 * Datas concerning the Addresses of the apprentice
				 */
				// default address
				if(apprentice.getDefaultAddress() != null) {
					apprenticeModifyForm.setIdDefaultAddress(Long.toString(apprentice.getDefaultAddress().getId()));
				}
				
				//personnal address
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

				//professionnal address
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
				
				//Academic address
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
			
				
				/**
				 * Datas concerning the status of the apprentice
				 */
				//first name
				apprenticeModifyForm.setFirstName(apprentice.getFirstName());
				//last name
				apprenticeModifyForm.setLastName(apprentice.getLastName());
				//Sex
				if(apprentice.getSex() != null) {
					apprenticeModifyForm.setIdSex(Long.toString(apprentice.getSex().getId()));
				}
				// Birthday date
				if(apprentice.getBirthdayDate() != null) {
					apprenticeModifyForm.setBirth(dateToShow(apprentice.getBirthdayDate()));		
				}
				// city of birth
				apprenticeModifyForm.setCity(apprentice.getBirthdayCity());
	
				// country of birth
				if(apprentice.getBirthdayCountry() != null) {
					apprenticeModifyForm.setIdCountry(Long.toString(apprentice.getBirthdayCountry().getId()));
				}
				//nationality
				if(apprentice.getNationality() != null) {
					apprenticeModifyForm.setIdNationality(Long.toString(apprentice.getNationality().getId()));
				}
				//department of birth
				if(apprentice.getBirthdayDepartment() != null) {
					apprenticeModifyForm.setIdDepartmentBirth(Long.toString(apprentice.getBirthdayDepartment().getId()));
				}
				//profession of the mother of apprentice
				if(apprentice.getProfessionMother() != null) {
					apprenticeModifyForm.setIdMother(Long.toString(apprentice.getProfessionMother().getId()));
				}
				//profession of the father of apprentice
				if(apprentice.getProfessionFather() != null) {
					apprenticeModifyForm.setIdFather(Long.toString(apprentice.getProfessionFather().getId()));
				}
				
				//origin of the contact
				if(apprentice.getContactOriginIG2K() != null) {
					apprenticeModifyForm.setIdContact(Long.toString(apprentice.getContactOriginIG2K().getId()));
				}
				
				/**
				 * Datas concerning the Situation of the apprentice
				 */
				
				if(apprentice.getCourseOption() != null) {
					apprenticeModifyForm.setIdCourseOption(Long.toString(apprentice.getCourseOption().getId()));
				}

				if(apprentice.getYear() != null) {
					apprenticeModifyForm.setIdYear(Long.toString(apprentice.getYear().getId()));
				}
				
				if(apprentice.getGroup() != null) {
					apprenticeModifyForm.setIdGroup(Long.toString(apprentice.getGroup().getId()));
				}
				
				if(apprentice.getFirm() != null) {
					apprenticeModifyForm.setIdFirm(Long.toString(apprentice.getFirm().getId()));
				}

				if(apprentice.getEngineerTutor() != null) {
					apprenticeModifyForm.setIdEngineerTutor(Long.toString(apprentice.getEngineerTutor().getId()));
				}
				
				if(apprentice.getTeacherTutor() != null) {
					apprenticeModifyForm.setIdTeacherTutor(Long.toString(apprentice.getTeacherTutor().getId()));
				}			
				
				/** schooling concerning tab **/
								
				/*if(apprentice.getLanguage1() != null) {
					apprenticeModifyForm.setIdTeacherTutor(Long.toString(apprentice.getTeacherTutor().getId()));
				}
				if(apprentice.getLanguage2() != null) {
					apprenticeModifyForm.setIdTeacherTutor(Long.toString(apprentice.getTeacherTutor().getId()));
				}*/
				
				/** Commons lists : **/
				
				//Retrieve all departments and set them in the form
				apprenticeModifyForm.setDepartments((List<DepartmentEnum>)emagineEnumManager.findAll(DepartmentEnum.class));
				
				//Retrieve all addresses types and set them in the form
				apprenticeModifyForm.setDefaultAddresses((List<DefaultAddressEnum>)emagineEnumManager.findAll(DefaultAddressEnum.class));
				
				//Retrieve all countries and set them in the form
				apprenticeModifyForm.setCountries((List<CountryEnum>)emagineEnumManager.findAll(CountryEnum.class));
				
				//Retrieve all sexes and set them in the form
				apprenticeModifyForm.setSexes((List<SexEnum>)emagineEnumManager.findAll(SexEnum.class));
				
				//Retrieve all professions and set them in the form
				apprenticeModifyForm.setProfessions((List<ProfessionEnum>)emagineEnumManager.findAll(ProfessionEnum.class));

				//Retrieve all nationalities and set them in the form
				apprenticeModifyForm.setNationalities((List<NationalityEnum>)emagineEnumManager.findAll(NationalityEnum.class));

				//Retrieve all contacts and set them in the form
				apprenticeModifyForm.setContacts((List<ContactEnum>)emagineEnumManager.findAll(ContactEnum.class));
				
				//Retrieve all groupss and set them in the form
				apprenticeModifyForm.setYears((List<YearEnum>)emagineEnumManager.findAll(YearEnum.class));
				
				//Retrieve all groupss and set them in the form
				apprenticeModifyForm.setGroups((List<GroupEnum>)emagineEnumManager.findAll(GroupEnum.class));

				//Retrieve all courseOptions and set them in the form
				apprenticeModifyForm.setCourseOptions((List<CourseOptionEnum>)emagineEnumManager.findAll(CourseOptionEnum.class));
				
				//Retrieve all firms and set them in the form
				apprenticeModifyForm.setFirms(managerManager.getFirmManager().findAll());
				
				//Retrieve all tutors engineers of the firm and set them in the form
				apprenticeModifyForm.setEngineerTutors(managerManager.getEngineerTutorManager().findAll());
				
				//Retrieve all tutors teachers and set them in the form
				apprenticeModifyForm.setTeacherTutors(managerManager.getTeacherTutorManager().findAll());
			
				//Retrieve all diplomas and set them in the form
				apprenticeModifyForm.setDiplomas((List<DiplomaEnum>)emagineEnumManager.findAll(DiplomaEnum.class));

				//Retrieve all years of obtention diploms and set them in the form
				apprenticeModifyForm.setObtentionYears((List<YearObtentionEnum>)emagineEnumManager.findAll(YearObtentionEnum.class));

				//Retrieve all sections and set them in the form
				apprenticeModifyForm.setSections((List<SectionEnum>)emagineEnumManager.findAll(SectionEnum.class));

				//Retrieve all level entry and set them in the form
				apprenticeModifyForm.setLevels((List<LevelEntryEnum>)emagineEnumManager.findAll(LevelEntryEnum.class));
				
				//Retrieve all languages and set them in the form
				apprenticeModifyForm.setLanguages((List<LanguageEnum>)emagineEnumManager.findAll(LanguageEnum.class));

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
		EngineerTutorManager engineerTutorManager = managerManager.getEngineerTutorManager();
		TeacherTutorManager teacherTutorManager = managerManager.getTeacherTutorManager();
		FirmManager firmManager = managerManager.getFirmManager();
		
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
		
			/* Datas concerning the status tab*/
			apprentice.setFirstName(apprenticeModifyForm.getFirstName());
			apprentice.setLastName(apprenticeModifyForm.getLastName());
			apprentice.setSex((SexEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdSex()), SexEnum.class));
			System.out.println("avant formatage :"+apprenticeModifyForm.getBirth());
			apprentice.setBirthdayDate(stringToDate(apprenticeModifyForm.getBirth()));
			System.out.println("apres formatage :"+stringToDate(apprenticeModifyForm.getBirth()));
			apprentice.setBirthdayCountry((CountryEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdCountry()), CountryEnum.class));
			apprentice.setNationality((NationalityEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdNationality()), NationalityEnum.class));
			apprentice.setBirthdayCity(apprenticeModifyForm.getCity());
			apprentice.setBirthdayDepartment((DepartmentEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdDepartmentBirth()), DepartmentEnum.class));
			apprentice.setProfessionMother((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdMother()), ProfessionEnum.class));
			apprentice.setProfessionFather((ProfessionEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdFather()), ProfessionEnum.class));
			apprentice.setContactOriginIG2K((ContactEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdContact()), ContactEnum.class));

			/* Datas concerning the situation tab*/
			apprentice.setCourseOption((CourseOptionEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdCourseOption()), CourseOptionEnum.class));
			apprentice.setYear((YearEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdYear()), YearEnum.class));
			apprentice.setGroup((GroupEnum) emagineEnumManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdGroup()), GroupEnum.class));
			
			apprentice.setFirm(firmManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdFirm())));
			apprentice.setEngineerTutor(engineerTutorManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdEngineerTutor())));
			apprentice.setTeacherTutor(teacherTutorManager.retrieve(Long.parseLong(apprenticeModifyForm.getIdTeacherTutor())));
			
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
