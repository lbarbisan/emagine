package fr.umlv.ir3.emagine.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class EventDAOTest extends BaseDAOTest<Event> {

	EventDAO dao;
	
	public EventDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new EventDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<Event> getDAO() {
		return dao;
	}

	//@Override
	protected Event createEntity() {
		ArrayList<BaseEntity> sources = new ArrayList<BaseEntity>();
		User user = new User();
		user.setLogin("login");
		user.setEmail("email");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPassword("password");
		sources.add(user);
		Event entity = new Event();
		entity.setUserComment("comment");
		entity.setDate(GregorianCalendar.getInstance().getTime());
		//entity.setSources(sources);
		entity.setTitle("title");
		//entity.setType(EventTypeEnum.INFO);
		return entity;
	}

	//@Override
	protected Collection<Event> createEntityCollection() {
		ArrayList<Event> list = new ArrayList<Event>();
		ArrayList<BaseEntity> sources = new ArrayList<BaseEntity>();
		User user = new User();
		user.setLogin("login");
		user.setEmail("email");
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setPassword("password");
		sources.add(user);
		
		Event entity1 = new Event();
		entity1.setUserComment("comment1");
		entity1.setDate(GregorianCalendar.getInstance().getTime());
		//entity1.setSources(sources);
		entity1.setTitle("title1");
		//entity1.setType(EventTypeEnum.INFO);
		
		Event entity2 = new Event();
		entity2.setUserComment("comment2");
		entity2.setDate(GregorianCalendar.getInstance().getTime());
		//entity2.setSources(sources);
		entity2.setTitle("title2");
		//entity2.setType(EventTypeEnum.INFO);
		
		list.add(entity1);
		list.add(entity2);
		
		return list;
	}

	@Override
	protected void updateEntity(Event entity) {
		entity.setUserComment("new comment");
		entity.setDate(GregorianCalendar.getInstance().getTime());
		entity.setTitle("new title");
		//entity.setType(EventTypeEnum.INFO);
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("title" , "title%");
		searchParams.setField("comment" , "comment%");
		return searchParams;
	}

	@Override
	protected void compareEntity(Event entity1, Event entity2) {
		assertTrue(conditionCheck(entity1.getUserComment(), entity2.getUserComment()));
		assertTrue(conditionCheck(entity1.getDate(), entity2.getDate()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getSources(), entity2.getSources()));
		assertTrue(conditionCheck(entity1.getTitle(), entity2.getTitle()));
		assertTrue(conditionCheck(entity1.getType(), entity2.getType()));
	}

	//@Override
	protected Collection<Event> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Event createEntity(int index) {
		// TODO enclosing_package.EventDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.EventDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected Event createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.EventDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.EventDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
