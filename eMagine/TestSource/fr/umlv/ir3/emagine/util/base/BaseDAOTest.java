package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParam;

public abstract class BaseDAOTest <EntityType extends BaseEntity> extends TestCase {
	
	public BaseDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.create(EntityType)'
	 */
	public void testCreate() {
		try {
			EntityType entity = createEntity();
			getDAO().create(entity);
			assertTrue(compareEntity(getDAO().retrieve(entity.getId()),entity));
			getDAO().delete(entity);
		} catch (EMagineException e) {
			// Problem with de creation of the object
			assertFalse(true);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.update(EntityType)'
	 */
	public void testUpdate() {
		EntityType entity = createEntity();
		try {
			getDAO().create(entity);
			assertTrue(compareEntity(getDAO().retrieve(entity.getId()),entity));
			updateEntity(entity);
			getDAO().update(entity);
			assertTrue(compareEntity(getDAO().retrieve(entity.getId()),entity));
			getDAO().delete(entity);
		} catch (EMagineException e) {
			// Problem with de creation of the object
			assertFalse(true);		
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.retrieve(long)'
	 */
	public void testRetrieve() {
		try {
			EntityType entity = createEntity();
			getDAO().create(entity);
			assertTrue(compareEntity(getDAO().retrieve(entity.getId()),entity));
			getDAO().delete(entity);
		} catch (EMagineException e) {
			// Problem with de creation of the object
			assertFalse(true);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.delete(EntityType)'
	 */
	public void testDeleteEntityType() {
		try {
			EntityType entity = createEntity();
			getDAO().create(entity);
			getDAO().delete(entity);
			if(getDAO().retrieve(entity.getId()) == null){
				assertTrue(true);
			}
			else{
				assertFalse(true);
			}
		} catch (EMagineException e) {
			// Problem with de creation of the object
			assertFalse(true);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.delete(Collection<EntityType>)'
	 */
	public void testDeleteCollectionOfEntityType() {
		Collection<EntityType> entities = createEntityCollection();
		try {
		for (EntityType entity : entities) {
				getDAO().create(entity);
		}
		getDAO().delete(entities);
		for (EntityType entity : entities) {
			getDAO().retrieve(entity.getId());
			if(getDAO().retrieve(entity.getId()) != null){
				assertFalse(true);
			}
	}
		assertTrue(true);
		} catch (EMagineException e) {
			assertFalse(true);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.find(SearchParam)'
	 */
	public void testFind() {
		try {
			EntityType entity = createEntity();
			getDAO().create(entity);
			assertEquals(1,getDAO().find(createSearchParam()).size());
			getDAO().delete(entity);
		} catch (EMagineException e) {
			// Problem with de creation of the object
			assertFalse(true);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.findAll()'
	 */
	public void testFindAll() {
		Collection<EntityType> entities = createEntityCollection();
		try {
		for (EntityType entity : entities) {
				getDAO().create(entity);
		}
		assertEquals(entities.size(),getDAO().findAll().size());
		} catch (EMagineException e) {
			assertFalse(true);
		}
	}
	
	protected abstract BaseDAO<EntityType> getDAO();
	protected abstract EntityType createEntity();
	protected abstract Collection<EntityType> createEntityCollection();
	protected abstract void updateEntity(EntityType entity);
	protected abstract SearchParam createSearchParam();
	protected abstract boolean compareEntity(EntityType entity1, EntityType entity2);

}
