package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.Type;


/**
 * @author eMagine Team
 * Hibernate Interceptor for logging Modification
 * Thanks to: Wiki Community Area, http://www.hibernate.org/37.html
 */
public class EditableInterceptor extends EmptyInterceptor {
	
	private static final long serialVersionUID = -4309640442405255339L;
	/**
	 * Log for java
	 */
	private Log log = LogFactory.getLog(EditableInterceptor.class);
	/**
	 * Current session factory
	 */
	private SessionFactory sessionFactory;
	/**
	 * List of 'asking for' modification. The modification will be saved on post flush event
	 */
	private Map<Serializable, Modification> modifications = new HashMap<Serializable, Modification>();
	/**
	 * List of accepted modification
	 */
	private Set<Modification> acceptedModifications = new HashSet<Modification>();
	/**
	 * List of Field modification
	 */
	private Set<FieldModification> acceptedFieldModifications = new HashSet<FieldModification>();

	/**
	 * @param sessionFactory The sessionFactory to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addAcceptedModifications(Modification modification)
	{
		acceptedModifications.add(modification);
	}
	
	public void addAcceptedFieldModifications(FieldModification fieldModification)
	{
		acceptedFieldModifications.add(fieldModification);
	}
	
	/**
	 * @see org.hibernate.Interceptor#postFlush(java.util.Iterator)
	 */
	@Override
	public void postFlush(Iterator entities) {

		log.info("Saving modification...");
		Session session = sessionFactory.openSession(EmptyInterceptor.INSTANCE);
		Transaction tx = session.beginTransaction();
		
		for (Modification modification : modifications.values()) {
			log.debug("Saving modification for : "
					+ modification.getEditableEntity().toString());
			session.save(modification);
			session.flush();
		}
		
		modifications.clear();
		//TODO - Hibernate: mettre à jour la gestion des exception correct pour le commit
		tx.commit();
		session.close();
	}

	/**
	 * 
	 * @see org.hibernate.Interceptor#findDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {

		//Vérifie que l'objet est bien un objet persitant modifiable
		if (entity instanceof EditableEntity && /* FIXME : Vérifié que l'utilisateur à les droit sur l'objet */true) {
			Modification modification;

			if (modifications.containsKey(id) == false) {
				modification = new Modification();
			} else {
				modification = modifications.get(id);
			}

			for (int index = 0; index < propertyNames.length; index++) {
				if (
					previousState[index].equals(currentState[index]) == false) {
					log.debug("Field '" + propertyNames[index]
							+ "' Changed for " + entity + " from '"
							+ previousState[index] + "' to '"
							+ currentState[index] + "'");
					FieldModification<Object> fieldModification = new FieldModification<Object>();
					fieldModification.setPropertyName(propertyNames[index]);
					fieldModification
							.setPropertyValue((Serializable) currentState[index]);

					modification.getFieldsModifications().put(
							fieldModification.getPropertyName(),
							fieldModification);
					modification.setEditableEntity((EditableEntity) entity);
					modification.setComment("Field '" + propertyNames[index]
							+ "' Changed for " + entity + " from '"
							+ previousState[index] + "' to '"
							+ currentState[index] + "'\n"
							+ modification.getComment());
				}
			}

			modifications.put(id, modification);

			for (int index = 0; index < previousState.length; index++) {
				currentState[index] = previousState[index];
			}
	
		}
		return null;

	}

	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		for(int index=0;index<propertyNames.length;index++)
		{
			System.out.println(propertyNames[index]);
		}
		return false;
	}
}
