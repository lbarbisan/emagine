package fr.umlv.ir3.emagine.extraction.massmailing;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.extraction.mailings.Attachment;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class MassMailingDAOTest extends BaseDAOTest<MassMailing> {

	MassMailingDAO dao;
	
	public MassMailingDAOTest(String arg0) {
		super(arg0);
		
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new MassMailingDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<MassMailing> getDAO() {
		return dao;
	}

	//@Override
	protected MassMailing createEntity() {
		
		Model model = new Model();
		model.setName("document");
		model.setPath("/home/datas/files/");
		
		MassMailing entity = new MassMailing();
		entity.setAttachments(new ArrayList<Attachment>());
		entity.setComment("Comment for test");
		entity.setModelPath(model);
		entity.setTitle("title for test");
		return entity;
	}

	//@Override
	protected Collection<MassMailing> createEntityCollection() {
		
		ArrayList<MassMailing> list = new ArrayList<MassMailing>();
		Model model = new Model();
		model.setName("document");
		model.setPath("/home/datas/files/");
		
		MassMailing entity1 = new MassMailing();
		entity1.setAttachments(new ArrayList<Attachment>());
		entity1.setComment("Comment for test");
		entity1.setModelPath(model);
		entity1.setTitle("title");
		
		MassMailing entity2 = new MassMailing();
		entity2.setAttachments(new ArrayList<Attachment>());
		entity2.setComment("Comment for test");
		entity2.setModelPath(model);
		entity2.setTitle("title");
		
		list.add(entity1);
		list.add(entity2);
		
		return list;
	}

	@Override
	protected void updateEntity(MassMailing entity) {
		entity.setComment("new comment for test");
		entity.setTitle("new title");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("title" , "title for test");
		return searchParams;
	}

	@Override
	protected void compareEntity(MassMailing entity1, MassMailing entity2) {
		assertTrue(conditionCheck(entity1.getAttachments(), entity2.getAttachments()));
		assertTrue(conditionCheck(entity1.getComment(), entity2.getComment()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getModelPath(), entity2.getModelPath()));
		assertTrue(conditionCheck(entity1.getTitle(), entity2.getTitle()));
	}

	//@Override
	protected Collection<MassMailing> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected MassMailing createEntity(int index) {
		// TODO enclosing_package.MassMailingDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.MassMailingDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected MassMailing createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.MassMailingDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.MassMailingDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
