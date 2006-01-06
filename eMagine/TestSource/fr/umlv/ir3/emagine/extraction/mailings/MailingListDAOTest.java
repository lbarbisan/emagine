package fr.umlv.ir3.emagine.extraction.mailings;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.person.Person;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class MailingListDAOTest extends BaseDAOTest<MailingList> {

	MailingListDAO dao;
	
	public MailingListDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new MailingListDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<MailingList> getDAO() {
		return dao;
	}

	@Override
	protected MailingList createEntity() {
		MailingList entity = new MailingList();
		entity.setComment("Comment of the mailing");
		entity.setPersons(new ArrayList<Person>());
		entity.setTitle("Title of the mailing");
		return entity;
	}

	@Override
	protected Collection<MailingList> createEntityCollection() {
		
		ArrayList<MailingList> list = new ArrayList<MailingList>();
		MailingList entity = new MailingList();
		entity.setComment("Comment of the mailing");
		entity.setPersons(new ArrayList<Person>());
		entity.setTitle("Title of the mailing");
		list.add(entity);
		return list;
	}

	@Override
	protected void updateEntity(MailingList entity) {
		entity.setComment("New comment for the mailing");
		entity.setPersons(new ArrayList<Person>());
		entity.setTitle("The title stays the same");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("title" , "title*");
		return searchParams;
	}

	@Override
	protected void compareEntity(MailingList entity1, MailingList entity2) {
	}

}
