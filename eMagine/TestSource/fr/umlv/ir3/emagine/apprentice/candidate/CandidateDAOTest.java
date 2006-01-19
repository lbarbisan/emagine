package fr.umlv.ir3.emagine.apprentice.candidate;



import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.Contact;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class CandidateDAOTest extends BaseDAOTest<Candidate> {

	CandidateDAO dao;
	
	public CandidateDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new CandidateDAO();
	}

	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}

	@Override
	protected BaseDAO<Candidate> getDAO() {
		return dao;
	}

	//@Override
	protected Candidate createEntity() {
		Candidate candidate = new Candidate(); 
		//TODO rien dans le constructeur d'un contact et d'une formation ? on doit utiliser la liste de modification?
		candidate.setContactOriginIG2K(new Contact());
		candidate.setFormationCenter(new FormationCenter());
		candidate.setRoom(new Room());
		candidate.setOtherFormation(true);
		candidate.setAccepted(true);
		candidate.setEntryLevel(null);
		//TODO accesseur pour levelEntry???! candidate.setLevelEntry entryLevel;
		//TODO mettre de vraies valeurs aux enum
		candidate.setProfessionFather(null);
		candidate.setProfessionMother(null);
		candidate.setCourseOption(null);
		
		//attributs hérités de Person :
		Address address = new Address();
		address.setCity("new city");
		//address.setCountry(CountryEnum.valueOf("England"));
		//address.setDepartment(DepartmentEnum.valueOf("D2"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		candidate.setAddressPersonnal(address);
		candidate.setBirthdayCity("city");
		//candidate.setBirthdayCountry(CountryEnum.valueOf("France"));
		candidate.setEmail("mail");
		candidate.setEvents(new ArrayList<Event>());
		candidate.setFax("fax");
		candidate.setFirstName("firstname");
		candidate.setLastName("lastname");
		candidate.setMobilePhone("mobile");
		//candidate.setNationality(NationalityEnum.francaise);
		candidate.setPhone("phone");
		//candidate.setSex(SexEnum.MALE);
		
		return candidate;
	}

	//@Override
	protected Collection<Candidate> createEntityCollection() {
		ArrayList<Candidate> list = new ArrayList<Candidate>();
		Candidate candidate1 = new Candidate(); 
		candidate1.setContactOriginIG2K(new Contact());
		candidate1.setFormationCenter(new FormationCenter());
		candidate1.setRoom(new Room());
		candidate1.setOtherFormation(true);
		candidate1.setAccepted(true);
		candidate1.setEntryLevel(null);
		candidate1.setProfessionFather(null);
		candidate1.setProfessionMother(null);
		candidate1.setCourseOption(null);
		
		//attributs hérités de Person :
		Address address = new Address();
		address.setCity("new city");
		//address.setCountry(CountryEnum.valueOf("England"));
		//address.setDepartment(DepartmentEnum.valueOf("D2"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		candidate1.setAddressPersonnal(address);
		candidate1.setBirthdayCity("city");
		//candidate1.setBirthdayCountry(CountryEnum.valueOf("France"));
		candidate1.setEmail("mail");
		candidate1.setEvents(new ArrayList<Event>());
		candidate1.setFax("fax");
		candidate1.setFirstName("firstname");
		candidate1.setLastName("lastname");
		candidate1.setMobilePhone("mobile");
		//candidate1.setNationality(NationalityEnum.francaise);
		candidate1.setPhone("phone");
		//candidate1.setSex(SexEnum.MALE);
		
		Candidate candidate2 = new Candidate(); 
		candidate2.setContactOriginIG2K(new Contact());
		candidate2.setFormationCenter(new FormationCenter());
		candidate2.setRoom(new Room());
		candidate2.setOtherFormation(false);
		candidate2.setAccepted(false);
		candidate2.setEntryLevel(null);
		candidate2.setProfessionFather(null);
		candidate2.setProfessionMother(null);
		candidate2.setCourseOption(null);
		
		//attributs hérités de Person :
		address.setCity("new city");
		//address.setCountry(CountryEnum.valueOf("England"));
		//address.setDepartment(DepartmentEnum.valueOf("D2"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		candidate2.setAddressPersonnal(address);
		candidate2.setBirthdayCity("city");
		//candidate2.setBirthdayCountry(CountryEnum.valueOf("England"));
		candidate2.setEmail("mail");
		candidate2.setEvents(new ArrayList<Event>());
		candidate2.setFax("fax");
		candidate2.setFirstName("firstname");
		candidate2.setLastName("lastname");
		candidate2.setMobilePhone("mobile");
		//candidate2.setNationality(NationalityEnum.francaise);
		candidate2.setPhone("phone");
		//candidate2.setSex(SexEnum.MALE);
		
		list.add(candidate1);
		list.add(candidate2);
		return list;
	}

	@Override
	protected void updateEntity(Candidate entity) {
		entity.setContactOriginIG2K(new Contact());
		entity.setFormationCenter(new FormationCenter());
		entity.setRoom(new Room());
		entity.setOtherFormation(true);
		entity.setAccepted(true);
		entity.setProfessionFather(null);
		entity.setProfessionMother(null);
		entity.setCourseOption(null);
		
		//attributs hérités de Person :
		Address address = new Address();
		address.setCity("new city");
		//address.setCountry(CountryEnum.valueOf("England"));
		//address.setDepartment(DepartmentEnum.valueOf("D1"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		entity.setAddressPersonnal(address);
		entity.setBirthdayCity("city");
		//entity.setBirthdayCountry(CountryEnum.valueOf("France"));
		entity.setEmail("mail");
		entity.setEvents(new ArrayList<Event>());
		entity.setFax("fax");
		entity.setFirstName("firstname");
		entity.setLastName("lastname");
		entity.setMobilePhone("mobile");
		//entity.setNationality(NationalityEnum.francaise);
		entity.setPhone("phone");
		//entity.setSex(SexEnum.MALE);
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("firstName" , "name");
		searchParams.setField("lastName" , "name");
		return searchParams;
	}

	@Override
	protected void compareEntity(Candidate entity1, Candidate entity2) {
		assertTrue(conditionCheck(entity1.getContactOriginIG2K(),entity2.getContactOriginIG2K()));
		assertTrue(conditionCheck(entity1.getFormationCenter(),entity2.getFormationCenter()));
		assertTrue(conditionCheck(entity1.getRoom(),entity2.getRoom()));
		assertTrue(conditionCheck(entity1.isOtherFormation(),entity2.isOtherFormation()));
		assertTrue(conditionCheck(entity1.isAccepted(),entity2.isAccepted()));
		assertTrue(conditionCheck(entity1.getProfessionFather(),entity2.getProfessionFather()));
		assertTrue(conditionCheck(entity1.getProfessionMother(),entity2.getProfessionMother()));
		assertTrue(conditionCheck(entity1.getCourseOption(),entity2.getCourseOption()));
		assertTrue(conditionCheck(entity1.getAddressPersonnal(), entity2.getAddressPersonnal()));
		assertTrue(conditionCheck(entity1.getBirthdayCity(), entity2.getBirthdayCity()));
		assertTrue(conditionCheck(entity1.getBirthdayCountry(), entity2.getBirthdayCountry()));
		assertTrue(conditionCheck(entity1.getBirthdayDate(), entity2.getBirthdayDate()));
		assertTrue(conditionCheck(entity1.getBirthdayDepartment(), entity2.getBirthdayDepartment()));
		assertTrue(conditionCheck(entity1.getEmail(), entity2.getEmail()));
		assertTrue(conditionCheck(entity1.getEvents(), entity2.getEvents()));
		assertTrue(conditionCheck(entity1.getFax(), entity2.getFax()));
		assertTrue(conditionCheck(entity1.getFirstName(), entity2.getFirstName()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getLastName(), entity2.getLastName()));
		assertTrue(conditionCheck(entity1.getMobilePhone(), entity2.getMobilePhone()));
		assertTrue(conditionCheck(entity1.getModifications(), entity2.getModifications()));
		assertTrue(conditionCheck(entity1.getNationality(), entity2.getNationality()));
		assertTrue(conditionCheck(entity1.getPhone(), entity2.getPhone()));
		assertTrue(conditionCheck(entity1.getSex(), entity2.getSex()));
	}

	//@Override
	protected Collection<Candidate> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Candidate createEntity(int index) {
		// TODO enclosing_package.CandidateDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.CandidateDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected Candidate createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.CandidateDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.CandidateDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}
}
