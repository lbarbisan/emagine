package fr.umlv.ir3.emagine.util.base;

import fr.umlv.ir3.emagine.modification.FieldModification;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public abstract class BaseEditableManagerImpl<EntityType extends EditableEntity, EntityDAO extends BaseDAO<EntityType>>
		extends BaseManagerImpl<EntityType, EntityDAO> implements
		BaseEditableManager<EntityType, EntityDAO> {

	/**
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#update(EntityType)
	 */
	@Override
	public void update(EntityType newEntity) throws EMagineException {
		// TODO : vérifier les droits courrants
		// si le user a les droits, faire un update classique, sinon faire un
		// ajout de modification
	}

	/**
	 * @throws EMagineException
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

	/**
	 * @throws EMagineException 
	 * @see fr.umlv.ir3.emagine.util.base.BaseEditableManager#addModification()
	 */
	public void addModification(EntityType entity) throws EMagineException {
		// TODO addModification
		DAOManager.beginTransaction();
		try {
			// Load the original object
			EntityType oldEntity = retrieve(entity.getId());
			// set the modification
			Modification modification = new Modification();
//			for (FieldModification<EntityType> field : entity.getFields()) {
//				Object propertyValue = field.getPropertyValue();
//				if (propertyValue.equals(oldEntity.getField(field.getPropertyName()))) {
//					modification.addFieldModification(field);
//					entity.getModifications().add(modification);
//				}
//			}
			super.update(entity);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
			throw e;
		}
	}

}
