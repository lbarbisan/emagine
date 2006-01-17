package fr.umlv.ir3.emagine.teachertutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class TeacherTutorDAOTest extends BaseDAOTest<TeacherTutor> {

	TeacherTutorDAO dao;
	
	public TeacherTutorDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new TeacherTutorDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<TeacherTutor> getDAO() {
		return dao;
	}

	//@Override
	protected TeacherTutor createEntity() {
		
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.enumFor("FR"));
		address.setDepartment(DepartmentEnum.enumFor("D01"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		TeacherTutor teacherTutor = new TeacherTutor();
		teacherTutor.setAddressPersonnal(address);
		teacherTutor.setAddressProfessional(address);
		
		// TODO setApprentice();
		//teacherTutor.setApprentice();
		teacherTutor.setBirthdayCity("city");
		teacherTutor.setBirthdayCountry(CountryEnum.enumFor("FR"));
		teacherTutor.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		teacherTutor.setBirthdayDepartment(DepartmentEnum.enumFor("D01"));
		teacherTutor.setEmail("mail");
		teacherTutor.setEvents(new ArrayList<Event>());
		teacherTutor.setFax("fax");
		teacherTutor.setFirstName("firstname");
		teacherTutor.setLastName("lastname");
		teacherTutor.setMobilePhone("mobile");
		teacherTutor.setNationality(NationalityEnum.FRENCH);
		teacherTutor.setPhone("phone");
		teacherTutor.setSex(SexEnum.MALE);
		return teacherTutor;
	}

	//@Override
	protected Collection<TeacherTutor> createEntityCollection() {
		
		ArrayList<TeacherTutor> list = new ArrayList<TeacherTutor>();
		
		Address address1 = new Address();
		address1.setCity("city");
		address1.setCountry(CountryEnum.enumFor("FR"));
		address1.setDepartment(DepartmentEnum.enumFor("D01"));
		address1.setPostalCode("postal");
		address1.setStreet("street");
		Address address2 = new Address();
		address2.setCity("city");
		address2.setCountry(CountryEnum.enumFor("FR"));
		address2.setDepartment(DepartmentEnum.enumFor("D01"));
		address2.setPostalCode("postal");
		address2.setStreet("street");
		
		TeacherTutor teacherTutor1 = new TeacherTutor();
		teacherTutor1.setAddressPersonnal(address1);
		teacherTutor1.setAddressProfessional(address1);
		// TODO setApprentice();
		//teacherTutor.setApprentice();
		teacherTutor1.setBirthdayCity("city");
		teacherTutor1.setBirthdayCountry(CountryEnum.enumFor("FR"));
		teacherTutor1.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		teacherTutor1.setBirthdayDepartment(DepartmentEnum.enumFor("D01"));
		teacherTutor1.setEmail("mail");
		teacherTutor1.setEvents(new ArrayList<Event>());
		teacherTutor1.setFax("fax");
		teacherTutor1.setFirstName("firstname");
		teacherTutor1.setLastName("lastname");
		teacherTutor1.setMobilePhone("mobile");
		teacherTutor1.setNationality(NationalityEnum.FRENCH);
		teacherTutor1.setPhone("phone");
		teacherTutor1.setSex(SexEnum.MALE);
		
		TeacherTutor teacherTutor2 = new TeacherTutor();
		teacherTutor2.setAddressPersonnal(address2);
		teacherTutor2.setAddressProfessional(address2);
		// TODO setApprentice();
		//teacherTutor.setApprentice();
		teacherTutor2.setBirthdayCity("city");
		teacherTutor2.setBirthdayCountry(CountryEnum.enumFor("FR"));
		teacherTutor2.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		teacherTutor2.setBirthdayDepartment(DepartmentEnum.enumFor("D01"));
		teacherTutor2.setEmail("mail");
		teacherTutor2.setEvents(new ArrayList<Event>());
		teacherTutor2.setFax("fax");
		teacherTutor2.setFirstName("firstname");
		teacherTutor2.setLastName("lastname");
		teacherTutor2.setMobilePhone("mobile");
		teacherTutor2.setNationality(NationalityEnum.FRENCH);
		teacherTutor2.setPhone("phone");
		teacherTutor2.setSex(SexEnum.MALE);
		
		list.add(teacherTutor1);
		list.add(teacherTutor2);
		
		return list;
	}

	@Override
	protected void updateEntity(TeacherTutor entity) {
		Address address = new Address();
		address.setCity("new city");
		address.setCountry(CountryEnum.enumFor("EN"));
		address.setDepartment(DepartmentEnum.enumFor("D02"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		entity.setAddressPersonnal(address);
		entity.setAddressProfessional(address);
		
		// TODO setApprentice();
		//teacherTutor.setApprentice();
		entity.setBirthdayCity("new city");
		entity.setBirthdayCountry(CountryEnum.enumFor("FR"));
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
		searchParams.setField("firstName" , "name");
		searchParams.setField("lastName" , "name");
		return searchParams;
	}

	@Override
	protected void compareEntity(TeacherTutor entity1, TeacherTutor entity2) {
		assertTrue(conditionCheck(entity1.getAddressPersonnal(), entity2.getAddressPersonnal()));
		assertTrue(conditionCheck(entity1.getAddressProfessional(), entity2.getAddressProfessional()));
		assertTrue(conditionCheck(entity1.getApprentice(), entity2.getApprentice()));
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
	protected Collection<TeacherTutor> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected TeacherTutor createEntity(int index) {
		// TODO enclosing_package.TeacherTutorDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.TeacherTutorDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected TeacherTutor createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.TeacherTutorDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.TeacherTutorDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}
}
