package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.DiplomaEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.ProfessionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.SectionEnum;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;

public class ApprenticeModifyForm extends ActionForm {

	private static final long serialVersionUID = -1120295787399332929L;
	
	/*****************************************
	 *
	 * Part of the form concerned by the absence tab :
	 * 
	******************************************/
	
	/** Identifier of candidate to modify **/
	private String idAbsenceToModify;
	
	/** absence initial date **/
	private String initDate;
	
	/** absence end date **/
	private String endDate;
	
	/** absence number of days **/
	private String nbDays;
	
	/** List of all justifications **/
	//TODO private Collection <JustificationEnum> justifications;
	
	/** Identifier of selected justification **/
	private String idJustification;

	/** absence comment **/
	private String comment ;

	/*****************************************
	 *
	 * Part of the form concerned by the adress tab :
	 * 
	******************************************/
	
	/** Identifier of candidate to modify **/
	private String idApprenticeToModify;
	
	/** List of all of possibilities default adresses **/
	private Collection <DefaultAddressEnum> defaultAddresses;
	
	/** Identifier of selected adress **/
	private String idDefaultAddress;

	/** personnal adress **/
	private String persAdress;
	
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
	private String profAdress;
	
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
	private String acaAdress;
	
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
	private String idLanguage;
	
	/** List of all of diplomas **/
	private Collection <DiplomaEnum> diplomas;
	
	/** Identifier of selected diploma **/
	private String idDiploma;
	
	/** List of all of sections **/
	private Collection <SectionEnum> sections;
	
	/** Identifier of selected section **/
	private String idSection;
	
	//TODO : comprendre l'interface graphique 
	
	/*****************************************
	 *
	 * Part of the form for the situation tab :
	 * 
	******************************************/
	
	/** List of all of course options **/
	private Collection <CourseOptionEnum> courseOptions;
	
	/** Identifier of selected course option **/
	private String idCourseOption;

	/** Identifier of selected year **/
	private String idYear;
	
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
	 * Part of the form for the status tab :
	 * 
	******************************************/
	
	/** apprentice firstname **/
	private String firstName;
	
	/** apprentice lastname **/
	private String lastName;

	/** apprentice date of birth **/
	private String birth;
	
	/** Identifier of selected department **/
	private String idDepartment;
	
	/** List of all sexes **/
	private Collection <SexEnum> sexes;
	
	/** Identifier of selected sexe **/
	private String idSex;
	
	/** List of all professions **/
	private Collection <ProfessionEnum> professions;
	
	/** Identifier of selected profession of the mother **/
	private String idMother;

	/** Identifier of selected profession of the father **/
	private String idFather;
	
	/** List of all countries **/
	private Collection <CountryEnum> countries;
	
	/** Identifier of selected country **/
	private String idCountry;
	
	/** List of all nationalities **/
	private Collection <NationalityEnum> nationalities;
	
	/** Identifier of selected nationality **/
	private String idNationality;

	/** Use to action **/
	private String action;

	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(initDate) || "".equals(endDate) || "".equals(idJustification)){
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}
			else {
			/* TODO if (!isValide(initDate) || !isValide(endDate) ){
				errors.add("wrongDateFormat", new ActionMessage("candidate.error.wrongDateFormat"));
				}
			*/
			}
		}

		return errors;
	}

/*	private boolean isValide(String date) {
		//FIXME créer une méthode vérifiant le format
	}
*/

	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		initDate = ""; //TODO mettre la date du jour ?
		endDate = ""; //TODO mettre la date du jour ?
		nbDays = "";
		//justifications = null;
		idJustification = "";
		comment = "";
		persAdress = "";
		persCity = "";
		idPersDepartment = "";
		persEmail ="";
		persFax = "";
		persMobile = "";
		persPhone ="";
		persPostalCode = "";
		profAdress = "";
		profCity = "";
		idProfDepartment = "";
		profEmail ="";
		profFax = "";
		profMobile = "";
		profPhone ="";
		profPostalCode = "";
		acaAdress = "";
		acaCity = "";
		idAcaDepartment = "";
		acaEmail ="";
		acaFax = "";
		acaMobile = "";
		acaPhone ="";
		acaPostalCode = "";
		action = "";
		idAbsenceToModify = "";
		idApprenticeToModify = "";
	}

	/**
	 * @return Returns the acaAdress.
	 */
	public String getAcaAdress() {
		return acaAdress;
	}

	/**
	 * @param acaAdress The acaAdress to set.
	 */
	public void setAcaAdress(String acaAdress) {
		this.acaAdress = acaAdress;
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
	 * @return Returns the comment.
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment The comment to set.
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return Returns the endDate.
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return Returns the idAbsenceToModify.
	 */
	public String getIdAbsenceToModify() {
		return idAbsenceToModify;
	}

	/**
	 * @param idAbsenceToModify The idAbsenceToModify to set.
	 */
	public void setIdAbsenceToModify(String idAbsenceToModify) {
		this.idAbsenceToModify = idAbsenceToModify;
	}

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
	 * @return Returns the idJustification.
	 */
	public String getIdJustification() {
		return idJustification;
	}

	/**
	 * @param idJustification The idJustification to set.
	 */
	public void setIdJustification(String idJustification) {
		this.idJustification = idJustification;
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
	 * @return Returns the initDate.
	 */
	public String getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate The initDate to set.
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return Returns the nbDays.
	 */
	public String getNbDays() {
		return nbDays;
	}

	/**
	 * @param nbDays The nbDays to set.
	 */
	public void setNbDays(String nbDays) {
		this.nbDays = nbDays;
	}

	/**
	 * @return Returns the persAdress.
	 */
	public String getPersAdress() {
		return persAdress;
	}

	/**
	 * @param persAdress The persAdress to set.
	 */
	public void setPersAdress(String persAdress) {
		this.persAdress = persAdress;
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
	public String getProfAdress() {
		return profAdress;
	}

	/**
	 * @param profAdress The profAdress to set.
	 */
	public void setProfAdress(String profAdress) {
		this.profAdress = profAdress;
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
	 * @return Returns the idDepartment.
	 */
	public String getIdDepartment() {
		return idDepartment;
	}

	/**
	 * @param idDepartment The idDepartment to set.
	 */
	public void setIdDepartment(String idDepartment) {
		this.idDepartment = idDepartment;
	}

	/**
	 * @return Returns the idDiploma.
	 */
	public String getIdDiploma() {
		return idDiploma;
	}

	/**
	 * @param idDiploma The idDiploma to set.
	 */
	public void setIdDiploma(String idDiploma) {
		this.idDiploma = idDiploma;
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
	 * @return Returns the idLanguage.
	 */
	public String getIdLanguage() {
		return idLanguage;
	}

	/**
	 * @param idLanguage The idLanguage to set.
	 */
	public void setIdLanguage(String idLanguage) {
		this.idLanguage = idLanguage;
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
	 * @return Returns the idSection.
	 */
	public String getIdSection() {
		return idSection;
	}

	/**
	 * @param idSection The idSection to set.
	 */
	public void setIdSection(String idSection) {
		this.idSection = idSection;
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

}
