package fr.umlv.ir3.emagine.apprentice.candidate;

import java.util.Date;
import java.util.List;

import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
 * @persistence Reste le Enum et créer une table d'assocication cf.Todo
 */
@Entity(access = AccessType.FIELD)
public class Candidate extends Person {

	private static final long serialVersionUID = 2131901427590143640L;

	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="contact_id")
	private ContactEnum contactOriginIG2K;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="formationcenter_id")
	private FormationCenter formationCenter;
	//TODO : Hibernate Créer une table d'association avec => ROOM FORMATIONCENTER ET COndidate
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="room_id")
	private Room room;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="entrylevel_id")
	private LevelEntryEnum entryLevel;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="professionmother_id")
	private ProfessionEnum professionMother;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="professionfather_id")
	private ProfessionEnum professionFather;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="courseoption_id")
	private CourseOptionEnum courseOption;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="lastdiploma_id")
	private DiplomaEnum lastDiploma;
	@ManyToOne()
	@Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name="lastsection_id")
	private SectionEnum lastSection;
	
	private boolean otherFormation;
	private boolean accepted;
	
	

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
	public Candidate(List<Modification> modifications, List<Event> events, Address addressPersonnal, Date birthdayDate, String birthdayCity, CountryEnum birthdayCountry, DepartmentEnum birthdayDepartment, NationalityEnum nationality, SexEnum sex, String lastName, String firstName, String email, String phone, String mobilePhone, String fax, ContactEnum contactOriginIG2K, FormationCenter formationCenter, Room room, boolean otherFormation, boolean accepted, LevelEntryEnum entryLevel, ProfessionEnum professionMother, ProfessionEnum professionFather, CourseOptionEnum courseOption) {
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
	
	
	public Candidate() {
		super();
		// TODO Candidate() Not Implemented
	}

	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public ContactEnum getContactOriginIG2K() {
		return contactOriginIG2K;
	}
	public void setContactOriginIG2K(ContactEnum contactOriginIG2K) {
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


	public DiplomaEnum getLastDiploma() {
		return lastDiploma;
	}


	public void setLastDiploma(DiplomaEnum lastDiploma) {
		this.lastDiploma = lastDiploma;
	}


	public SectionEnum getLastSection() {
		return lastSection;
	}


	public void setLastSection(SectionEnum lastSection) {
		this.lastSection = lastSection;
	}

}
