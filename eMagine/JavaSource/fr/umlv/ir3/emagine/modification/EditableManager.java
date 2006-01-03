package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseManager;


/**
 * @author Laurent
 *
 * @param <EntityType>
 * @param <EntityDAO>
 */
public interface EditableManager
	<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> 
	extends BaseManager<EntityType, EntityDAO>{

	/**
	 * @param entity
	 * @throws EMagineException
	 */
	public void acceptAllModification(EntityType entity) throws EMagineException;

	/**
	 * @param entity
	 * @param name
	 * @throws EMagineException
	 */
	public void acceptFieldModification(EntityType entity, String name) throws EMagineException;
	
	/**
	 * 
	 * @return
	 */
	public EditableInterceptor getModificationInterceptor();
	
	/**
	 * Updates the entity without having the rights to update it. Actually, it compares the
	 * entity saved in database with the given newEntity and adds the modifications to the entity.
	 * That method is called when the current connected user doesn't have the rights to update
	 * the entity.
	 * @param newEntity
	 * @throws EMagineException when some SQLExceptions occure.
	 */
	public void updateWithoutRights(EntityType newEntity) throws EMagineException;
}