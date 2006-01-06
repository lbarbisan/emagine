package fr.umlv.ir3.emagine.util.base;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public abstract class BaseDAOTest <EntityType extends BaseEntity> extends TestCase {
	private EntityType entity;

	public BaseDAOTest(String arg0) {
		super(arg0);
	}

	protected void setUp() throws Exception {
		super.setUp();
		entity = createEntity();
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
			getDAO().create(entity);
			compareEntity(getDAO().retrieve(entity.getId()),entity);
		}
		finally {
			getDAO().delete(entity);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.update(EntityType)'
	 */
	public void testUpdate() throws EMagineException {
		try {
			getDAO().create(entity);
			updateEntity(entity);
			getDAO().update(entity);
			compareEntity(getDAO().retrieve(entity.getId()),entity);
		}
		finally {
			getDAO().delete(entity);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.retrieve(long)'
	 */
	public void testRetrieve() throws EMagineException {
		try {
			getDAO().create(entity);
			compareEntity(getDAO().retrieve(entity.getId()),entity);
		}
		finally {
			getDAO().delete(entity);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.delete(EntityType)'
	 */
	public void testDeleteEntityType() throws EMagineException {
		getDAO().create(entity);
		getDAO().delete(entity);

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
		Collection<EntityType> entitiesc = createEntityCollection();

		for (EntityType entity : entitiesc) {
			getDAO().create(entity);
		}
	
		getDAO().delete(entitiesc);

		for (EntityType entity : entitiesc) {
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
		Collection <EntityType> entitiesc = createEntityCollection();
		List <EntityType> entities = getDAO().find(createSearchParams());

		assertEquals(entitiesc.size(),entities.size());
		for (EntityType entity : entities) {
			EntityType entity2 = getElement(entitiesc,entity);
			assertNull(entity2);
			compareEntity(entity2, entity);
		}

		for (EntityType entity : entities) {
			getDAO().delete(entity);
		}
	}

	/*
	 * Test method for 'fr.umlv.ir3.emagine.util.base.BaseDAO.findAll()'
	 */
	public void testFindAll() throws EMagineException {
		Collection <EntityType> entitiesc = createEntityCollection();
		List <EntityType> entities = getDAO().findAll();

		assertEquals(entitiesc.size(),entities.size());
		for (EntityType entity : entities) {
			EntityType entity2 = getElement(entitiesc,entity);
			assertNull(entity2);
			compareEntity(entity2, entity);
		}

		for (EntityType entity : entities) {
			getDAO().delete(entity);
		}
	}
	
	private EntityType getElement(Collection <EntityType> entities, EntityType entity) {
		for (EntityType entity2 : entities) {
			if(entity.equals(entity2))
				return entity2;
		}			
		return null;
	}

	
	protected abstract BaseDAO<EntityType> getDAO();
	protected abstract EntityType createEntity();
	protected abstract Collection<EntityType> createEntityCollection();
	protected abstract void updateEntity(EntityType entity);
	protected abstract SearchParams createSearchParams();
	protected abstract void compareEntity(EntityType entity1, EntityType entity2);
	
	/**
	 * Renvoi True si la condition est vérifier False Sinon
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
