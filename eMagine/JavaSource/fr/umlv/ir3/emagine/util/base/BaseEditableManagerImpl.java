package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * @author 
 *
 * @param <EntityType>
 * @param <EntityDAO>
 */
public class BaseEditableManagerImpl<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>>
		extends BaseManagerImpl<EntityType, EntityDAO> implements
		BaseEditableManager<EntityType, EntityDAO> {


	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#acceptAllModification(EntityType)
	 */
	public void acceptAllModification(EntityType entity)
			throws EMagineException {
		DAOManager.beginTransaction();
		// entity.acceptModification();
		try {
			super.update(entity);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
			throw e;
		}
	}

	/**
	 * @throws EMagineException
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#acceptFieldModification(EntityType,
	 *      java.lang.String)
	 */
	public void acceptFieldModification(EntityType entity, String name)
			throws EMagineException {
		// TODO acceptFieldModification
		DAOManager.beginTransaction();
		FieldModification field = entity.getCurrentModification()
				.getFieldModification(name);
		// entity.acceptFieldModification(field);
		try {
			super.update(entity);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
			throw e;
		}
	}

	@Override
	protected EntityDAO getDAO() {
		return (EntityDAO) DAOManager.getInstance().getBaseDAO();
	}
}
