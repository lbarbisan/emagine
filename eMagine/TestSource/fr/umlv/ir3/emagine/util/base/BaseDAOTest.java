package fr.umlv.ir3.emagine.util.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public abstract class BaseDAOTest <EntityType extends BaseEntity> extends TestCase {
	private EntityType entity;
	
	public BaseDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		entity = createEntity(0);
	}

	protected void tearDown() throws Exception {
		entity = null; 
		super.tearDown();
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.create(EntityType)'
	 */
	public void testCreate() throws EMagineException {
		try {
			DAOManager.beginTransaction();
			getDAO().create(entity);
			compareEntity(getDAO().retrieve(entity.getId()),entity);
			DAOManager.commitTransaction();
		}
		finally {
			DAOManager.beginTransaction();
			getDAO().delete(entity);
			DAOManager.commitTransaction();
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.update(EntityType)'
	 */
	public void testUpdate() throws EMagineException {
		try {
			DAOManager.beginTransaction();
			getDAO().create(entity);
			DAOManager.commitTransaction();
			
			DAOManager.beginTransaction();
			updateEntity(entity);
			DAOManager.commitTransaction();
			
			DAOManager.beginTransaction();
			getDAO().update(entity);
			DAOManager.commitTransaction();
			
			compareEntity(getDAO().retrieve(entity.getId()),entity);
		}
		finally {
			DAOManager.beginTransaction();
			getDAO().delete(entity);
			DAOManager.commitTransaction();
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.retrieve(long)'
	 */
	public void testRetrieve() throws EMagineException {
		try {
			DAOManager.beginTransaction();
			getDAO().create(entity);
			DAOManager.commitTransaction();
			compareEntity(getDAO().retrieve(entity.getId()),entity);
		}
		finally {
			DAOManager.beginTransaction();
			getDAO().delete(entity);
			DAOManager.commitTransaction();
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.delete(EntityType)'
	 */
	public void testDeleteEntityType() throws EMagineException {
		
		DAOManager.beginTransaction();
		getDAO().create(entity);
		DAOManager.commitTransaction();
		DAOManager.beginTransaction();
		getDAO().delete(entity);
		DAOManager.commitTransaction();

		try {
			getDAO().retrieve(entity.getId());
			assertTrue(true);
		}
		catch (EMagineException e) {
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.delete(Collection<EntityType>)'
	 */
	public void testDeleteCollectionOfEntityType() throws EMagineException {
		Collection<EntityType> entities = createEntityCollection(1, 10);

		DAOManager.beginTransaction();
		for (EntityType entity : entities) {
			getDAO().create(entity);
		}
	
		DAOManager.commitTransaction();
		DAOManager.beginTransaction();
		getDAO().delete(entities);
		DAOManager.commitTransaction();

		for (EntityType entity : entities) {
			try {
				getDAO().retrieve(entity.getId());
				assertTrue(true);
			}
			catch (EMagineException e) {
			}
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.find(SearchParam)'
	 */
	public void testFind() throws EMagineException {
		
		Collection <EntityType> entities = createEntityCollection(11,15);
		assertEquals(15, entities.size());
		
		SearchParams searchParams = createSearchParams();
		
		DAOManager.beginTransaction();
		for(EntityType baseEntity : entities)
		{
			getDAO().create(baseEntity);
		}
		DAOManager.commitTransaction();
		
		Collection <EntityType>  entitiesFilter = new ArrayList<EntityType>();
		for(int index=16;index<20;index++)
		{
			EntityType entityType = createEntityForSearchParams(searchParams,index);
			assertNotNull(entityType);
			entitiesFilter.add(entityType);	
		}
		
		
		DAOManager.beginTransaction();
		for(EntityType baseEntity : entitiesFilter)
		{
			getDAO().create(baseEntity);
		}
		DAOManager.commitTransaction();
		
		List <EntityType> entitiesRequest = getDAO().find(searchParams);

		assertEquals(entitiesFilter.size(),entitiesRequest.size());
		for (EntityType entity : entitiesFilter) {
			EntityType entity2 = getElement(entitiesRequest,entity);
			assertNotNull(entity2);
			compareEntity(entity2, entity);
		}

		DAOManager.beginTransaction();
		for (EntityType entity : entitiesFilter) {
			getDAO().delete(entity);
		}
		for (EntityType entity : entities) {
			getDAO().delete(entity);
		}
		DAOManager.commitTransaction();
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.findAll()'
	 */
	public void testFindAll() throws EMagineException {
		Collection <EntityType> initialEntities = createEntityCollection(20,30);
		assertEquals(30, initialEntities.size());
		
		DAOManager.beginTransaction();
		for(EntityType baseEntity : initialEntities)
		{
			getDAO().create(baseEntity);
		}
		DAOManager.commitTransaction();
		
		List <EntityType> findEntities = getDAO().findAll();

		assertNotNull(initialEntities);
		assertNotNull(findEntities);
		assertEquals(initialEntities.size(),findEntities.size());
		for (EntityType entity : findEntities) {
			EntityType entity2 = getElement(initialEntities,entity);
			assertNotNull(entity2);
			compareEntity(entity2, entity);
		}

		DAOManager.beginTransaction();
		for (EntityType entity : initialEntities) {
			getDAO().delete(entity);
		}
		DAOManager.commitTransaction();
	}
	
	private EntityType getElement(Collection <EntityType> entities, EntityType entity) {
		for (EntityType entity2 : entities) {
			if(entity.equals(entity2))
				return entity2;
		}			
		return null;
	}
	
	protected Collection<EntityType> createEntityCollection(int start, int lenght) {
		ArrayList<EntityType> list = new ArrayList<EntityType>();
	
		for(int index=start; index < start + lenght; index ++)
		{
			EntityType entityType = createEntity(index);
			assertNotNull(entityType);
			list.add (entityType);
		}
		return list;
	}

	protected abstract BaseDAO<EntityType> getDAO();
	protected abstract SearchParams createSearchParams();
	protected abstract EntityType createEntity(int index);
	protected abstract EntityType createEntityForSearchParams(SearchParams params, int index);
	protected abstract void updateEntity(EntityType entity);
	protected abstract void compareEntity(EntityType entity1, EntityType entity2);
	
	/**
	 * Renvoi True si les deux objets sont égau, false sinon.
	 * @param <ConditionnalEntityType>
	 * @param Obj1 Première Object à Tester
	 * @param Obj2 Deuxième Object à Tester
	 * @return True si la condition est vérifier False Sinon
	 */
	protected<ConditionnalEntityType> boolean conditionCheck(ConditionnalEntityType Obj1, ConditionnalEntityType Obj2)
	{
			return (!(Obj1!=null ^ Obj2!=null)) &&
					((Obj1==null && Obj2==null) || 
					Obj1.equals(Obj2));
	}
}
