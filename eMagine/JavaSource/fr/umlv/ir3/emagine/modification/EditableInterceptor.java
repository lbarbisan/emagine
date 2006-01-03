package fr.umlv.ir3.emagine.modification;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
 * Before using interceptor, the SessionFactory must be set using setSessionFactory.
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
	private Map<Long, List<Modification>> acceptedModifications = new HashMap<Long, List<Modification>>();
	/**
	 * List of Field modification
	 */
	private Map<Long, Modification> acceptedFieldModifications = new HashMap<Long, Modification>();
	
	/**
	 * 
	 */
	private boolean directWriteAllowed = false;

	/**
	 * @param sessionFactory The sessionFactory to set.
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		if(sessionFactory==null)
		{
			log.warn("sessionFactory has been set to null");
		}
		this.sessionFactory = sessionFactory;
	}
	
	//TODO : passer par une fonction au lieu de deux
	public void addAcceptedModifications(Modification modification)
	{
		if(modification==null)
		{
			throw new NullPointerException("modification can't be null");
		}
		else
		{
			if(modification.getId()!=null)
			{
				if(acceptedModifications.containsKey(modification.getEditableEntity().getId())==false)
				{
					log.debug("create new list for modification of '" + modification.getEditableEntity() + "'");
					acceptedModifications.put(modification.getEditableEntity().getId(), new ArrayList<Modification>());
				}
				log.debug("add a modification for '" + modification.getEditableEntity() + "'");
				acceptedModifications.get(modification.getEditableEntity().getId()).add(modification);
			}
			else
			{
				throw new NullPointerException("modification must have the entity id.");
			}
		}
	}
	
	public void addAcceptedFieldModifications(FieldModification fieldModification)
	{
		if(fieldModification==null)
		{
			throw new NullPointerException("modification can't be null");
		}
		else
		{
			if(fieldModification.getId()!=null)
			{
				if(acceptedFieldModifications.containsKey(fieldModification.getId())==false)
				{
					acceptedFieldModifications.put(fieldModification.getId(), new Modification());
				}
				acceptedFieldModifications.get(fieldModification.getId()).getFieldsModifications().put(fieldModification.getPropertyName() , fieldModification);
			}
			else
			{
				throw new NullPointerException("modification must have the entity id.");
			}
		}
	}
	
	/**
	 * @see org.hibernate.Interceptor#postFlush(java.util.Iterator)
	 */
	@Override
	public void postFlush(Iterator entities) {

		log.info("Saving modification in postflush...");
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
	
	private void createModification(EditableEntity entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames)
	{
	
			Modification modification;
			
			//Recherche des modifications
			for (int index = 0; index < propertyNames.length; index++) {
				if (previousState[index]!=null &&
					(currentState[index]==null ||
					previousState[index].equals(currentState[index]) == false)) {
					
					if (modifications.containsKey(id) == false) {
						modification = new Modification();
						modification.setEditableEntity((EditableEntity) entity);
						modification.setComment(entity.toString());
						modifications.put(id, modification);
						
					} else {
						modification = modifications.get(id);
					}
					
					log.debug("Field '" + propertyNames[index]
							+ "' Changed for " + entity + " from '"
							+ previousState[index] + "' to '"
							+ currentState[index] + "'");
					
					//Rajoute un champ dans la modification
					FieldModification<Object> fieldModification = new FieldModification<Object>();
					fieldModification.setPropertyName(propertyNames[index]);
					fieldModification.setPropertyValue((Serializable) currentState[index]);
					modification.getFieldsModifications().put(fieldModification.getPropertyName(),fieldModification);
					currentState[index] = previousState[index];
				}
			}
	}
	
	
	private void applyModifications(EditableEntity entity, Object[] currentState, Object[] previousState, String[] propertyNames) {
				
		List<Modification> modifications = acceptedModifications.get(entity.getId());
		log.debug("applyModifications for '"+ entity +  "'");
		if(modifications!=null)
		{
			for(Modification modification : modifications)
			{
				applyModification(modification, entity, currentState, previousState, propertyNames);
				acceptedModifications.remove(entity.getId());
			}
		}
		Modification modification = acceptedFieldModifications.get(entity.getId());
		if(modification!=null)
		{
			applyModification(modification, entity, currentState, previousState, propertyNames);
			acceptedFieldModifications.remove(entity.getId());
		}
	}
	
	private void applyModification(Modification modification, Object entity, Object[] currentState, Object[] previousState, String[] propertyNames)
	{
		log.debug("applyModification for '"+ entity +  "'");
		for(int index=0;index < propertyNames.length;index++)
		{
			FieldModification fieldModification =  modification.getFieldModification(propertyNames[index]);
			if(fieldModification!=null)
			{
				currentState[index] = fieldModification.getPropertyValue();
				log.debug("applyModification of field '"+ propertyNames[index] + "' from '" + previousState[index] + "' to '" + currentState[index]);
			}
		}
	}

	/**
	 * 
	 * @see org.hibernate.Interceptor#findDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
	 */
	@Override
	public int[] findDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
	
			//Vérifie que l'objet est bien un objet persitant modifiable et que l'utilisateur à les droits
			if (entity instanceof EditableEntity) 
			{
				if(directWriteAllowed==false)
				{
					//créer les demande de modifications
					createModification((EditableEntity)entity,id, currentState, previousState, propertyNames);
				}
		
				//Applique les modifications en attente
				applyModifications((EditableEntity)entity, currentState, previousState, propertyNames);
			}
		
		return null;

	}


	/**
	 * @return Returns the saveModification.
	 */
	public boolean isDirectWriteAllowed() {
		return directWriteAllowed;
	}

	/**
	 * @param directWriteAllow The directWriteAllow to set.
	 */
	public void setDirectWriteAllowed(boolean directWriteAllow) {
		this.directWriteAllowed = directWriteAllow;
	}
}
