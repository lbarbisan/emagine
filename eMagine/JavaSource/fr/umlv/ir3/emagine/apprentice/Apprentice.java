package fr.umlv.ir3.emagine.apprentice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Address;
/**
 * This class represent an apprentice
 * @author Laurent
 */
@Entity(access = AccessType.FIELD)
public class Apprentice extends Candidate {

	private static final long serialVersionUID = 3998703814616710370L;

	@OneToMany(mappedBy = "apprentice")
	@Cascade(CascadeType.SAVE_UPDATE)
	private List<Absence> absences = new ArrayList<Absence>();
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="teachingtutor_id")
	private TeacherTutor teacherTutor; 
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="engineertutor_id")
	private EngineerTutor engineerTutor;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="firm_id")
	private Firm firm;
	@OneToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addresspersonnal_id")
	private Address addressProfessional = new Address();
	@OneToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressacademic_id")
	private Address addressAcademic = new Address();
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="defaultadress_id")
	private DefaultAddressEnum defaultAdress;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="firstlanguage_id")
	private LanguageEnum firstLanguage;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="secondlanguage_id")
	private LanguageEnum secondLanguage;
	
	//FIXME: lbarbisan - Passer les tableau en table Hibernate
//	private List<Integer> examsMark = new ArrayList<Integer>();
//	private List<String> diplomas = new ArrayList<String>();
//	private List<String> schooling = new ArrayList<String>();

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
