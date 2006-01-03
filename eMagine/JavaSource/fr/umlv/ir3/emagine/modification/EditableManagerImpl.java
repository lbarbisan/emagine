package fr.umlv.ir3.emagine.modification;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
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
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private EditableInterceptor modificationInterceptor = new EditableInterceptor();

	/**
	 * @see fr.umlv.ir3.emagine.modification.EditableManager#acceptAllModification(EntityType)
	 */
	public void acceptAllModification(EntityType entity)
		throws EMagineException {
		DAOManager.beginTransaction();
		log.debug("acceptAllModification for '" + entity.getCurrentModification() + "'");
		modificationInterceptor.addAcceptedModifications(entity.getCurrentModification());
		try {
			super.update(entity);
			DAOManager.commitTransaction();
			entity.getModifications().remove(entity.getCurrentModification());
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

	@Override
	public void update(EntityType newEntity) throws EMagineException {
		modificationInterceptor.setDirectWriteAllowed(true);
		try
		{
			super.update(newEntity);
		}
		finally
		{
			modificationInterceptor.setDirectWriteAllowed(false);
		}
;
	}
	
	public void updateWithoutRights(EntityType newEntity) throws EMagineException {
		
		modificationInterceptor.setDirectWriteAllowed(false);
		super.update(newEntity);
		HibernateUtils.getSession().refresh(newEntity);
	}

	public EditableInterceptor getModificationInterceptor() {
		return modificationInterceptor;
	}
}
