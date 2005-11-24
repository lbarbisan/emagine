package fr.umlv.ir3.emagine.student.candidate;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.umlv.ir3.emagine.student.Contact;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.student.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Person;

/**
 * 
 * @author Administrateur
 * @persistence Reste le Enum et créer une table d'assocication cf.Todo
 */
@Entity(access = AccessType.FIELD)
@Inheritance(strategy=InheritanceType.JOINED)
public class Candidate extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131901427590143640L;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="contact_fk")
	private Contact contactOriginIG2K;

	//FIXME : Hibernate - EnumentryLevel
	private LevelEntryEnum entryLevel;
	
	private ProfessionEnum professionMother;
	private ProfessionEnum professionFather; 
	
	private boolean otherFormation;
	private boolean accepted;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="formationcenter_fk")
	private FormationCenter formationCenter;

	//TODO : Hibernate Créer une table d'association avec => ROOM FORMATIONCENTER ET COndidate
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="room_fk")
	private Room room;

}
