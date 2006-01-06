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

	FormationCenterDAO dao;
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

	@Override
	protected FormationCenter createEntity() {
		FormationCenter formCenter = new FormationCenter();
		formCenter.setName("FormCenter");
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("postal");
		address.setStreet("street");
		formCenter.setAddress(address);
		formCenter.setPhone("0000000000");
		List<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room());
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates.add(new Candidate());
		return formCenter;
	}

	@Override
	protected Collection<FormationCenter> createEntityCollection() {
		
		ArrayList<FormationCenter> list = new ArrayList<FormationCenter>();

		FormationCenter formCenter1 = new FormationCenter();
		formCenter1.setName("FormCenter");
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("postal");
		address.setStreet("street");
		formCenter1.setAddress(address);
		formCenter1.setPhone("0000000000");
		List<Room> rooms1 = new ArrayList<Room>();
		rooms1.add(new Room());
		List<Candidate> candidates1 = new ArrayList<Candidate>();
		candidates1.add(new Candidate());	
	
		FormationCenter formCenter2 = new FormationCenter();
		formCenter2.setName("FormCenter");
		formCenter2.setAddress(address);
		formCenter2.setPhone("0000000000");
		List<Room> rooms2 = new ArrayList<Room>();
		rooms2.add(new Room());
		List<Candidate> candidates2 = new ArrayList<Candidate>();
		candidates2.add(new Candidate());
		
		list.add(formCenter1);
		list.add(formCenter2);
		
		return list;
	}

	@Override
	protected void updateEntity(FormationCenter entity) {
		entity.setName("FormCenter");
		Address address = new Address();
		address.setCity("city");
		address.setCountry(CountryEnum.FR);
		address.setDepartment(DepartmentEnum.D01);
		address.setPostalCode("postal");
		address.setStreet("street");
		entity.setAddress(address);
		entity.setPhone("0000000000");
		List<Room> rooms1 = new ArrayList<Room>();
		rooms1.add(new Room());
		List<Candidate> candidates1 = new ArrayList<Candidate>();
		candidates1.add(new Candidate());		}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		//TODO comment je fais pour savoir quelle est la clef??
		searchParams.setField("JustificationComment" , "test de date");
		return searchParams;
	}

	@Override
	protected void compareEntity(FormationCenter entity1, FormationCenter entity2) {
		//assertTrue(conditionCheck(entity1.getCandidates(),entity2.getCandidates()));
		//TODO je comprend pas !!
	}

}
