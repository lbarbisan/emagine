package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.util.EMagineException;


/**
 * @author Laurent
 *
 * @param <EntityType>
 * @param <EntityDAO>
 */
public interface BaseEditableManager
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
}