package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.util.EMagineException;


public interface BaseEditableManager
	<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> 
	extends BaseManager<EntityType, EntityDAO>{

	public void acceptAllModification(EntityType entity) throws EMagineException;

	public void acceptFieldModification(EntityType entity, String name) throws EMagineException;
	
	public void addModification(EntityType entity) throws EMagineException;
}