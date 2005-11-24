package fr.umlv.ir3.emagine.student.candidate;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.student.Contact;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.student.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Person;

import fr.umlv.ir3.emagine.student.LevelEntryEnum;
import fr.umlv.ir3.emagine.student.candidate.ProfessionEnum;

/**
 * 
 * @author Administrateur
 * @persistence Reste le Enum et créer une table d'assocication cf.Todo
 */
@Entity(access = AccessType.FIELD)
public class Candidate extends Person {

	private static final long serialVersionUID = 2131901427590143640L;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="contact_id")
	private Contact contactOriginIG2K;
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="formationcenter_id")
	private FormationCenter formationCenter;
	//TODO : Hibernate Créer une table d'association avec => ROOM FORMATIONCENTER ET COndidate
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="room_id")
	private Room room;
	private boolean otherFormation;
	private boolean accepted;
	private LevelEntryEnum entryLevel;
	private ProfessionEnum professionMother;
	private ProfessionEnum professionFather;

}
