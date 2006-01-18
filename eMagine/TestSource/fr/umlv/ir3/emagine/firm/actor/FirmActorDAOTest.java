package fr.umlv.ir3.emagine.firm.actor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

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

public class FirmActorDAOTest extends BaseDAOTest<FirmActor> {

	FirmActorDAO dao;
	
	public FirmActorDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new FirmActorDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<FirmActor> getDAO() {
		return dao;
	}

	//@Override
	protected FirmActor createEntity() {
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.valueOf("FR"));
		address.setDepartment(DepartmentEnum.valueOf("D01"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		FirmActor firmActor = new FirmActor();
		firmActor.setAddressPersonnal(address);
		firmActor.setAddressProfessional(address);
		firmActor.setBirthdayCity("city");
		firmActor.setBirthdayCountry(CountryEnum.valueOf("FR"));
		firmActor.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		firmActor.setBirthdayDepartment(DepartmentEnum.valueOf("D01"));
		firmActor.setEmail("mail");
		firmActor.setEvents(new ArrayList<Event>());
		firmActor.setFax("fax");
		firmActor.setFirstName("firstname");
		firmActor.setLastName("lastname");
		firmActor.setMobilePhone("mobile");
		firmActor.setNationality(NationalityEnum.FRENCH);
		firmActor.setPhone("phone");
		firmActor.setSex(SexEnum.MALE);
		firmActor.setFirm(firm);
		firmActor.setFunction("function");
		
		return firmActor;
	}

	//@Override
	protected Collection<FirmActor> createEntityCollection() {
		
		ArrayList <FirmActor> list = new ArrayList <FirmActor>();
		
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		Address address1 = new Address();
		address1.setCity("city");
		address1.setCountry(CountryEnum.valueOf("FR"));
		address1.setDepartment(DepartmentEnum.valueOf("D01"));
		address1.setPostalCode("postal");
		address1.setStreet("street");
		Address address2 = new Address();
		address2.setCity("city");
		address2.setCountry(CountryEnum.valueOf("FR"));
		address2.setDepartment(DepartmentEnum.valueOf("D01"));
		address2.setPostalCode("postal");
		address2.setStreet("street");
		
		FirmActor firmActor1 = new FirmActor();
		firmActor1.setAddressPersonnal(address1);
		firmActor1.setAddressProfessional(address1);
		firmActor1.setBirthdayCity("city");
		firmActor1.setBirthdayCountry(CountryEnum.valueOf("FR"));
		firmActor1.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		firmActor1.setBirthdayDepartment(DepartmentEnum.valueOf("D01"));
		firmActor1.setEmail("mail");
		firmActor1.setEvents(new ArrayList<Event>());
		firmActor1.setFax("fax");
		firmActor1.setFirstName("firstname");
		firmActor1.setLastName("lastname");
		firmActor1.setMobilePhone("mobile");
		firmActor1.setNationality(NationalityEnum.FRENCH);
		firmActor1.setPhone("phone");
		firmActor1.setSex(SexEnum.MALE);
		firmActor1.setFirm(firm);
		firmActor1.setFunction("function");
		
		FirmActor firmActor2 = new FirmActor();
		firmActor2.setAddressPersonnal(address2);
		firmActor2.setAddressProfessional(address2);
		firmActor2.setBirthdayCity("city");
		firmActor2.setBirthdayCountry(CountryEnum.valueOf("FR"));
		firmActor2.setBirthdayDate(GregorianCalendar.getInstance().getTime());
		firmActor2.setBirthdayDepartment(DepartmentEnum.valueOf("D01"));
		firmActor2.setEmail("mail");
		firmActor2.setEvents(new ArrayList<Event>());
		firmActor2.setFax("fax");
		firmActor2.setFirstName("firstname");
		firmActor2.setLastName("lastname");
		firmActor2.setMobilePhone("mobile");
		firmActor2.setNationality(NationalityEnum.FRENCH);
		firmActor2.setPhone("phone");
		firmActor2.setSex(SexEnum.MALE);
		firmActor2.setFirm(firm);
		firmActor2.setFunction("function");
		
		list.add(firmActor1);
		list.add(firmActor2);
		
		return list;
	}

	@Override
	protected void updateEntity(FirmActor entity) {
		Address address = new Address();
		address.setCity("new city");
		address.setCountry(CountryEnum.valueOf("EN"));
		address.setDepartment(DepartmentEnum.valueOf("D02"));
		address.setPostalCode("new postal");
		address.setStreet("new street");
		entity.setAddressPersonnal(address);
		entity.setAddressProfessional(address);
		
		entity.setBirthdayCity("new city");
		entity.setBirthdayCountry(CountryEnum.valueOf("FR"));
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
	protected void compareEntity(FirmActor entity1, FirmActor entity2) {
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
	}

	//@Override
	protected Collection<FirmActor> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected FirmActor createEntity(int index) {
		// TODO enclosing_package.FirmActorDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.FirmActorDAOTest.createEntity(enclosing_method_arguments)");
		return  null;
	}

	@Override
	protected FirmActor createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.FirmActorDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.FirmActorDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
