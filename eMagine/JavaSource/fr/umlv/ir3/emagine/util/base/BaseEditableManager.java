package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.util.Extractable;

public interface BaseEditableManager
	<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>> 
	extends BaseManager<EntityType, EntityDAO>{

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