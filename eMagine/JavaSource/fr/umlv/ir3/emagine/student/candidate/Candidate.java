package fr.umlv.ir3.emagine.student.candidate;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.student.Contact;
import fr.umlv.ir3.emagine.student.LevelEntryEnum;
import fr.umlv.ir3.emagine.student.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.student.candidate.room.Room;
import fr.umlv.ir3.emagine.util.person.Person;

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
	
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public Contact getContactOriginIG2K() {
		return contactOriginIG2K;
	}
	public void setContactOriginIG2K(Contact contactOriginIG2K) {
		this.contactOriginIG2K = contactOriginIG2K;
	}
	public LevelEntryEnum getEntryLevel() {
		return entryLevel;
	}
	public void setEntryLevel(LevelEntryEnum entryLevel) {
		this.entryLevel = entryLevel;
	}
	public FormationCenter getFormationCenter() {
		return formationCenter;
	}
	public void setFormationCenter(FormationCenter formationCenter) {
		this.formationCenter = formationCenter;
	}
	public boolean isOtherFormation() {
		return otherFormation;
	}
	public void setOtherFormation(boolean otherFormation) {
		this.otherFormation = otherFormation;
	}
	public ProfessionEnum getProfessionFather() {
		return professionFather;
	}
	public void setProfessionFather(ProfessionEnum professionFather) {
		this.professionFather = professionFather;
	}
	public ProfessionEnum getProfessionMother() {
		return professionMother;
	}
	public void setProfessionMother(ProfessionEnum professionMother) {
		this.professionMother = professionMother;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

}
