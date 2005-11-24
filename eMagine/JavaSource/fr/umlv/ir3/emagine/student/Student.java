package fr.umlv.ir3.emagine.student;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.umlv.ir3.emagine.entreprise.Entreprise;
import fr.umlv.ir3.emagine.entreprise.actor.EngineerTutor;
import fr.umlv.ir3.emagine.student.absence.Abscence;
import fr.umlv.ir3.emagine.student.candidate.Candidate;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.util.Address;
;

@Entity(access = AccessType.FIELD)
public class Student extends Candidate {

	private static final long serialVersionUID = 3998703814616710370L;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
			mappedBy = "student")
	private List<Abscence> absences;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="teachingtutor_id")
	private TeacherTutor teacherTutor; 
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="engineertutor_id")
	private EngineerTutor engineerTutor;
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="entreprise_id")
	private Entreprise entreprise;

	@Embedded
	private Address addressProfessional;
	@Embedded
	private Address addressAcademic;
	
	private ArrayList<Integer> examsMark;
	private ArrayList<String> diplomas;
	private ArrayList<String> schooling;
	private DefaultAddressEnum defaultAdress;
	private LanguageEnum firstLanguage;
	private LanguageEnum secondLanguage;
	private Integer year;
	

}
