package fr.umlv.ir3.emagine.student;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.entreprise.Entreprise;
import fr.umlv.ir3.emagine.entreprise.actor.EngineerTutor;
import fr.umlv.ir3.emagine.student.absence.Abscence;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.util.Address;

import java.util.List;

@Entity(access = AccessType.FIELD)
public class Student extends Candidate {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3998703814616710370L;
	
	@Embedded
	private Address addressProfessional;
	@Embedded
	private Address addressAcademic;
	/*private DefaultAddressEnum defaultAdress;
	private LanguageEnum firstLanguage;
	private LanguageEnum secondLanguage;*/

	/*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Mark> examsMark;*/
	/*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Diploma> diplomas;*/
	/*@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Schooling> schooling;*/
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="teachingtutor_fk")
	private TeacherTutor teachingTutor; 
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="engineertutor_fk")
	private EngineerTutor engineerTutor;
	private Entreprise entreprise;
	
	//FIXME : DIfférence avec candidat ?
	//private DieEnum die;
	
	private Integer year;
	/*@ManyToOne
	private List<Abscence> absences;*/

}
