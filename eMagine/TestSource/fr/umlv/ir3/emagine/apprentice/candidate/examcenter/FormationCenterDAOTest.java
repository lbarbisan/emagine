package fr.umlv.ir3.emagine.apprentice.candidate.examcenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class FormationCenterDAOTest extends BaseDAOTest<FormationCenter> {

	private FormationCenterDAO dao;
	
	public FormationCenterDAOTest(String arg0) {
		super(arg0);
	}
	protected void setUp() throws Exception {
		dao = new FormationCenterDAO(); 
		super.setUp();
	}
	protected void tearDown() throws Exception {
		dao = null;
		super.tearDown();
	}
	@Override
	protected BaseDAO<FormationCenter> getDAO() {
		return dao;
	}

	protected Collection<FormationCenter> createEntityCollection() {
		
		ArrayList<FormationCenter> list = new ArrayList<FormationCenter>();

		List<Room> rooms1 = new ArrayList<Room>();
		rooms1.add(new Room());
		
		List<Candidate> candidates1 = new ArrayList<Candidate>();
		candidates1.add(new Candidate());
		
		Address address1 = new Address();
		address1.setCity("city1");
		//address1.setCountry(CountryEnum.valueOf("France"));
		//address1.setDepartment(DepartmentEnum.valueOf("D1"));
		address1.setPostalCode("postal1");
		address1.setStreet("street1");
		
		FormationCenter formCenter1 = new FormationCenter();
		formCenter1.setName("FormCenter1");
		formCenter1.setAddress(address1);
		formCenter1.setPhone("0000000000");
		formCenter1.setRooms(rooms1);
		formCenter1.setCandidate(candidates1);
	
		List<Room> rooms2 = new ArrayList<Room>();
		rooms2.add(new Room());
		
		List<Candidate> candidates2 = new ArrayList<Candidate>();
		candidates2.add(new Candidate());
		
		Address address2 = new Address();
		address2.setCity("city3");
		//address2.setCountry(CountryEnum.valueOf("France"));
		//address2.setDepartment(DepartmentEnum.valueOf("D1"));
		address2.setPostalCode("postal3");
		address2.setStreet("street3");
		
		FormationCenter formCenter2 = new FormationCenter();
		formCenter2.setName("FormCenter");
		formCenter2.setAddress(address2);
		formCenter2.setPhone("0000000000");
		formCenter2.setRooms(rooms2);
		formCenter2.setCandidate(candidates2);
		
		list.add(formCenter1);
		list.add(formCenter2);
		
		return list;
	}

	@Override
	protected void updateEntity(FormationCenter entity)
	{
		List<Room> rooms1 = new ArrayList<Room>();
		rooms1.add(new Room());
		
		List<Candidate> candidates1 = new ArrayList<Candidate>();
		candidates1.add(new Candidate());
		
		Address address = new Address();
		address.setCity("city");
		//address.setCountry(CountryEnum.valueOf("France"));
		//address.setDepartment(DepartmentEnum.valueOf("D1"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		entity.setName("FormCenter");
		entity.setAddress(address);
		entity.setPhone("0000000000");
		entity.setCandidate(candidates1);
		entity.setRooms(rooms1);
		
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("City" , "city2");
		return searchParams;
	}

	@Override
	protected void compareEntity(FormationCenter entity1, FormationCenter entity2) {
		//assertTrue(conditionCheck(entity1.getCandidates(),entity2.getCandidates()));
		assertTrue(conditionCheck(entity1.getId() ,entity2.getId()));
//		assertTrue(conditionCheck(entity1.getAddress() ,entity2.getAddress()));
//		assertTrue(conditionCheck(entity1.getCandidates() ,entity2.getCandidates()));
//		assertTrue(conditionCheck(entity1.getCurrentModification() ,entity2.getCurrentModification()));
//		assertTrue(conditionCheck(entity1.getModifications() ,entity2.getModifications()));
//		
	}

	//@Override
	protected Collection<FormationCenter> createForFindEntityCollection() {
		
		ArrayList<FormationCenter> list = new ArrayList<FormationCenter>();
		
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room());
		
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(new Candidate());
		
		Address address = new Address();
		address.setCity("city2");
		//address.setCountry(CountryEnum.valueOf("France"));
		//address.setDepartment(DepartmentEnum.valueOf("D1"));
		address.setPostalCode("postal");
		address.setStreet("street");
		
		FormationCenter formationCenter = new FormationCenter();
		formationCenter.setName("FormationCenter");
		formationCenter.setAddress(address);
		formationCenter.setPhone("0000000000");
		
		list.add(formationCenter);
		
		return list;
			
	}
	@Override
	protected FormationCenter createEntity(int index) {
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room());
		
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(new Candidate());
		
		Address address = new Address();
		address.setCity("city" + index);
		//address.setCountry(CountryEnum.valueOf("France"));
		//address.setDepartment(DepartmentEnum.valueOf("D"+ index));
		address.setPostalCode("postal"+ index);
		address.setStreet("street" + index);
		
		FormationCenter formCenter = new FormationCenter();
		formCenter.setName("FormCenter" + index);
		formCenter.setAddress(address);
		formCenter.setPhone("0000000000");
		formCenter.setRooms(rooms);
		formCenter.setCandidate(candidates);
		
		
		return formCenter;
	}
	@Override
	protected FormationCenter createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.FormationCenterDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.FormationCenterDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
