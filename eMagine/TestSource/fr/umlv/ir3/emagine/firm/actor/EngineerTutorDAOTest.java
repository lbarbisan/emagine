package fr.umlv.ir3.emagine.firm.actor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class EngineerTutorDAOTest extends BaseDAOTest<EngineerTutor>  {

	EngineerTutorDAO dao;
	
	public EngineerTutorDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new EngineerTutorDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<EngineerTutor> getDAO() {
		return dao;
	}

	@Override
	protected EngineerTutor createEntity() {
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("postal");
		address.setStreet("street");
		
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		EngineerTutor engineerTutor = new EngineerTutor();
		engineerTutor.setAddressPersonnal(address);
		engineerTutor.setAddressProfessional(address);
		engineerTutor.setBirthdayCity("city");
		engineerTutor.setBirthdayCountry(CountryEnum.FR);
		engineerTutor.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		engineerTutor.setBirthdayDepartment(DepartmentEnum.D01);
		engineerTutor.setEmail("mail");
		engineerTutor.setEvents(new ArrayList<Event>());
		engineerTutor.setFax("fax");
		engineerTutor.setFirstName("firstname");
		engineerTutor.setLastName("lastname");
		engineerTutor.setMobilePhone("mobile");
		engineerTutor.setNationality(NationalityEnum.FRENCH);
		engineerTutor.setPhone("phone");
		engineerTutor.setSex(SexEnum.MALE);
		engineerTutor.setFirm(firm);
		engineerTutor.setFunction("function");
		engineerTutor.setApprentice(new ArrayList<Apprentice>());
		
		return engineerTutor;
	}

	@Override
	protected Collection<EngineerTutor> createEntityCollection() {
		
		ArrayList <EngineerTutor> list = new ArrayList <EngineerTutor>();
		
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		Address address1 = new Address();
		address1.setCity("city");
		address1.setCountry(CountryEnum.FR);
		address1.setDepartment(DepartmentEnum.D01);
		address1.setPostalCode("postal");
		address1.setStreet("street");
		Address address2 = new Address();
		address2.setCity("city");
		address2.setCountry(CountryEnum.FR);
		address2.setDepartment(DepartmentEnum.D01);
		address2.setPostalCode("postal");
		address2.setStreet("street");
		
		EngineerTutor engineerTutor1 = new EngineerTutor();
		engineerTutor1.setAddressPersonnal(address1);
		engineerTutor1.setAddressProfessional(address1);
		engineerTutor1.setBirthdayCity("city");
		engineerTutor1.setBirthdayCountry(CountryEnum.FR);
		engineerTutor1.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		engineerTutor1.setBirthdayDepartment(DepartmentEnum.D01);
		engineerTutor1.setEmail("mail");
		engineerTutor1.setEvents(new ArrayList<Event>());
		engineerTutor1.setFax("fax");
		engineerTutor1.setFirstName("firstname");
		engineerTutor1.setLastName("lastname");
		engineerTutor1.setMobilePhone("mobile");
		engineerTutor1.setNationality(NationalityEnum.FRENCH);
		engineerTutor1.setPhone("phone");
		engineerTutor1.setSex(SexEnum.MALE);
		engineerTutor1.setFirm(firm);
		engineerTutor1.setFunction("function");
		engineerTutor1.setApprentice(new ArrayList<Apprentice>());
		
		EngineerTutor engineerTutor2 = new EngineerTutor();
		engineerTutor2.setAddressPersonnal(address2);
		engineerTutor2.setAddressProfessional(address2);
		engineerTutor2.setBirthdayCity("city");
		engineerTutor2.setBirthdayCountry(CountryEnum.FR);
		engineerTutor2.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		engineerTutor2.setBirthdayDepartment(DepartmentEnum.D01);
		engineerTutor2.setEmail("mail");
		engineerTutor2.setEvents(new ArrayList<Event>());
		engineerTutor2.setFax("fax");
		engineerTutor2.setFirstName("firstname");
		engineerTutor2.setLastName("lastname");
		engineerTutor2.setMobilePhone("mobile");
		engineerTutor2.setNationality(NationalityEnum.FRENCH);
		engineerTutor2.setPhone("phone");
		engineerTutor2.setSex(SexEnum.MALE);
		engineerTutor2.setFirm(firm);
		engineerTutor2.setFunction("function");
		engineerTutor2.setApprentice(new ArrayList<Apprentice>());
		
		list.add(engineerTutor1);
		list.add(engineerTutor2);
		
		return list;
	}

	@Override
	protected void updateEntity(EngineerTutor entity) {
		Address address = new Address();
		address.setCity("new city");
		address.setCountry(CountryEnum.EN);
		address.setDepartment(DepartmentEnum.D02);
		address.setPostalCode("new postal");
		address.setStreet("new street");
		entity.setAddressPersonnal(address);
		entity.setAddressProfessional(address);
		
		entity.setBirthdayCity("new city");
		entity.setBirthdayCountry(CountryEnum.FR);
		entity.setEmail("new mail");
		entity.setEvents(new ArrayList<Event>());
		entity.setFax("new fax");
		entity.setFirstName("new firstname");
		entity.setLastName("new lastname");
		entity.setMobilePhone("new mobile");
		entity.setNationality(NationalityEnum.FRENCH);
		entity.setPhone("new phone");
		entity.setSex(SexEnum.MALE);
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("firstName" , "firstName");
		return searchParams;
	}

	@Override
	protected void compareEntity(EngineerTutor entity1, EngineerTutor entity2) {
		assertTrue(conditionCheck(entity1.getAddressPersonnal(), entity2.getAddressPersonnal()));
		assertTrue(conditionCheck(entity1.getAddressProfessional(), entity2.getAddressProfessional()));
		assertTrue(conditionCheck(entity1.getFax(), entity2.getFax()));
		assertTrue(conditionCheck(entity1.getBirthdayCity(), entity2.getBirthdayCity()));
		assertTrue(conditionCheck(entity1.getBirthdayCountry(), entity2.getBirthdayDate()));
		assertTrue(conditionCheck(entity1.getBirthdayDepartment(), entity2.getBirthdayDepartment()));
		assertTrue(conditionCheck(entity1.getEmail(), entity2.getEmail()));
		assertTrue(conditionCheck(entity1.getEvents(), entity2.getEvents()));
		assertTrue(conditionCheck(entity1.getFirm(), entity2.getFirm()));
		assertTrue(conditionCheck(entity1.getFirstName(), entity2.getFirstName()));
		assertTrue(conditionCheck(entity1.getFunction(), entity2.getFunction()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getLastName(), entity2.getLastName()));
		assertTrue(conditionCheck(entity1.getMobilePhone(), entity2.getMobilePhone()));
		assertTrue(conditionCheck(entity1.getNationality(), entity2.getNationality()));
		assertTrue(conditionCheck(entity1.getPhone(), entity2.getPhone()));
		assertTrue(conditionCheck(entity1.getSex(), entity2.getSex()));
		assertTrue(conditionCheck(entity1.getApprentice(), entity2.getApprentice()));
	}

}
