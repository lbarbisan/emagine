package fr.umlv.ir3.emagine.modification;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

/**
 * @author 
 *
 * @param <EntityType>
 * @param <EntityDAO>
 */
public class EditableManagerImpl<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>>
		extends BaseManagerImpl<EntityType, EntityDAO> implements
		EditableManager<EntityType, EntityDAO> {

	//private EditableInterceptor modificationInterceptor;

	/**
	 * @see fr.umlv.ir3.emagine.modification.EditableManager#acceptAllModification(EntityType)
	 */
	public void acceptAllModification(EntityType entity)
		throws EMagineException {
		DAOManager.beginTransaction();
		
		
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
	 * @see fr.umlv.ir3.emagine.modification.EditableManager#acceptFieldModification(EntityType,
	 *      java.lang.String)
	 */
	public void acceptFieldModification(EntityType entity, String name)
			throws EMagineException {
		// TODO acceptFieldModification
		DAOManager.beginTransaction();
		//FieldModification field = entity.getCurrentModification()
		//		.getFieldModification(name);
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
