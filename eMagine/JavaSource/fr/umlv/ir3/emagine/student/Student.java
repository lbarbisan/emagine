package fr.umlv.ir3.emagine.student;

import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.umlv.ir3.emagine.entreprise.Entreprise;
import fr.umlv.ir3.emagine.entreprise.actor.EngineerTutor;
import fr.umlv.ir3.emagine.student.absence.Abscence;
import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Address;

@Entity(access = AccessType.FIELD)
@Table(name = "tbl_student")
public class Student extends Candidate {

	private enum DefaultAddressEnum {
		PROFESSINAL,
		PERSONNAL,
		ACADEMIC,
	}
	//FIXME: Solve - cr�er une table interm�diaire
	private Date startDate;
	
	private Address addressProfessional;
	private Address addressAcademic;
	private DefaultAddressEnum defaultAdress;
	
	private LanguageEnum firstLanguage;
	private LanguageEnum secondLanguage;

	private List<Mark> examsMark;
	private List<Diploma> diplomas;
	private List<Schooling> schooling;
	
	private TeacherTutor teachingTutor;
	private EngineerTutor engineerTutor;
	private Entreprise entreprise;
	
	//FIXME : DIff�rence avec candidat ?
	//private DieEnum die;
	
	//TODO : Mettre un nombre ?
	private YearEnum year;
	
	//TODO : Mettre des nombre ?
	private List<Abscence> absences;
	

	
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3998703814616710370L;

/*	@OneToMany(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@OrderBy("date")
	List<Abscence> abscences;*/
	
/*	@OneToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@JoinColumn(name="teachertutor_fk")
	@Column(unique = true)*/
	private TeacherTutor teacherTutor;

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
	
/*	@OneToOne(cascade = {
			CascadeType.PERSIST, 
			CascadeType.MERGE, 
			CascadeType.REFRESH})
	@JoinColumn(name="engineertutor_fk")
	@Column(unique = true)
	private EngineerTutor engineerTutor;*/
}
