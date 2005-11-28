package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class ModificationInterceptor implements Interceptor {

	public boolean onLoad(Object entity, Serializable id, Object[] State,
			String[] propertyNames, Type[] types) throws CallbackException {
		// TODO ModificationInterceptor.onLoad()
		return false;
	}

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState,
			Object[] previousState, String[] propertyNames, Type[] types) throws CallbackException {
		// TODO ModificationInterceptor.onFlushDirty()
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		
		BaseEntity baseEntity = (BaseEntity)entity;
		//FIXME : La modification doit être crée à l'avance
		Modification<?> modification = baseEntity.getModifications().get(baseEntity.getModifications().size()-1);
		
		for(String propertyName : propertyNames)
		{
			FieldModification<Object> fieldModification = new FieldModification<Object>();
			
			fieldModification.setPropertyName(propertyName);
			
			fieldModification.setPropertyValue(HibernateUtils.getPropertyValue(propertyName, baseEntity));
			
			modification.getFieldsModifications().put(propertyName, fieldModification);			
		}
		return false;
	}

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) throws CallbackException {
		// TODO ModificationInterceptor.onDelete()

	}

	public void onCollectionRecreate(Object entity, Serializable id)
			throws CallbackException {
		// TODO ModificationInterceptor.onCollectionRecreate()

	}

	public void onCollectionRemove(Object entity, Serializable id)
			throws CallbackException {
		// TODO ModificationInterceptor.onCollectionRemove()

	}

	public void onCollectionUpdate(Object entity, Serializable id)
			throws CallbackException {
		// TODO ModificationInterceptor.onCollectionUpdate()

	}

	public void preFlush(Iterator entities) throws CallbackException {
		// TODO ModificationInterceptor.preFlush()

	}

	public void postFlush(Iterator entities) throws CallbackException {
		// TODO ModificationInterceptor.postFlush()

	}

	public Boolean isTransient(Object tx) {
		// TODO ModificationInterceptor.isTransient()
		return null;
	}

	public int[] findDirty(Object entity, Serializable id, Object[] currentState,
			Object[] previousState, String[] propertyNames, Type[] types) {
		// TODO ModificationInterceptor.findDirty()
		return null;
	}

	public Object instantiate(String clazz, EntityMode entityMode, Serializable id)
			throws CallbackException {
		// TODO ModificationInterceptor.instantiate()
		return null;
	}

	public String getEntityName(Object entity) throws CallbackException {
		// TODO ModificationInterceptor.getEntityName()
		return null;
	}

	public Object getEntity(String entityName, Serializable id)
			throws CallbackException {
		// TODO ModificationInterceptor.getEntity()
		return null;
	}

	public void afterTransactionBegin(Transaction tx) {
		// TODO ModificationInterceptor.afterTransactionBegin()

	}

	public void beforeTransactionCompletion(Transaction tx) {
		// TODO ModificationInterceptor.beforeTransactionCompletion()

	}

	public void afterTransactionCompletion(Transaction tx) {
		// TODO ModificationInterceptor.afterTransactionCompletion()

	}

	public String onPrepareStatement(String statement) {
		// TODO ModificationInterceptor.onPrepareStatement()
		return null;
	}

}
