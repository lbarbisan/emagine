package fr.umlv.ir3.emagine.apprentice;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
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
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addresspersonnal_id")
	private Address addressProfessional = new Address();
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "addressacademic_id")
	private Address addressAcademic = new Address();
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="defaultaddress_id")
	private DefaultAddressEnum defaultAddress;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="year_id")
	private YearEnum year;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="group_id")
    private GroupEnum group;
	
	//FIXME: lbarbisan - Passer les tableau en table Hibernate
//	private List<Integer> examsMark = new ArrayList<Integer>();
//	private List<String> diplomas = new ArrayList<String>();
//	private List<String> schooling = new ArrayList<String>();

	private String profEmail;
	private String profPhone;
	private String profMobile;
	private String profFax;
	private String acaEmail;
	private String acaPhone;
	private String acaMobile;
	private String acaFax;

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
	 * @return Returns the defaultAddress.
	 */
	public DefaultAddressEnum getDefaultAddress() {
		return defaultAddress;
	}

	/**
	 * @param defaultAddress The defaultAddress to set.
	 */
	public void setDefaultAddress(DefaultAddressEnum defaultAddress) {
		this.defaultAddress = defaultAddress;
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
	 * @return Returns the group.
	 */
	public GroupEnum getGroup() {
		return group;
	}

	/**
	 * @param group The group to set.
	 */
	public void setGroup(GroupEnum group) {
		this.group = group;
	}

	/**
	 * @return Returns the year.
	 */
	public YearEnum getYear() {
		return year;
	}

	/**
	 * @param year The year to set.
	 */
	public void setYear(YearEnum year) {
		this.year = year;
	}


}
