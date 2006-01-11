package fr.umlv.ir3.emagine.apprentice.candidate.room;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class RoomDAOTest extends BaseDAOTest<Room> {
	
	RoomDAO dao;

	public RoomDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new RoomDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<Room> getDAO() {
		return dao;
	}

	@Override
	protected Room createEntity() {
		// TODO candidats?
		Room entity = new Room();
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		FormationCenter center = new FormationCenter();
		center.setName("Paris");
		center.setPhone("0123456789");
		entity.setCandidates(candidates);
		entity.setCapacity(Integer.valueOf(100));
		entity.setFormationCenter(center);
		entity.setName("room");
		return entity;
	}

	@Override
	protected Collection<Room> createEntityCollection() {
		
		ArrayList<Room> list = new ArrayList<Room>();
		
		ArrayList<Candidate> candidates = new ArrayList<Candidate>();
		FormationCenter center = new FormationCenter();
		center.setName("Paris");
		center.setPhone("0123456789");
		
		Room entity1 = new Room();
		entity1.setCandidates(candidates);
		entity1.setCapacity(Integer.valueOf(100));
		entity1.setFormationCenter(center);
		entity1.setName("room1");
		
		Room entity2 = new Room();
		entity2.setCandidates(candidates);
		entity2.setCapacity(Integer.valueOf(111));
		entity2.setFormationCenter(center);
		entity2.setName("room2");
		
		Room entity3 = new Room();
		entity3.setCandidates(candidates);
		entity3.setCapacity(Integer.valueOf(10));
		entity3.setFormationCenter(center);
		entity3.setName("room3");

		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		return list;
	}

	@Override
	protected void updateEntity(Room entity) {
		entity.setCapacity(Integer.valueOf(5));
		entity.setName("new name of room");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("name" , "room*");
		return searchParams;
	}

	@Override
	protected void compareEntity(Room entity1, Room entity2) {
		assertTrue(conditionCheck(entity1.getCandidates(), entity2.getCandidates()));
		assertTrue(conditionCheck(entity1.getCapacity(), entity2.getCapacity()));
		assertTrue(conditionCheck(entity1.getFormationCenter(), entity2.getFormationCenter()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getName(), entity2.getName()));
		assertTrue(conditionCheck(entity1.getNumberOfFreeSits(), entity2.getNumberOfFreeSits()));
	}

}
