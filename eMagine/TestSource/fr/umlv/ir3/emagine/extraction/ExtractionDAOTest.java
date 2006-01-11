package fr.umlv.ir3.emagine.extraction;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ExtractionDAOTest extends BaseDAOTest<Extraction> {

	ExtractionDAO dao;
	User user;
	
	public ExtractionDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new ExtractionDAO();
		user = new User();
		user.setFirstName("first name");
		user.setLogin("login");
		user.setPassword("password");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
		user = null;
	}

	@Override
	protected BaseDAO<Extraction> getDAO() {
		return dao;
	}

	@Override
	protected Extraction createEntity() {
		Extraction entity = new Extraction();
		ArrayList<String> columns = new ArrayList<String>();
		
		columns.add("id");
		columns.add("firstname");
		columns.add("lastname");
		
		entity.setColumns(columns);
		entity.setUser(user);
		entity.setViewName(ViewEnum.APPRENTICE);
		return entity;
	}

	@Override
	protected Collection<Extraction> createEntityCollection() {
		ArrayList<Extraction> list = new ArrayList<Extraction>();
		
		Extraction extraction1 = new Extraction();
		ArrayList<String> columns = new ArrayList<String>();
		
		columns.add("id");
		columns.add("firstname");
		columns.add("lastname");
		
		ArrayList<String> columns2 = new ArrayList<String>();
		
		columns2.add("id");
		columns2.add("mail");
		columns2.add("fax");
		
		extraction1.setColumns(columns);
		extraction1.setUser(user);
		extraction1.setViewName(ViewEnum.APPRENTICE);
		
		
		Extraction extraction2 = new Extraction();
		
		extraction2.setColumns(columns2);
		extraction2.setUser(user);
		extraction2.setViewName(ViewEnum.FIRM);
		
		list.add(extraction1);
		list.add(extraction2);
		
		return list;
	}

	@Override
	protected void updateEntity(Extraction entity) {
		ArrayList<String> columns = new ArrayList<String>();
		
		columns.add("new column");
		columns.add("new column again");
		columns.add("new column again again");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("lastname" , "lastname");
		return searchParams;
	}

	@Override
	protected void compareEntity(Extraction entity1, Extraction entity2) {
		assertTrue(conditionCheck(entity1.getColumns(), entity2.getColumns()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getUser(), entity2.getUser()));
		assertTrue(conditionCheck(entity1.getViewName(), entity2.getViewName()));
	}

}
