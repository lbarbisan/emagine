package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;

public interface BaseEditableManager<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> {

	/**
	 * Updates the database data for the specified object. Handles the update with a transaction.
	 * If the current connected user doesn't have sufficient rights, a modification is added to the specified Entity.
	 * @param entity object that must update save in database
	 * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
	 */
	public void update(EntityType newEntity) throws EMagineException;

	public void acceptAllModificationFor(EntityType entity);

	public void acceptFieldModificationFor(EntityType entity, String name);

	/**
	 * 
	 * @param extractionParam
	 * @return
	 */
	//FIXME: Utilisé les générics
	public Extractable extract(ExtractionParam extractionParam);

}