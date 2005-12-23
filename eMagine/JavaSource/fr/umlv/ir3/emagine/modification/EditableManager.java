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
}