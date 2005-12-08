package fr.umlv.ir3.emagine.apprentice;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchParamImpl;

public class ApprenticeTest extends TestCase {

	private ApprenticeDAO apprenticeDao;
	private Candidate candidate = new Candidate();
	private Apprentice apprentice;
	
	public ApprenticeTest(String arg0) {
		super(arg0);
		apprenticeDao = ManagerManager.getInstance().getApprenticeManager().getDAO();
	}

	protected void setUp() throws Exception {
		super.setUp();
		try {
			SearchParamImpl searchParam = new SearchParamImpl();
			searchParam.setField("firstName", "apprentice1");
			List<Apprentice> lists= apprenticeDao.find(searchParam);	
			apprentice = lists.get(0);
		} catch (Exception e) {
			apprentice = new Apprentice(candidate);
			apprentice.setFirstName("apprentice1");
			apprentice.setLastName("apprentice1");
		}		
		DAOManager.beginTransaction();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		if(apprentice.getId()==null)
		{
			apprenticeDao.create(apprentice);
		}
		else
		{
			apprenticeDao.update(apprentice);	
		}
		DAOManager.commitTransaction();
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.Apprentice(Candidate)'
	 */
	public void testApprentice() {
		
		
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getAbsences()'
	 */
	public void testGetAbsences() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAbsences(List<Absence>)'
	 */
	public void testAddAbsence() {
		Absence absence = new Absence(false,
				"Feignassee !!!",
				new Date(),
				new Date());
		apprentice.addAbsence(absence);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getAddressAcademic()'
	 */
	public void testGetAddressAcademic() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAddressAcademic(Address)'
	 */
	public void testSetAddressAcademic() {
		Address address = new Address();
		address.setCity("City1");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("66666");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressAcademic(address);

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getAddressProfessional()'
	 */
	public void testGetAddressProfessional() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setAddressProfessional(Address)'
	 */
	public void testSetAddressProfessional() {
		Address address = new Address();
		address.setCity("City2");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("77777");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressProfessional(address);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getDefaultAdress()'
	 */
	public void testGetDefaultAdress() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setDefaultAdress(DefaultAddressEnum)'
	 */
	public void testSetDefaultAdress() {
		Address address = new Address();
		address.setCity("City3");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("88888");
		address.setStreet("1 rue de paradie");
		apprentice.setAddressProfessional(address);
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getDiplomas()'
	 */
	public void testGetDiplomas() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setDiplomas(ArrayList<String>)'
	 */
	public void testSetDiplomas() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getEngineerTutor()'
	 */
	public void testGetEngineerTutor() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setEngineerTutor(EngineerTutor)'
	 */
	public void testSetEngineerTutor() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getFirm()'
	 */
	public void testGetFirm() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setFirm(Firm)'
	 */
	public void testSetFirm() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getExamsMark()'
	 */
	public void testGetExamsMark() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setExamsMark(ArrayList<Integer>)'
	 */
	public void testSetExamsMark() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getFirstLanguage()'
	 */
	public void testGetFirstLanguage() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setFirstLanguage(LanguageEnum)'
	 */
	public void testSetFirstLanguage() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getSchooling()'
	 */
	public void testGetSchooling() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setSchooling(ArrayList<String>)'
	 */
	public void testSetSchooling() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getSecondLanguage()'
	 */
	public void testGetSecondLanguage() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setSecondLanguage(LanguageEnum)'
	 */
	public void testSetSecondLanguage() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getTeacherTutor()'
	 */
	public void testGetTeacherTutor() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setTeacherTutor(TeacherTutor)'
	 */
	public void testSetTeacherTutor() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getYear()'
	 */
	public void testGetYear() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setYear(Integer)'
	 */
	public void testSetYear() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.getExcluded()'
	 */
	public void testGetExcluded() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.Apprentice.setExcluded(Boolean)'
	 */
	public void testSetExcluded() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.Candidate(List<Modification>, List<Event>, Address, Date, String, CountryEnum, DepartmentEnum, NationalityEnum, SexEnum, String, String, String, String, String, String, Contact, FormationCenter, Room, boolean, boolean, LevelEntryEnum, ProfessionEnum, ProfessionEnum, CourseOptionEnum)'
	 */
	public void testCandidate() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.isAccepted()'
	 */
	public void testIsAccepted() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setAccepted(boolean)'
	 */
	public void testSetAccepted() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getContactOriginIG2K()'
	 */
	public void testGetContactOriginIG2K() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setContactOriginIG2K(Contact)'
	 */
	public void testSetContactOriginIG2K() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getEntryLevel()'
	 */
	public void testGetEntryLevel() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setEntryLevel(LevelEntryEnum)'
	 */
	public void testSetEntryLevel() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getFormationCenter()'
	 */
	public void testGetFormationCenter() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setFormationCenter(FormationCenter)'
	 */
	public void testSetFormationCenter() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.isOtherFormation()'
	 */
	public void testIsOtherFormation() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setOtherFormation(boolean)'
	 */
	public void testSetOtherFormation() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getProfessionFather()'
	 */
	public void testGetProfessionFather() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setProfessionFather(ProfessionEnum)'
	 */
	public void testSetProfessionFather() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getProfessionMother()'
	 */
	public void testGetProfessionMother() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setProfessionMother(ProfessionEnum)'
	 */
	public void testSetProfessionMother() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getRoom()'
	 */
	public void testGetRoom() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setRoom(Room)'
	 */
	public void testSetRoom() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.getCourseOption()'
	 */
	public void testGetCourseOption() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.apprentice.candidate.Candidate.setCourseOption(CourseOptionEnum)'
	 */
	public void testSetCourseOption() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.Person(Long, Long, List<Modification>, List<Event>, Address, Date, String, CountryEnum, DepartmentEnum, NationalityEnum, SexEnum, String, String, String, String, String, String)'
	 */
	public void testPersonLongLongListOfModificationListOfEventAddressDateStringCountryEnumDepartmentEnumNationalityEnumSexEnumStringStringStringStringStringString() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.Person()'
	 */
	public void testPerson() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getAddressPersonnal()'
	 */
	public void testGetAddressPersonnal() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setAddressPersonnal(Address)'
	 */
	public void testSetAddressPersonnal() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getBirthdayCity()'
	 */
	public void testGetBirthdayCity() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setBirthdayCity(String)'
	 */
	public void testSetBirthdayCity() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getBirthdayCountry()'
	 */
	public void testGetBirthdayCountry() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setBirthdayCountry(CountryEnum)'
	 */
	public void testSetBirthdayCountry() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getBirthdayDate()'
	 */
	public void testGetBirthdayDate() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setBirthdayDate(Date)'
	 */
	public void testSetBirthdayDate() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getBirthdayDepartment()'
	 */
	public void testGetBirthdayDepartment() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setBirthdayDepartment(DepartmentEnum)'
	 */
	public void testSetBirthdayDepartment() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getEmail()'
	 */
	public void testGetEmail() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setEmail(String)'
	 */
	public void testSetEmail() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getFax()'
	 */
	public void testGetFax() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setFax(String)'
	 */
	public void testSetFax() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getFirstName()'
	 */
	public void testGetFirstName() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setFirstName(String)'
	 */
	public void testSetFirstName() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getLastName()'
	 */
	public void testGetLastName() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setLastName(String)'
	 */
	public void testSetLastName() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getMobilePhone()'
	 */
	public void testGetMobilePhone() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setMobilePhone(String)'
	 */
	public void testSetMobilePhone() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getNationality()'
	 */
	public void testGetNationality() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setNationality(NationalityEnum)'
	 */
	public void testSetNationality() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getPhone()'
	 */
	public void testGetPhone() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setPhone(String)'
	 */
	public void testSetPhone() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.getSex()'
	 */
	public void testGetSex() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.person.Person.setSex(SexEnum)'
	 */
	public void testSetSex() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.EditableEntity(Long, Long, List<Modification>)'
	 */
	public void testEditableEntityLongLongListOfModification() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.EditableEntity()'
	 */
	public void testEditableEntity() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.getModifications()'
	 */
	public void testGetModifications() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.getCurrentModification()'
	 */
	public void testGetCurrentModification() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.addModification(EditableEntity)'
	 */
	public void testAddModification() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.acceptModification()'
	 */
	public void testAcceptModification() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.EditableEntity.acceptFieldModification(FieldModification)'
	 */
	public void testAcceptFieldModification() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.BaseEntity(Long, Long)'
	 */
	public void testBaseEntityLongLong() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.BaseEntity()'
	 */
	public void testBaseEntity() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.getField(String)'
	 */
	public void testGetField() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.getFields()'
	 */
	public void testGetFields() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.equals(Object)'
	 */
	public void testEqualsObject() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.getId()'
	 */
	public void testGetId() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.getVersion()'
	 */
	public void testGetVersion() {

	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseEntity.setVersion(Long)'
	 */
	public void testSetVersion() {

	}

}
