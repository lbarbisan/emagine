package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.candidate.ContactEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.DiplomaEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.ProfessionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.SectionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.YearObtentionEnum;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;

public class ApprenticeModifyForm extends ActionForm {

	private static final long serialVersionUID = -1120295787399332929L;
	
	/** Identifier of absence to modify **/
	//private String idAbsenceToModify;
	
	/** Identifier of aprentice to modify **/
	private String idApprenticeToModify;
	
	/** Use to action **/
	private String action;
	
	/** selected table **/
	private String tab;
	
	/*****************************************
	 *
	 * Part of the form concerned by the adress tab :
	 * 
	******************************************/
	

	/** List of all of possibilities default adresses **/
	private Collection <DefaultAddressEnum> defaultAddresses;
	
	/** Identifier of selected adress **/
	private String idDefaultAddress;

	/** personnal adress **/
	private String persAddress;
	
	/** personnal postal code **/
	private String persPostalCode;

	/** personnal city **/
	private String persCity;
	
	/** personnal department **/
	private String idPersDepartment;

	/** personnal phone **/
	private String persPhone;

	/** personnal mobile phone **/
	private String persMobile;

	/** personnal fax **/
	private String persFax;

	/** personnal eMail **/
	private String persEmail;
	
	/** professional adress **/
	private String profAddress;
	
	/** professional postal code **/
	private String profPostalCode;

	/** professional city **/
	private String profCity;
	
	/** professional department **/
	private String idProfDepartment;

	/** professional phone **/
	private String profPhone;

	/** professional mobile phone **/
	private String profMobile;

	/** professional fax **/
	private String profFax;

	/** professional eMail **/
	private String profEmail;

	/** academic adress **/
	private String acaAddress;
	
	/** academic postal code **/
	private String acaPostalCode;

	/** academic city **/
	private String acaCity;
	
	/** academic department **/
	private String idAcaDepartment;

	/** academic phone **/
	private String acaPhone;

	/** academic mobile phone **/
	private String acaMobile;

	/** academic fax **/
	private String acaFax;

	/** academic eMail **/
	private String acaEmail;

	/** all the departments **/
	private Collection <DepartmentEnum> departments;
	
	/*****************************************
	 *
	 * Part of the form for the situation tab :
	 * 
	******************************************/
	
	/** List of all of course options **/
	private Collection <CourseOptionEnum> courseOptions;
	
	/** Identifier of selected course option **/
	private String idCourseOption;

	/** List of all of course options **/
	private Collection <YearEnum> years;

	/** Identifier of selected year **/
	private String idYear;
	
	/** List of all of course options **/
	private Collection <GroupEnum> groups;
	
	/** Identifier of selected groupe **/
	private String idGroup;
	
	/** List of all of firms **/
	private Collection <Firm> firms;
	
	/** Identifier of selected firm **/
	private String idFirm;
	
	/** List of all of engineer tutors **/
	private Collection <EngineerTutor> engineerTutors;
	
	/** Identifier of selected engineer tutors **/
	private String idEngineerTutor;
	
	/** List of all of teacher tutors **/
	private Collection <TeacherTutor> teacherTutors;
	
	/** Identifier of selected teacher tutors **/
	private String idTeacherTutor;
	
	/*****************************************
	 *
	 * Part of the form for the schooling tab :
	 * 
	******************************************/
	
	/** List of all of levels **/
	private Collection <LevelEntryEnum> levels;
	
	/** Identifier of selected level **/
	private String idLevel;
	
	/** List of all of languages **/
	private Collection <LanguageEnum> languages;
	
	/** Identifier of selected language **/
	private String idLanguage1;
	
	/** Identifier of selected language 2 **/
	private String idLanguage2;

	//TODO gestion de note
	/** List of all marks of the apprentice **/
	//private Collection <Mark> marks;
	
	/** Identifier of selected level **/
	//private String idMark;
	
	/** first mark at exams of the candidate become apprentice**/
	private String firstMarkExam;
	
	/** second mark at exams of the candidate become apprentice**/
	private String secondMarkExam;
	
	/** third mark at exams of the candidate become apprentice**/
	private String thirdMarkExam;
	
	/** List of all of diplomas **/
	private Collection <DiplomaEnum> diplomas;
	
	/** Identifier of selected diploma1 **/
	private String idDiploma1;
	
	/** Identifier of selected diploma2 **/
	private String idDiploma2;
	
	/** Identifier of selected diploma3 **/
	private String idDiploma3;

	/** List of all of diplomas **/
	private Collection <YearObtentionEnum> obtentionYears;
	
	/** Identifier of selected year of diploma1 **/
	private String idYearDiploma1;
	
	/** Identifier of selected year of diploma2 **/
	private String idYearDiploma2;
	
	/** Identifier of selected year diploma3 **/
	private String idYearDiploma3;
	
	/** List of all of sections **/
	private Collection <SectionEnum> sections;
	
	/** Identifier of selected section **/
	private String idSection1;
	
	/** Identifier of selected section **/
	private String idSection2;
	
	/** Identifier of selected section **/
	private String idSection3;
	
	/** Identifier of selected department **/
	private String idSchoolDepartment1;
	
	/** Identifier of selected department **/
	private String idSchoolDepartment2;
	
	/** Identifier of selected department **/
	private String idSchoolDepartment3;
	
	/** establishment of schooling **/
	private String establishment1;
	
	/** establishment of schooling **/
	private String establishment2;
	
	/** establishment of schooling **/
	private String establishment3;
	
	
	/*****************************************
	 *
	 * Part of the form for the status tab :
	 * 
	******************************************/
	
	/** apprentice firstname **/
	private String firstName;
	
	/** apprentice lastname **/
	private String lastName;

	/** List of all sexes **/
	private Collection <SexEnum> sexes;
	
	/** Identifier of selected sex **/
	private String idSex;

	/** apprentice date of birth **/
	private String birth;
	
	/** Identifier of selected department birth **/
	private String idDepartmentBirth;
	
	/** candidate city of birth **/
	private String city;
	
	/** List of all countries **/
	private Collection <CountryEnum> countries;
	
	/** Identifier of selected country **/
	private String idCountry;
	
	/** List of all nationalities **/
	private Collection <NationalityEnum> nationalities;
	
	/** Identifier of selected nationality **/
	private String idNationality;
	
	/** List of all professions **/
	private Collection <ProfessionEnum> professions;
	
	/** Identifier of selected profession of the mother **/
	private String idMother;

	/** Identifier of selected profession of the father **/
	private String idFather;

	/** List of all contacts **/
	private Collection <ContactEnum> contacts;
	
	/** Identifier of selected contact **/
	private String idContact;	
	
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			//situation
			if ("".equals(idCourseOption) || "".equals(idYear) || "".equals(idGroup) || "".equals(idTeacherTutor) || "".equals(idFirm) || "".equals(idEngineerTutor)){
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}			
			//TODO schooling !!
			//status
			if ("".equals(lastName) || "".equals(firstName) || "".equals(idNationality)){
				
			}
			//address
			if ("".equals(lastName) || "".equals(firstName) || "".equals(idNationality)){
				
			}
		}
		return errors;
	}


	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		persAddress = "";
		persCity = "";
		idPersDepartment = "";
		persEmail ="";
		persFax = "";
		persMobile = "";
		persPhone ="";
		persPostalCode = "";
		profAddress = "";
		profCity = "";
		idProfDepartment = "";
		profEmail ="";
		profFax = "";
		profMobile = "";
		profPhone ="";
		profPostalCode = "";
		acaAddress = "";
		acaCity = "";
		idAcaDepartment = "";
		acaEmail ="";
		acaFax = "";
		acaMobile = "";
		acaPhone ="";
		acaPostalCode = "";
		action = "";
		firstName="";
		lastName="";
		sexes = null;
		idSex="";
		birth="";
		idDepartmentBirth="";
		city="";
		countries=null;
		idCountry="";
		nationalities=null;
		idNationality="";
		professions=null;
		idMother="";
		idFather="";
		contacts=null;
		idContact="";
		establishment1="";
		idSchoolDepartment1="";
		establishment2="";
		idSchoolDepartment2="";
		establishment3="";
		idSchoolDepartment3="";	
		idApprenticeToModify = "";
		tab="";
	}

	/**
	 * @return Returns the acaAdress.
	 */
	public String getAcaAddress() {
		return acaAddress;
	}

	/**
	 * @param acaAdress The acaAdress to set.
	 */
	public void setAcaAddress(String acaAddress) {
		this.acaAddress = acaAddress;
	}

	/**
	 * @return Returns the acaCity.
	 */
	public String getAcaCity() {
		return acaCity;
	}

	/**
	 * @param acaCity The acaCity to set.
	 */
	public void setAcaCity(String acaCity) {
		this.acaCity = acaCity;
	}

	/**
	 * @return Returns the acaEmail.
	 */
	public String getAcaEmail() {
		return acaEmail;
	}

	/**
	 * @param acaEmail The acaEmail to set.
	 */
	public void setAcaEmail(String acaEmail) {
		this.acaEmail = acaEmail;
	}

	/**
	 * @return Returns the acaFax.
	 */
	public String getAcaFax() {
		return acaFax;
	}

	/**
	 * @param acaFax The acaFax to set.
	 */
	public void setAcaFax(String acaFax) {
		this.acaFax = acaFax;
	}

	/**
	 * @return Returns the acaMobile.
	 */
	public String getAcaMobile() {
		return acaMobile;
	}

	/**
	 * @param acaMobile The acaMobile to set.
	 */
	public void setAcaMobile(String acaMobile) {
		this.acaMobile = acaMobile;
	}

	/**
	 * @return Returns the acaPhone.
	 */
	public String getAcaPhone() {
		return acaPhone;
	}

	/**
	 * @param acaPhone The acaPhone to set.
	 */
	public void setAcaPhone(String acaPhone) {
		this.acaPhone = acaPhone;
	}

	/**
	 * @return Returns the acaPostalCode.
	 */
	public String getAcaPostalCode() {
		return acaPostalCode;
	}

	/**
	 * @param acaPostalCode The acaPostalCode to set.
	 */
	public void setAcaPostalCode(String acaPostalCode) {
		this.acaPostalCode = acaPostalCode;
	}

	/**
	 * @return Returns the action.
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action The action to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}


	/**
	 * @return Returns the departments.
	 */
	public Collection<DepartmentEnum> getDepartments() {
		return departments;
	}

	/**
	 * @param departments The departments to set.
	 */
	public void setDepartments(Collection<DepartmentEnum> departments) {
		this.departments = departments;
	}


	/**
	 * @return Returns the idAbsenceToModify.
	 */
	//public String getIdAbsenceToModify() {
	//	return idAbsenceToModify;
	//}

	/**
	 * @param idAbsenceToModify The idAbsenceToModify to set.
	 */
	//public void setIdAbsenceToModify(String idAbsenceToModify) {
	//	this.idAbsenceToModify = idAbsenceToModify;
	//}

	/**
	 * @return Returns the idAcaDepartment.
	 */
	public String getIdAcaDepartment() {
		return idAcaDepartment;
	}

	/**
	 * @param idAcaDepartment The idAcaDepartment to set.
	 */
	public void setIdAcaDepartment(String idAcaDepartment) {
		this.idAcaDepartment = idAcaDepartment;
	}

	/**
	 * @return Returns the idApprenticeToModify.
	 */
	public String getIdApprenticeToModify() {
		return idApprenticeToModify;
	}

	/**
	 * @param idApprenticeToModify The idApprenticeToModify to set.
	 */
	public void setIdApprenticeToModify(String idApprenticeToModify) {
		this.idApprenticeToModify = idApprenticeToModify;
	}


	/**
	 * @return Returns the idPersDepartment.
	 */
	public String getIdPersDepartment() {
		return idPersDepartment;
	}

	/**
	 * @param idPersDepartment The idPersDepartment to set.
	 */
	public void setIdPersDepartment(String idPersDepartment) {
		this.idPersDepartment = idPersDepartment;
	}

	/**
	 * @return Returns the idProfDepartment.
	 */
	public String getIdProfDepartment() {
		return idProfDepartment;
	}

	/**
	 * @param idProfDepartment The idProfDepartment to set.
	 */
	public void setIdProfDepartment(String idProfDepartment) {
		this.idProfDepartment = idProfDepartment;
	}

	/**
	 * @return Returns the persAdress.
	 */
	public String getPersAddress() {
		return persAddress;
	}

	/**
	 * @param persAdress The persAdress to set.
	 */
	public void setPersAddress(String persAddress) {
		this.persAddress = persAddress;
	}

	/**
	 * @return Returns the persCity.
	 */
	public String getPersCity() {
		return persCity;
	}

	/**
	 * @param persCity The persCity to set.
	 */
	public void setPersCity(String persCity) {
		this.persCity = persCity;
	}

	/**
	 * @return Returns the persEmail.
	 */
	public String getPersEmail() {
		return persEmail;
	}

	/**
	 * @param persEmail The persEmail to set.
	 */
	public void setPersEmail(String persEmail) {
		this.persEmail = persEmail;
	}

	/**
	 * @return Returns the persFax.
	 */
	public String getPersFax() {
		return persFax;
	}

	/**
	 * @param persFax The persFax to set.
	 */
	public void setPersFax(String persFax) {
		this.persFax = persFax;
	}

	/**
	 * @return Returns the persMobile.
	 */
	public String getPersMobile() {
		return persMobile;
	}

	/**
	 * @param persMobile The persMobile to set.
	 */
	public void setPersMobile(String persMobile) {
		this.persMobile = persMobile;
	}

	/**
	 * @return Returns the persPhone.
	 */
	public String getPersPhone() {
		return persPhone;
	}

	/**
	 * @param persPhone The persPhone to set.
	 */
	public void setPersPhone(String persPhone) {
		this.persPhone = persPhone;
	}

	/**
	 * @return Returns the persPostalCode.
	 */
	public String getPersPostalCode() {
		return persPostalCode;
	}

	/**
	 * @param persPostalCode The persPostalCode to set.
	 */
	public void setPersPostalCode(String persPostalCode) {
		this.persPostalCode = persPostalCode;
	}

	/**
	 * @return Returns the profAdress.
	 */
	public String getProfAddress() {
		return profAddress;
	}

	/**
	 * @param profAdress The profAdress to set.
	 */
	public void setProfAddress(String profAddress) {
		this.profAddress = profAddress;
	}

	/**
	 * @return Returns the profCity.
	 */
	public String getProfCity() {
		return profCity;
	}

	/**
	 * @param profCity The profCity to set.
	 */
	public void setProfCity(String profCity) {
		this.profCity = profCity;
	}

	/**
	 * @return Returns the profEmail.
	 */
	public String getProfEmail() {
		return profEmail;
	}

	/**
	 * @param profEmail The profEmail to set.
	 */
	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}

	/**
	 * @return Returns the profFax.
	 */
	public String getProfFax() {
		return profFax;
	}

	/**
	 * @param profFax The profFax to set.
	 */
	public void setProfFax(String profFax) {
		this.profFax = profFax;
	}

	/**
	 * @return Returns the profMobile.
	 */
	public String getProfMobile() {
		return profMobile;
	}

	/**
	 * @param profMobile The profMobile to set.
	 */
	public void setProfMobile(String profMobile) {
		this.profMobile = profMobile;
	}

	/**
	 * @return Returns the profPhone.
	 */
	public String getProfPhone() {
		return profPhone;
	}

	/**
	 * @param profPhone The profPhone to set.
	 */
	public void setProfPhone(String profPhone) {
		this.profPhone = profPhone;
	}

	/**
	 * @return Returns the profPostalCode.
	 */
	public String getProfPostalCode() {
		return profPostalCode;
	}

	/**
	 * @param profPostalCode The profPostalCode to set.
	 */
	public void setProfPostalCode(String profPostalCode) {
		this.profPostalCode = profPostalCode;
	}

	/**
	 * @return Returns the defaultAddresses.
	 */
	public Collection<DefaultAddressEnum> getDefaultAddresses() {
		return defaultAddresses;
	}

	/**
	 * @param defaultAddresses The defaultAddresses to set.
	 */
	public void setDefaultAddresses(Collection<DefaultAddressEnum> defaultAddresses) {
		this.defaultAddresses = defaultAddresses;
	}

	/**
	 * @return Returns the idDefaultAddress.
	 */
	public String getIdDefaultAddress() {
		return idDefaultAddress;
	}

	/**
	 * @param idDefaultAddress The idDefaultAddress to set.
	 */
	public void setIdDefaultAddress(String idDefaultAddress) {
		this.idDefaultAddress = idDefaultAddress;
	}

	/**
	 * @return Returns the birth.
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth The birth to set.
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return Returns the countries.
	 */
	public Collection<CountryEnum> getCountries() {
		return countries;
	}

	/**
	 * @param countries The countries to set.
	 */
	public void setCountries(Collection<CountryEnum> countries) {
		this.countries = countries;
	}

	/**
	 * @return Returns the courseOptions.
	 */
	public Collection<CourseOptionEnum> getCourseOptions() {
		return courseOptions;
	}

	/**
	 * @param courseOptions The courseOptions to set.
	 */
	public void setCourseOptions(Collection<CourseOptionEnum> courseOptions) {
		this.courseOptions = courseOptions;
	}

	/**
	 * @return Returns the diplomas.
	 */
	public Collection<DiplomaEnum> getDiplomas() {
		return diplomas;
	}

	/**
	 * @param diplomas The diplomas to set.
	 */
	public void setDiplomas(Collection<DiplomaEnum> diplomas) {
		this.diplomas = diplomas;
	}

	/**
	 * @return Returns the engineerTutors.
	 */
	public Collection<EngineerTutor> getEngineerTutors() {
		return engineerTutors;
	}

	/**
	 * @param engineerTutors The engineerTutors to set.
	 */
	public void setEngineerTutors(Collection<EngineerTutor> engineerTutors) {
		this.engineerTutors = engineerTutors;
	}

	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return Returns the idCountry.
	 */
	public String getIdCountry() {
		return idCountry;
	}

	/**
	 * @param idCountry The idCountry to set.
	 */
	public void setIdCountry(String idCountry) {
		this.idCountry = idCountry;
	}

	/**
	 * @return Returns the idCourseOption.
	 */
	public String getIdCourseOption() {
		return idCourseOption;
	}

	/**
	 * @param idCourseOption The idCourseOption to set.
	 */
	public void setIdCourseOption(String idCourseOption) {
		this.idCourseOption = idCourseOption;
	}

	/**
	 * @return Returns the idEngineerTutor.
	 */
	public String getIdEngineerTutor() {
		return idEngineerTutor;
	}

	/**
	 * @param idEngineerTutor The idEngineerTutor to set.
	 */
	public void setIdEngineerTutor(String idEngineerTutor) {
		this.idEngineerTutor = idEngineerTutor;
	}

	/**
	 * @return Returns the idFather.
	 */
	public String getIdFather() {
		return idFather;
	}

	/**
	 * @param idFather The idFather to set.
	 */
	public void setIdFather(String idFather) {
		this.idFather = idFather;
	}

	/**
	 * @return Returns the idGroup.
	 */
	public String getIdGroup() {
		return idGroup;
	}

	/**
	 * @param idGroup The idGroup to set.
	 */
	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}

	/**
	 * @return Returns the idLevel.
	 */
	public String getIdLevel() {
		return idLevel;
	}

	/**
	 * @param idLevel The idLevel to set.
	 */
	public void setIdLevel(String idLevel) {
		this.idLevel = idLevel;
	}

	/**
	 * @return Returns the idMother.
	 */
	public String getIdMother() {
		return idMother;
	}

	/**
	 * @param idMother The idMother to set.
	 */
	public void setIdMother(String idMother) {
		this.idMother = idMother;
	}

	/**
	 * @return Returns the idNationality.
	 */
	public String getIdNationality() {
		return idNationality;
	}

	/**
	 * @param idNationality The idNationality to set.
	 */
	public void setIdNationality(String idNationality) {
		this.idNationality = idNationality;
	}

	/**
	 * @return Returns the idSex.
	 */
	public String getIdSex() {
		return idSex;
	}

	/**
	 * @param idSex The idSex to set.
	 */
	public void setIdSex(String idSex) {
		this.idSex = idSex;
	}

	/**
	 * @return Returns the idYear.
	 */
	public String getIdYear() {
		return idYear;
	}

	/**
	 * @param idYear The idYear to set.
	 */
	public void setIdYear(String idYear) {
		this.idYear = idYear;
	}

	/**
	 * @return Returns the languages.
	 */
	public Collection<LanguageEnum> getLanguages() {
		return languages;
	}

	/**
	 * @param languages The languages to set.
	 */
	public void setLanguages(Collection<LanguageEnum> languages) {
		this.languages = languages;
	}

	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Returns the levels.
	 */
	public Collection<LevelEntryEnum> getLevels() {
		return levels;
	}

	/**
	 * @param levels The levels to set.
	 */
	public void setLevels(Collection<LevelEntryEnum> levels) {
		this.levels = levels;
	}

	/**
	 * @return Returns the nationalities.
	 */
	public Collection<NationalityEnum> getNationalities() {
		return nationalities;
	}

	/**
	 * @param nationalities The nationalities to set.
	 */
	public void setNationalities(Collection<NationalityEnum> nationalities) {
		this.nationalities = nationalities;
	}

	/**
	 * @return Returns the professions.
	 */
	public Collection<ProfessionEnum> getProfessions() {
		return professions;
	}

	/**
	 * @param professions The professions to set.
	 */
	public void setProfessions(Collection<ProfessionEnum> professions) {
		this.professions = professions;
	}

	/**
	 * @return Returns the sections.
	 */
	public Collection<SectionEnum> getSections() {
		return sections;
	}

	/**
	 * @param sections The sections to set.
	 */
	public void setSections(Collection<SectionEnum> sections) {
		this.sections = sections;
	}

	/**
	 * @return Returns the sexes.
	 */
	public Collection<SexEnum> getSexes() {
		return sexes;
	}

	/**
	 * @param sexes The sexes to set.
	 */
	public void setSexes(Collection<SexEnum> sexes) {
		this.sexes = sexes;
	}

	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return Returns the idDepartmentBirth.
	 */
	public String getIdDepartmentBirth() {
		return idDepartmentBirth;
	}

	/**
	 * @param idDepartmentBirth The idDepartmentBirth to set.
	 */
	public void setIdDepartmentBirth(String idDepartmentBirth) {
		this.idDepartmentBirth = idDepartmentBirth;
	}

	/**
	 * @return Returns the contacts.
	 */
	public Collection<ContactEnum> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts The contacts to set.
	 */
	public void setContacts(Collection<ContactEnum> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return Returns the idContact.
	 */
	public String getIdContact() {
		return idContact;
	}

	/**
	 * @param idContact The idContact to set.
	 */
	public void setIdContact(String idContact) {
		this.idContact = idContact;
	}

	/**
	 * @return Returns the groups.
	 */
	public Collection<GroupEnum> getGroups() {
		return groups;
	}

	/**
	 * @param groups The groups to set.
	 */
	public void setGroups(Collection<GroupEnum> groups) {
		this.groups = groups;
	}

	/**
	 * @return Returns the years.
	 */
	public Collection<YearEnum> getYears() {
		return years;
	}

	/**
	 * @param years The years to set.
	 */
	public void setYears(Collection<YearEnum> years) {
		this.years = years;
	}
	
	/**
	 * @return Returns the firms.
	 */
	public Collection<Firm> getFirms() {
		return firms;
	}

	/**
	 * @param firms The firms to set.
	 */
	public void setFirms(Collection<Firm> firms) {
		this.firms = firms;
	}

	/**
	 * @return Returns the idFirm.
	 */
	public String getIdFirm() {
		return idFirm;
	}

	/**
	 * @param idFirm The idFirm to set.
	 */
	public void setIdFirm(String idFirm) {
		this.idFirm = idFirm;
	}

	/**
	 * @return Returns the idTeacherTutor.
	 */
	public String getIdTeacherTutor() {
		return idTeacherTutor;
	}

	/**
	 * @param idTeacherTutor The idTeacherTutor to set.
	 */
	public void setIdTeacherTutor(String idTeacherTutor) {
		this.idTeacherTutor = idTeacherTutor;
	}

	/**
	 * @return Returns the teacherTutors.
	 */
	public Collection<TeacherTutor> getTeacherTutors() {
		return teacherTutors;
	}

	/**
	 * @param teacherTutors The teacherTutors to set.
	 */
	public void setTeacherTutors(Collection<TeacherTutor> teacherTutors) {
		this.teacherTutors = teacherTutors;
	}

	/**
	 * @return Returns the idLanguage1.
	 */
	public String getIdLanguage1() {
		return idLanguage1;
	}

	/**
	 * @param idLanguage1 The idLanguage1 to set.
	 */
	public void setIdLanguage1(String idLanguage1) {
		this.idLanguage1 = idLanguage1;
	}

	/**
	 * @return Returns the idLanguage2.
	 */
	public String getIdLanguage2() {
		return idLanguage2;
	}

	/**
	 * @param idLanguage2 The idLanguage2 to set.
	 */
	public void setIdLanguage2(String idLanguage2) {
		this.idLanguage2 = idLanguage2;
	}

	/**
	 * @return Returns the firstMarkExam.
	 */
	public String getFirstMarkExam() {
		return firstMarkExam;
	}

	/**
	 * @param firstMarkExam The firstMarkExam to set.
	 */
	public void setFirstMarkExam(String firstMarkExam) {
		this.firstMarkExam = firstMarkExam;
	}

	/**
	 * @return Returns the secondMarkExam.
	 */
	public String getSecondMarkExam() {
		return secondMarkExam;
	}

	/**
	 * @param secondMarkExam The secondMarkExam to set.
	 */
	public void setSecondMarkExam(String secondMarkExam) {
		this.secondMarkExam = secondMarkExam;
	}

	/**
	 * @return Returns the thirdMarkExam.
	 */
	public String getThirdMarkExam() {
		return thirdMarkExam;
	}

	/**
	 * @param thirdMarkExam The thirdMarkExam to set.
	 */
	public void setThirdMarkExam(String thirdMarkExam) {
		this.thirdMarkExam = thirdMarkExam;
	}

	/**
	 * @return Returns the idDiploma1.
	 */
	public String getIdDiploma1() {
		return idDiploma1;
	}

	/**
	 * @param idDiploma1 The idDiploma1 to set.
	 */
	public void setIdDiploma1(String idDiploma1) {
		this.idDiploma1 = idDiploma1;
	}

	/**
	 * @return Returns the idDiploma2.
	 */
	public String getIdDiploma2() {
		return idDiploma2;
	}

	/**
	 * @param idDiploma2 The idDiploma2 to set.
	 */
	public void setIdDiploma2(String idDiploma2) {
		this.idDiploma2 = idDiploma2;
	}

	/**
	 * @return Returns the idDiploma3.
	 */
	public String getIdDiploma3() {
		return idDiploma3;
	}

	/**
	 * @param idDiploma3 The idDiploma3 to set.
	 */
	public void setIdDiploma3(String idDiploma3) {
		this.idDiploma3 = idDiploma3;
	}

	/**
	 * @return Returns the idYearDiploma1.
	 */
	public String getIdYearDiploma1() {
		return idYearDiploma1;
	}

	/**
	 * @param idYearDiploma1 The idYearDiploma1 to set.
	 */
	public void setIdYearDiploma1(String idYearDiploma1) {
		this.idYearDiploma1 = idYearDiploma1;
	}

	/**
	 * @return Returns the idYearDiploma2.
	 */
	public String getIdYearDiploma2() {
		return idYearDiploma2;
	}

	/**
	 * @param idYearDiploma2 The idYearDiploma2 to set.
	 */
	public void setIdYearDiploma2(String idYearDiploma2) {
		this.idYearDiploma2 = idYearDiploma2;
	}

	/**
	 * @return Returns the idYearDiploma3.
	 */
	public String getIdYearDiploma3() {
		return idYearDiploma3;
	}

	/**
	 * @param idYearDiploma3 The idYearDiploma3 to set.
	 */
	public void setIdYearDiploma3(String idYearDiploma3) {
		this.idYearDiploma3 = idYearDiploma3;
	}

	/**
	 * @return Returns the obtentionYears.
	 */
	public Collection<YearObtentionEnum> getObtentionYears() {
		return obtentionYears;
	}

	/**
	 * @param obtentionYears The obtentionYears to set.
	 */
	public void setObtentionYears(Collection<YearObtentionEnum> obtentionYears) {
		this.obtentionYears = obtentionYears;
	}

	/**
	 * @return Returns the idSection1.
	 */
	public String getIdSection1() {
		return idSection1;
	}

	/**
	 * @param idSection1 The idSection1 to set.
	 */
	public void setIdSection1(String idSection1) {
		this.idSection1 = idSection1;
	}

	/**
	 * @return Returns the idSection2.
	 */
	public String getIdSection2() {
		return idSection2;
	}

	/**
	 * @param idSection2 The idSection2 to set.
	 */
	public void setIdSection2(String idSection2) {
		this.idSection2 = idSection2;
	}

	/**
	 * @return Returns the idSection3.
	 */
	public String getIdSection3() {
		return idSection3;
	}

	/**
	 * @param idSection3 The idSection3 to set.
	 */
	public void setIdSection3(String idSection3) {
		this.idSection3 = idSection3;
	}

	/**
	 * @return Returns the establishment1.
	 */
	public String getEstablishment1() {
		return establishment1;
	}

	/**
	 * @param establishment1 The establishment1 to set.
	 */
	public void setEstablishment1(String establishment1) {
		this.establishment1 = establishment1;
	}

	/**
	 * @return Returns the establishment2.
	 */
	public String getEstablishment2() {
		return establishment2;
	}

	/**
	 * @param establishment2 The establishment2 to set.
	 */
	public void setEstablishment2(String establishment2) {
		this.establishment2 = establishment2;
	}

	/**
	 * @return Returns the establishment3.
	 */
	public String getEstablishment3() {
		return establishment3;
	}

	/**
	 * @param establishment3 The establishment3 to set.
	 */
	public void setEstablishment3(String establishment3) {
		this.establishment3 = establishment3;
	}

	/**
	 * @return Returns the idSchoolDepartment1.
	 */
	public String getIdSchoolDepartment1() {
		return idSchoolDepartment1;
	}

	/**
	 * @param idSchoolDepartment1 The idSchoolDepartment1 to set.
	 */
	public void setIdSchoolDepartment1(String idSchoolDepartment1) {
		this.idSchoolDepartment1 = idSchoolDepartment1;
	}

	/**
	 * @return Returns the idSchoolDepartment2.
	 */
	public String getIdSchoolDepartment2() {
		return idSchoolDepartment2;
	}

	/**
	 * @param idSchoolDepartment2 The idSchoolDepartment2 to set.
	 */
	public void setIdSchoolDepartment2(String idSchoolDepartment2) {
		this.idSchoolDepartment2 = idSchoolDepartment2;
	}

	/**
	 * @return Returns the idSchoolDepartment3.
	 */
	public String getIdSchoolDepartment3() {
		return idSchoolDepartment3;
	}

	/**
	 * @param idSchoolDepartment3 The idSchoolDepartment3 to set.
	 */
	public void setIdSchoolDepartment3(String idSchoolDepartment3) {
		this.idSchoolDepartment3 = idSchoolDepartment3;
	}


	/**
	 * @return Returns the tab.
	 */
	public String getTab() {
		return tab;
	}


	/**
	 * @param tab The tab to set.
	 */
	public void setTab(String tab) {
		this.tab = tab;
	}

}
