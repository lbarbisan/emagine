package fr.umlv.ir3.emagine.apprentice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Address;
/**
 * This class represent an apprentice
 * @author Laurent
 *
 */
@Entity(access = AccessType.FIELD)
public class Apprentice extends Candidate {

	private static final long serialVersionUID = 3998703814616710370L;

	@OneToMany(cascade = {CascadeType.ALL},
			mappedBy = "apprentice")
	private List<Absence> absences = new ArrayList<Absence>();
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="teachingtutor_id")
	private TeacherTutor teacherTutor; 
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="engineertutor_id")
	private EngineerTutor engineerTutor;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="firm_id")
	private Firm firm;

	@Embedded()
	@AttributeOverrides( {
        @AttributeOverride(name="department", column = @Column(name="professionaldepartment")),
        @AttributeOverride(name="country", column = @Column(name="professionalcountry")),
        @AttributeOverride(name="street", column = @Column(name="professionalstreet")),
        @AttributeOverride(name="postalCode", column = @Column(name="professionalpostalCode")),
        @AttributeOverride(name="city", column = @Column(name="professionalcity"))})
	private Address addressProfessional = new Address();
	@AttributeOverrides( {
        @AttributeOverride(name="department", column = @Column(name="academicdepartment")),
        @AttributeOverride(name="country", column = @Column(name="academiccountry")),
        @AttributeOverride(name="street", column = @Column(name="academicstreet")),
        @AttributeOverride(name="postalCode", column = @Column(name="academicpostalCode")),
        @AttributeOverride(name="city", column = @Column(name="academiccity"))})
	@Embedded()
	private Address addressAcademic = new Address();
	
	private ArrayList<Integer> examsMark;
	private ArrayList<String> diplomas;
	private ArrayList<String> schooling;
	private DefaultAddressEnum defaultAdress;
	private LanguageEnum firstLanguage;
	private LanguageEnum secondLanguage;
	private Integer year;
	private Boolean excluded;
	
	/**
	 *  This constructor is only for Hibernate
	 */
	public Apprentice(){super();}
	
	/**
	 * This constructor
	 * @param candidate constructor
	 */
	public Apprentice(Candidate candidate) {
		super(candidate.getModifications(), candidate.getEvents(), candidate.getAddressPersonnal(), candidate.getBirthdayDate(),
				candidate.getBirthdayCity(), candidate.getBirthdayCountry(), candidate.getBirthdayDepartment(), candidate.getNationality(), candidate.getSex(),
				candidate.getLastName(), candidate.getFirstName(), candidate.getEmail(), candidate.getPhone(), candidate.getMobilePhone(), candidate.getFax(), candidate.getContactOriginIG2K(),
				candidate.getFormationCenter(), candidate.getRoom(), candidate.isOtherFormation(), candidate.isAccepted(), candidate.getEntryLevel(),
				candidate.getProfessionMother(), candidate.getProfessionFather(), candidate.getCourseOption());
		
	}

	/**
	 * @return Returns the absences.
	 */
	public List<Absence> getAbsences() {
		return absences;
	}

	/**
	 * @param absences The absences to set.
	 */
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	/**
	 * @return Returns the addressAcademic.
	 */
	public Address getAddressAcademic() {
		return addressAcademic;
	}

	/**
	 * @param addressAcademic The addressAcademic to set.
	 */
	public void setAddressAcademic(Address addressAcademic) {
		this.addressAcademic = addressAcademic;
	}

	/**
	 * @return Returns the addressProfessional.
	 */
	public Address getAddressProfessional() {
		return addressProfessional;
	}

	/**
	 * @param addressProfessional The addressProfessional to set.
	 */
	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}

	/**
	 * @return Returns the defaultAdress.
	 */
	public DefaultAddressEnum getDefaultAdress() {
		return defaultAdress;
	}

	/**
	 * @param defaultAdress The defaultAdress to set.
	 */
	public void setDefaultAdress(DefaultAddressEnum defaultAdress) {
		this.defaultAdress = defaultAdress;
	}

	/**
	 * @return Returns the diplomas.
	 */
	public ArrayList<String> getDiplomas() {
		return diplomas;
	}

	/**
	 * @param diplomas The diplomas to set.
	 */
	public void setDiplomas(ArrayList<String> diplomas) {
		this.diplomas = diplomas;
	}

	/**
	 * @return Returns the engineerTutor.
	 */
	public EngineerTutor getEngineerTutor() {
		return engineerTutor;
	}

	/**
	 * @param engineerTutor The engineerTutor to set.
	 */
	public void setEngineerTutor(EngineerTutor engineerTutor) {
		this.engineerTutor = engineerTutor;
	}

	/**
	 * @return Returns the examsMark.
	 */
	public ArrayList<Integer> getExamsMark() {
		return examsMark;
	}

	/**
	 * @param examsMark The examsMark to set.
	 */
	public void setExamsMark(ArrayList<Integer> examsMark) {
		this.examsMark = examsMark;
	}

	/**
	 * @return Returns the excluded.
	 */
	public Boolean getExcluded() {
		return excluded;
	}

	/**
	 * @param excluded The excluded to set.
	 */
	public void setExcluded(Boolean excluded) {
		this.excluded = excluded;
	}

	/**
	 * @return Returns the firm.
	 */
	public Firm getFirm() {
		return firm;
	}

	/**
	 * @param firm The firm to set.
	 */
	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	/**
	 * @return Returns the firstLanguage.
	 */
	public LanguageEnum getFirstLanguage() {
		return firstLanguage;
	}

	/**
	 * @param firstLanguage The firstLanguage to set.
	 */
	public void setFirstLanguage(LanguageEnum firstLanguage) {
		this.firstLanguage = firstLanguage;
	}

	/**
	 * @return Returns the schooling.
	 */
	public ArrayList<String> getSchooling() {
		return schooling;
	}

	/**
	 * @param schooling The schooling to set.
	 */
	public void setSchooling(ArrayList<String> schooling) {
		this.schooling = schooling;
	}

	/**
	 * @return Returns the secondLanguage.
	 */
	public LanguageEnum getSecondLanguage() {
		return secondLanguage;
	}

	/**
	 * @param secondLanguage The secondLanguage to set.
	 */
	public void setSecondLanguage(LanguageEnum secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	/**
	 * @return Returns the teacherTutor.
	 */
	public TeacherTutor getTeacherTutor() {
		return teacherTutor;
	}

	/**
	 * @param teacherTutor The teacherTutor to set.
	 */
	public void setTeacherTutor(TeacherTutor teacherTutor) {
		this.teacherTutor = teacherTutor;
	}

	/**
	 * @return Returns the year.
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year The year to set.
	 */
	public void setYear(Integer year) {
		this.year = year;
	}


}
