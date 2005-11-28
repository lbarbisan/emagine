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

import fr.umlv.ir3.emagine.apprentice.absence.Abscence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutor;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Address;
;

@Entity(access = AccessType.FIELD)
public class Apprentice extends Candidate {

	private static final long serialVersionUID = 3998703814616710370L;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "apprentice")
	private List<Abscence> absences;
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
	private Address addressProfessional;
	@AttributeOverrides( {
        @AttributeOverride(name="department", column = @Column(name="academicdepartment")),
        @AttributeOverride(name="country", column = @Column(name="academiccountry")),
        @AttributeOverride(name="street", column = @Column(name="academicstreet")),
        @AttributeOverride(name="postalCode", column = @Column(name="academicpostalCode")),
        @AttributeOverride(name="city", column = @Column(name="academiccity"))})
	@Embedded()
	private Address addressAcademic;
	
	private ArrayList<Integer> examsMark;
	private ArrayList<String> diplomas;
	private ArrayList<String> schooling;
	private DefaultAddressEnum defaultAdress;
	private LanguageEnum firstLanguage;
	private LanguageEnum secondLanguage;
	private Integer year;
	
	public List<Abscence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Abscence> absences) {
		this.absences = absences;
	}

	public Address getAddressAcademic() {
		return addressAcademic;
	}

	public void setAddressAcademic(Address addressAcademic) {
		this.addressAcademic = addressAcademic;
	}

	public Address getAddressProfessional() {
		return addressProfessional;
	}

	public void setAddressProfessional(Address addressProfessional) {
		this.addressProfessional = addressProfessional;
	}

	public DefaultAddressEnum getDefaultAdress() {
		return defaultAdress;
	}

	public void setDefaultAdress(DefaultAddressEnum defaultAdress) {
		this.defaultAdress = defaultAdress;
	}

	public ArrayList<String> getDiplomas() {
		return diplomas;
	}

	public void setDiplomas(ArrayList<String> diplomas) {
		this.diplomas = diplomas;
	}

	public EngineerTutor getEngineerTutor() {
		return engineerTutor;
	}

	public void setEngineerTutor(EngineerTutor engineerTutor) {
		this.engineerTutor = engineerTutor;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public ArrayList<Integer> getExamsMark() {
		return examsMark;
	}

	public void setExamsMark(ArrayList<Integer> examsMark) {
		this.examsMark = examsMark;
	}

	public LanguageEnum getFirstLanguage() {
		return firstLanguage;
	}

	public void setFirstLanguage(LanguageEnum firstLanguage) {
		this.firstLanguage = firstLanguage;
	}

	public ArrayList<String> getSchooling() {
		return schooling;
	}

	public void setSchooling(ArrayList<String> schooling) {
		this.schooling = schooling;
	}

	public LanguageEnum getSecondLanguage() {
		return secondLanguage;
	}

	public void setSecondLanguage(LanguageEnum secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	public TeacherTutor getTeacherTutor() {
		return teacherTutor;
	}

	public void setTeacherTutor(TeacherTutor teacherTutor) {
		this.teacherTutor = teacherTutor;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
