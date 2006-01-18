package fr.umlv.ir3.emagine.firm;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.event.Event;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class FirmDAOTest extends BaseDAOTest<Firm> {

	FirmDAO dao;
	
	public FirmDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new FirmDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<Firm> getDAO() {
		return dao;
	}

	//@Override
	protected Firm createEntity() {
		Firm firm = new Firm();
		
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.valueOf("FR"));
		address.setDepartment(DepartmentEnum.valueOf("D01"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		Firm child = new Firm();
		child.setName("child");
		Firm mother = new Firm();
		mother.setName("mother");
		
		firm.setAddress(address);
		firm.setApprentices(new ArrayList<Apprentice>());
		firm.setChildfirm(child);
		firm.setEmail("email");
		firm.setEvents(new ArrayList<Event>());
		firm.setFax("fac");
		firm.setfirmActor(new ArrayList<FirmActor>());
		firm.setJobs(new ArrayList<Job>());
		firm.setMotherfirm(mother);
		firm.setName("name");
		firm.setPhone("phone");
		firm.setWebSite("http://website.fr");
		
		return firm;
	}

	//@Override
	protected Collection<Firm> createEntityCollection() {
		
		ArrayList<Firm> list = new ArrayList<Firm>();
		
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.valueOf("FR"));
		address.setDepartment(DepartmentEnum.valueOf("D01"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		Firm child = new Firm();
		child.setName("child");
		Firm mother = new Firm();
		mother.setName("mother");
		
		Firm firm1 = new Firm();
		firm1.setAddress(address);
		firm1.setApprentices(new ArrayList<Apprentice>());
		firm1.setChildfirm(child);
		firm1.setEmail("email1");
		firm1.setEvents(new ArrayList<Event>());
		firm1.setFax("fac1");
		firm1.setfirmActor(new ArrayList<FirmActor>());
		firm1.setJobs(new ArrayList<Job>());
		firm1.setMotherfirm(mother);
		firm1.setName("name1");
		firm1.setPhone("phone1");
		firm1.setWebSite("http://website1.fr");
		
		Firm firm2 = new Firm();
		firm2.setAddress(address);
		firm2.setApprentices(new ArrayList<Apprentice>());
		firm2.setChildfirm(child);
		firm2.setEmail("email2");
		firm2.setEvents(new ArrayList<Event>());
		firm2.setFax("fac2");
		firm2.setfirmActor(new ArrayList<FirmActor>());
		firm2.setJobs(new ArrayList<Job>());
		firm2.setMotherfirm(mother);
		firm2.setName("name2");
		firm2.setPhone("phone2");
		firm2.setWebSite("http://website2.fr");
		
		Firm firm3 = new Firm();
		firm3.setAddress(address);
		firm3.setApprentices(new ArrayList<Apprentice>());
		firm3.setChildfirm(child);
		firm3.setEmail("email3");
		firm3.setEvents(new ArrayList<Event>());
		firm3.setFax("fac3");
		firm3.setfirmActor(new ArrayList<FirmActor>());
		firm3.setJobs(new ArrayList<Job>());
		firm3.setMotherfirm(mother);
		firm3.setName("name3");
		firm3.setPhone("phone3");
		firm3.setWebSite("http://website3.fr");
		
		list.add(firm1);
		list.add(firm2);
		list.add(firm3);
		return list;
	}

	@Override
	protected void updateEntity(Firm entity) {
		
		entity.setEmail("new email");
		entity.setFax("new fax");
		entity.setName("new name");
		entity.setPhone("new phone");
		entity.setWebSite("http://newwebsite.fr");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("name" , "*");
		return searchParams;
	}

	@Override
	protected void compareEntity(Firm entity1, Firm entity2) {
		assertTrue(conditionCheck(entity1.getAddress(), entity2.getAddress()));
		assertTrue(conditionCheck(entity1.getApprentices(), entity2.getApprentices()));
		assertTrue(conditionCheck(entity1.getChildfirm(), entity2.getChildfirm()));
		assertTrue(conditionCheck(entity1.getEmail(), entity2.getEmail()));
		assertTrue(conditionCheck(entity1.getEvents(), entity2.getEvents()));
		assertTrue(conditionCheck(entity1.getFax(), entity2.getFax()));
		assertTrue(conditionCheck(entity1.getFirmActors(), entity2.getFirmActors()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getJobs(), entity2.getJobs()));
		assertTrue(conditionCheck(entity1.getMotherFirm(), entity2.getMotherFirm()));
		assertTrue(conditionCheck(entity1.getName(), entity2.getName()));
		assertTrue(conditionCheck(entity1.getPhone(), entity2.getPhone()));
		assertTrue(conditionCheck(entity1.getWebSite(), entity2.getWebSite()));
	}

	//@Override
	protected Collection<Firm> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Firm createEntity(int index) {
		// TODO enclosing_package.FirmDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.FirmDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected Firm createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.FirmDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.FirmDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
