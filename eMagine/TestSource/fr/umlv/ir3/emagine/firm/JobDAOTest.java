package fr.umlv.ir3.emagine.firm;

import java.util.ArrayList;
import java.util.Collection;

import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAOTest;
import fr.umlv.ir3.emagine.util.search.SearchParams;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class JobDAOTest extends BaseDAOTest<Job> {

	JobDAO dao;
	
	public JobDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		dao = new JobDAO();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		dao = null;
	}

	@Override
	protected BaseDAO<Job> getDAO() {
		return dao;
	}

	//@Override
	protected Job createEntity() {
		
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		Job job = new Job();
		job.setCursus(CourseOptionEnum.values()[0]);
		job.setFirm(firm);
		job.setName("apprentice");
		job.setNbPlace(3);
		job.setTitle("title");
		
		return job;
	}

	//@Override
	protected Collection<Job> createEntityCollection() {
		
		ArrayList<Job> list = new ArrayList<Job>();
		Firm firm = new Firm();
		firm.setName("Firm for test");
		
		Job job1 = new Job();
		job1.setCursus(CourseOptionEnum.values()[0]);
		job1.setFirm(firm);
		job1.setName("apprentice 1");
		job1.setNbPlace(3);
		job1.setTitle("title 1");
		
		Job job2 = new Job();
		job2.setCursus(CourseOptionEnum.values()[1]);
		job2.setFirm(firm);
		job2.setName("apprentice 2");
		job2.setNbPlace(1);
		job2.setTitle("title2 ");
		
		list.add(job1);
		list.add(job2);
		
		return list;
	}

	@Override
	protected void updateEntity(Job entity) {
		
		Firm firm = new Firm();
		firm.setName("new Firm for test");
		
		entity.setCursus(CourseOptionEnum.values()[0]);
		entity.setFirm(firm);
		entity.setName("new apprentice");
		entity.setNbPlace(9);
		entity.setTitle("new title");
	}

	@Override
	protected SearchParams createSearchParams() {
		SearchParamsImpl searchParams = new SearchParamsImpl();
		searchParams.setField("firm" , "firm");
		return searchParams;
	}

	@Override
	protected void compareEntity(Job entity1, Job entity2) {
		assertTrue(conditionCheck(entity1.getCursus(), entity2.getCursus()));
		assertTrue(conditionCheck(entity1.getFirm(), entity2.getFirm()));
		assertTrue(conditionCheck(entity1.getId(), entity2.getId()));
		assertTrue(conditionCheck(entity1.getName(), entity2.getName()));
		assertTrue(conditionCheck(entity1.getNbPlace(), entity2.getNbPlace()));
		assertTrue(conditionCheck(entity1.getTitle(), entity2.getTitle()));
	}

	//@Override
	protected Collection<Job> createForFindEntityCollection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Job createEntity(int index) {
		// TODO enclosing_package.JobDAOTest.createEntity(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.JobDAOTest.createEntity(enclosing_method_arguments)");
		return null;
	}

	@Override
	protected Job createEntityForSearchParams(SearchParams params, int index) {
		// TODO enclosing_package.JobDAOTest.createEntityForSearchParams(enclosing_method_arguments)
		//throw new EMagineException("exception.unimplementedMethod", "enclosing_package.JobDAOTest.createEntityForSearchParams(enclosing_method_arguments)");
		return null;
	}

}
