package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.umlv.ir3.emagine.apprentice.Contact;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.person.Person;

/**
 * 
 * @author Administrateur
 * @persistence Reste le Enum et cr�er une table d'assocication cf.Todo
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
	//TODO : Hibernate Cr�er une table d'association avec => ROOM FORMATIONCENTER ET COndidate
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="room_id")
	private Room room;
	private boolean otherFormation;
	private boolean accepted;
	private LevelEntryEnum entryLevel;
	private ProfessionEnum professionMother;
	private ProfessionEnum professionFather;
	private CourseOptionEnum courseOption;
	
	
	
	
	
	/**
	 * @param id
	 * @param version
	 * @param name
	 * @param modifications
	 * @param events
	 * @param addressPersonnal
	 * @param birthdayDate
	 * @param birthdayCity
	 * @param birthdayCountry
	 * @param birthdayDepartment
	 * @param nationality
	 * @param sex
	 * @param lastName
	 * @param firstName
	 * @param email
	 * @param phone
	 * @param mobilePhone
	 * @param fax
	 * @param contactOriginIG2K
	 * @param formationCenter
	 * @param room
	 * @param otherFormation
	 * @param accepted
	 * @param entryLevel
	 * @param professionMother
	 * @param professionFather
	 * @param courseOption constructor
	 */
	public Candidate(List<Modification> modifications, List<Event> events, Address addressPersonnal, Date birthdayDate, String birthdayCity, CountryEnum birthdayCountry, DepartmentEnum birthdayDepartment, NationalityEnum nationality, SexEnum sex, String lastName, String firstName, String email, String phone, String mobilePhone, String fax, Contact contactOriginIG2K, FormationCenter formationCenter, Room room, boolean otherFormation, boolean accepted, LevelEntryEnum entryLevel, ProfessionEnum professionMother, ProfessionEnum professionFather, CourseOptionEnum courseOption) {
		super(null, null, modifications, events, addressPersonnal, birthdayDate,
				birthdayCity, birthdayCountry, birthdayDepartment, nationality, sex,
				lastName, firstName, email, phone, mobilePhone, fax);
		this.contactOriginIG2K = contactOriginIG2K;
		this.formationCenter = formationCenter;
		this.room = room;
		this.otherFormation = otherFormation;
		this.accepted = accepted;
		this.entryLevel = entryLevel;
		this.professionMother = professionMother;
		this.professionFather = professionFather;
		this.courseOption = courseOption;
	}
	
	
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
	public CourseOptionEnum getCourseOption() {
		return courseOption;
	}
	public void setCourseOption(CourseOptionEnum courseOption) {
		this.courseOption = courseOption;
	}

}
