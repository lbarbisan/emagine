package fr.umlv.ir3.emagine.extraction.mailstype;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class MailingTypeDAOTest extends BaseDAOTest<MailingType> {

	MailingTypeDAO dao;
	
	public MailingTypeDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new MailingTypeDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<MailingType> getDAO() {
		return dao;
	}

	@Override
	protected MailingType createEntity() {
		
		MailingType entity = new MailingType();
		entity.setMailCore("core of the mailing type");
		entity.setMailObject("object: new project for ir3");
		entity.setTitle("Corba Project");
		return entity;
	}

	@Override
	protected Collection<MailingType> createEntityCollection() {
		ArrayList<MailingType> list = new ArrayList<MailingType>();
		
		MailingType entity1 = new MailingType();
		entity1.setMailCore("core of the mailing type1");
		entity1.setMailObject("object: Special holidays");
		entity1.setTitle("Holidays");
		
		MailingType entity2 = new MailingType();
		entity2.setMailCore("core of the mailing type2");
		entity2.setMailObject("object: new project for ir3");
		entity2.setTitle("Corba Project");
		
		MailingType entity3 = new MailingType();
		entity3.setMailCore("core of the mailing type3");
		entity3.setMailObject("object: eMagine beta demonstration");
		entity3.setTitle("eMagine Beta");
		
		MailingType entity4 = new MailingType();
		entity4.setMailCore("core of the mailing type4");
		entity4.setMailObject("object: none");
		entity4.setTitle("not interresting");
		
		list.add(entity1);
		list.add(entity2);
		list.add(entity3);
		list.add(entity4);
		return list;
	}

	@Override
	protected void updateEntity(MailingType entity) {
		
		entity.setMailCore("new Core");
		entity.setMailObject("object: new object");
		entity.setTitle("new title");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("object" , "object:*");
		return searchParams;
	}

	@Override
	protected void compareEntity(MailingType entity1, MailingType entity2) {
		assertTrue(conditionCheck(entity1.getAttachments(), entity2.getAttachments()));
		assertTrue(conditionCheck(entity1.getComment(), entity2.getComment()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getMailCore(), entity2.getMailCore()));
		assertTrue(conditionCheck(entity1.getMailObject(), entity2.getMailObject()));
		assertTrue(conditionCheck(entity1.getTitle(), entity2.getTitle()));
	}

}
