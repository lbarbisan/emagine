package fr.umlv.ir3.emagine.student.candidate;

import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import fr.umlv.ir3.emagine.student.Contact;
import fr.umlv.ir3.emagine.student.LevelEntryEnum;
import fr.umlv.ir3.emagine.student.Profession;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.Person;

@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class Candidate extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131901427590143640L;

	private Contact contactOriginIG2K;
	
	private LevelEntryEnum entryLevel;
	
	private Profession professionMother;
	private Profession professionFather;
	
	private boolean otherFormation;
	private boolean accepted;
	private List<FormationCenter> formationCenter;

}
