package fr.umlv.ir3.emagine.student.candidate;

import java.util.List;

import fr.umlv.ir3.emagine.student.Contact;
import fr.umlv.ir3.emagine.student.CursusEnum;
import fr.umlv.ir3.emagine.student.LevelEntryEnum;
import fr.umlv.ir3.emagine.student.Profession;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.Person;

public class Candidate extends Person {

	private Contact contactOriginIG2K;
	
	//TODO : Le type semble-t-il bon, doit-il être en doublons avec Student ?
	private LevelEntryEnum entryLevel;
	
	private LevelEntryEnum studingLevel;
	//FIXME : Filière
	private DieEnum askDie;
	//TODO : Le type semble-t-il bon, doit-il être en doublons avec Student ?
	private Profession professionMother;
	private Profession professionFather;
	
	private boolean otherFormation;
	private boolean accepted;
	private List<FormationCenter> formationCenter;

}
