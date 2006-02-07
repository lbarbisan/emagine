package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;

public class CandidateModifyForm extends ActionForm {

	private static final long serialVersionUID = -1120295787399332929L;
	
	
	/** Identifier of candidate to modify **/
	private String idCandidateToModify;
	
	/** candidate firstname **/
	private String firstName;
	
	/** candidate lastname **/
	private String lastName;
	
	/** candidate date of birth **/
	private String birth;
	
	/** List of all departments **/
	private Collection <DepartmentEnum> departments;
	
	/** Identifier of selected department **/
	private String idDepartment;
	
	/** Identifier of selected personal department **/
	private String idPersDepartment;
	
	/** List of all courseOptions**/
	private Collection <CourseOptionEnum> courseOptions;

	/** Identifier of selected course option **/
	private String idCourseOption;

	/** List of all courseOptions**/
	private Collection <FormationCenter> centers;

	/** Identifier of selected course option **/
	private String idCenter;
	
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
	
	/** List of all contacts **/
	private Collection <ContactEnum> contacts;
	
	/** Identifier of selected contact **/
	private String idContact;
	
	/** List of all diplomas **/
	private Collection <DiplomaEnum> diplomas;
	
	/** Identifier of selected diploma **/
	private String idDiploma;
	
	/** List of all Sections **/
	private Collection <SectionEnum> sections;
	
	/** Identifier of selected section **/
	private String idSection;
	
	/** List of all countries **/
	private Collection <CountryEnum> countries;
	
	/** Identifier of selected country **/
	private String idCountry;
	
	/** List of all nationalities **/
	private Collection <NationalityEnum> nationalities;
	
	/** Identifier of selected nationality **/
	private String idNationality;

	/** List of all levels **/
	private Collection <LevelEntryEnum> levels;
	
	/** Identifier of selected sexe **/
	private String idLevel;
	
	/** candidate city **/
	private String city;
	
	/** Use to action **/
	private String action;
	
	/** candidate personal Adress **/
	private String persAdress;
	
	/** candidate personal code adress **/
	private String persPostalCode;
	
	/** candidate personal city **/
	private String persCity;
	
	/** candidate personal phone **/
	private String persPhone;
	
	/** candidate personal mobile **/
	private String persMobile;
	
	/** candidate personal fax **/
	private String persFax;
	
	/** candidate personal eMail **/
	private String persEmail;
	
	/** candidate personal fax **/
	private boolean formation;
	
	/** candidate personal eMail **/
	private boolean admissibility;
		
	
	@Override
	public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
		ActionErrors errors = new ActionErrors();

		if("create".equals(action) || "modify".equals(action)) {
			if("".equals(firstName) || "".equals(lastName) || "".equals(persCity) || "".equals(persEmail)|| "".equals(persPostalCode)|| "".equals(persAdress)){
				errors.add("allRequiredFieldIsNotfillin", new ActionMessage("user.error.allRequiredFieldIsNotfillin"));
			}
			else {
			/* TODO if (!isValide(birth)){
				errors.add("wrongDateFormat", new ActionMessage("candidate.error.wrongDateFormat"));
				}
			*/
			}
		}

		return errors;
	}

/*	private boolean isValide(String birth2) {
		//FIXME créer une méthode vérifiant le format
	}
*/

	/**
	 * Reset all informations contains in this form
	 */
	public void reset() {
		firstName="";
		lastName="";
		birth = "";
		departments = null;
		idDepartment = null;
		idPersDepartment = "";
		courseOptions = null;
		idCourseOption = "";
		centers = null;
		idCenter = "";
		sexes = null;
		idSex = "";
		professions = null;
		idMother = "";
		idFather= "";
		contacts = null;
		idContact = "";
		diplomas = null;
		idDiploma = "";
		sections = null;
		idSection = "";
		countries = null;
		idCountry = "";
		nationalities = null;
		idNationality = "";
		levels = null;
		idLevel="";
		city = "";
		action = "";
		idCandidateToModify = "";
		persAdress = "";
		persPostalCode ="";
		persCity = "";
		persPhone = "";
		persMobile = "";
		persFax = "";
		persEmail = "";
		formation = false;
		admissibility = false;
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
	 * @return Returns the sexes.
	 */
	public Collection<SexEnum> getSexes() {
		return sexes;
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
	 * @param sexes The sexes to set.
	 */
	public void setSexes(Collection<SexEnum> sexes) {
		this.sexes = sexes;
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
	 * @return Returns the centers.
	 */
	public Collection<FormationCenter> getCenters() {
		return centers;
	}


	/**
	 * @param centers The centers to set.
	 */
	public void setCenters(Collection<FormationCenter> centers) {
		this.centers = centers;
	}


	/**
	 * @return Returns the idCenter.
	 */
	public String getIdCenter() {
		return idCenter;
	}


	/**
	 * @param idCenter The idCenter to set.
	 */
	public void setIdCenter(String idCenter) {
		this.idCenter = idCenter;
	}


	/**
	 * @return Returns the birth.
	 */
	public String getBirth() {
		System.out.println("c'est la date :"+birth);
		return birth;
	}


	/**
	 * @param birth The birth to set.
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}


	/**
	 * @param admissibility The admissibility to set.
	 */
	public void setAdmissibility(boolean admissibility) {
		this.admissibility = admissibility;
	}


	/**
	 * @param formation The formation to set.
	 */
	public void setFormation(boolean formation) {
		this.formation = formation;
	}


	/**
	 * @return Returns the admissibility.
	 */
	public boolean isAdmissibility() {
		return admissibility;
	}


	/**
	 * @return Returns the formation.
	 */
	public boolean isFormation() {
		return formation;
	}

	/**
	 * @return Returns the idCandidateToModify.
	 */
	public String getIdCandidateToModify() {
		return idCandidateToModify;
	}

	/**
	 * @param idCandidateToModify The idCandidateToModify to set.
	 */
	public void setIdCandidateToModify(String idCandidateToModify) {
		this.idCandidateToModify = idCandidateToModify;
	}
}
