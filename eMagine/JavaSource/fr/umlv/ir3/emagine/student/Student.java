package fr.umlv.ir3.emagine.student;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.entreprise.actor.EngineerTutor;
import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.util.Address;

@Entity(access = AccessType.FIELD)
public class Student extends Candidate {

	/*private enum DefaultAddressEnum {
		PROFESSINAL,
		PERSONNAL,
		ACADEMIC,
	}*/
	
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
	private LanguageEnum secondLanguage;

	private List<Mark> examsMark;
	private List<Diploma> diplomas;
	private List<Schooling> schooling;
	
	private TeacherTutor teachingTutor; */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="engineertutor_fk")
	private EngineerTutor engineerTutor;
	//private Entreprise entreprise;
	
	//FIXME : DIfférence avec candidat ?
	//private DieEnum die;
	
	//TODO : Mettre un nombre ?
	//private YearEnum year;
	
	//TODO : Mettre des nombre ?
	//private List<Abscence> absences;
	

	
	
	
	
	

}
