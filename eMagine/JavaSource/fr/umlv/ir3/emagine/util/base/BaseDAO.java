/**
 * 
 */
package fr.umlv.ir3.emagine.util.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.metadata.ClassMetadata;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * This class implement the core of DAO design pattern, each DAO class must
 * implement this class. This class used CRUD Design pattern (Create, Retrieve,
 * Update, Delete). This mean that each DAO Class have by default this four
 * method : <br>
 * Create an Object from database <br>
 * Rretrieve an object from database <br>
 * Update an object from/to database <br>
 * Delete an Object from database
 * 
 * @author eMagine team
 * @param <EntityType>
 *            the type of object to manipulate.
 */
public class BaseDAO<EntityType extends BaseEntity> {
	
	private Log log = LogFactory.getLog(BaseDAO.class);
	
	private Class EntityClass;

	/**
	 * Creates the database data for the specified object
	 * 
	 * @param object
	 *            object that must be save in database
	 * @throws EMagineException
	 *             throw this exception if the creation failed or if an
	 *             SQLException occures
	 */
	public void create(EntityType object) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			log.trace("create in " + Thread.currentThread().getName());
			session.save(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.create", exception);
		}
	}

	/**
	 * Updates the database data for the specified object
	 * 
	 * @param newEntity
	 *            object that must update save in database
	 * @throws EMagineException
	 *             throw this exception if the update failed or if an
	 *             SQLException occures
	 */
	public void update(EntityType newEntity) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			logEntity("update" , newEntity);
			log.info("update in " + Thread.currentThread().getName());
			session.update(newEntity);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.update", exception);
		}
	}

	/**
	 * Retrieves the database data for the specified id
	 * 
	 * @param id
	 *            id of the object to retrieve
	 * @return the object which is associated to id, null if not found
	 * @throws EMagineException
	 *             throw this exception if an SQLException occures
	 */
	public EntityType retrieve(long id) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			EntityType entityType =  (EntityType) session.load(getEntityClass(), id);
			if(log.isDebugEnabled()==true)
			{
				logEntity("retrieve" , entityType);
			}
			log.info("retrieve in " + Thread.currentThread().getName());
			return entityType;
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.update", exception);
		}
	}

	/**
	 * Deletes the database data associated the the specified object
	 * 
	 * @param object
	 *            object to delete
	 * @throws EMagineException
	 *             throw this excepion if the deletation failed or if an
	 *             SQLException occures
	 */
	public void delete(EntityType object) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			session.delete(object);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.delete", exception);
		}
	}

	/**
	 * Deletes the database data associated the the specified objects
	 * 
	 * @param objects
	 *            object to delete
	 * @throws EMagineException
	 *             throw this excepion if the deletation failed or if an
	 *             SQLException occures
	 */
	public void delete(Collection<EntityType> objects) throws EMagineException {
		try {
			Session session = HibernateUtils.getSession();
			for (EntityType object : objects) {
				session.delete(object);
			}
		} catch (HibernateException exception) {
			throw new EMagineException("exception.baseDAO.delete", exception);
		}
	}

	protected Class getEntityClass() {
		if (EntityClass == null) {
			// Retrouve le type du generic
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			EntityClass = (Class) (type.getActualTypeArguments()[0]);
		}
		return EntityClass;
	}

	/**
	 * Searches for a list of parameterized type objects which match the given searchParams
	 * @param searchParams
	 * @return List for search
	 * @throws EMagineException 
	 */
	public List<EntityType> find(SearchParams searchParams) throws EMagineException {

		boolean first = true;
		String order=" " + getEntityClass().getSimpleName().toLowerCase() + ".id";
		StringBuilder queryString = new StringBuilder();

		queryString.append("From " ).append(getEntityClass().getSimpleName())
			.append(" as ")
			.append(getEntityClass().getSimpleName().toLowerCase());
		
		for (String field : searchParams.getFields()) {
			if(	searchParams.getValue(field)!= null &&
				!searchParams.getValue(field).equals(""))
				
			{
				log.trace("create parameter '"+ field +"'");
				queryString.append((first == true ? "  where " : " and "))
				.append("lower(")
				.append(field.replace(getEntityClass().getSimpleName(), getEntityClass().getSimpleName().toLowerCase()))
				.append(") like lower(:")
				.append(field.replace(".", "_"))
				.append(")");
				if (first == true) {
					order = field;
					first = false;
				}
			}
		}

		//Order by
		queryString.append(" order by " + order);
		
		Query query = HibernateUtils.getSession().createQuery(queryString.toString());
		for (String field : searchParams.getFields()) {
			log.trace("get value for '" + field + "' : '" + searchParams.getValue(field)+ "'");
			if(	searchParams.getValue(field)!= null &&
				!searchParams.getValue(field).equals(""))
				{
					Object value = searchParams.getValue(field);
					query.setParameter(field.replace(".", "_"), convertToRightType(value.toString(), searchParams.getType(field)));
					log.trace("setparameter '" + field.replace(".", "_") + "' for '" + value.toString() + "'");
				}
		}
		//ParameterTranslationsImpl parameterTranslationsImpl = new ParameterTranslationsImpl(Arrays.asList(query.getNamedParameters()));
		log.debug("Search for " + queryString);		
		
		List<EntityType> list = query.list();
		
		if(log.isDebugEnabled()==true && list!=null)
		{
			for(EntityType entityType: list)
			{
				logEntity("find", entityType);
			}
		}
		
		log.info("find in " + Thread.currentThread().getName());
		
		return list;
	}

	//FIXME : Passer en Factory
	private Object convertToRightType(String value, Class clazz)
	{
		if(clazz == Long.class)
		{
			return Long.parseLong(value.toString());
		}
		if(clazz == Integer.class)
		{
			return Integer.parseInt(value.toString());
		}
		else
		{
			return value.toString().replace("*", "%");
		}
	}
	
	/**
	 * Returns all the entities of the paramitrized type, or null if none found
	 * @return all collection of objects
	 * @throws EMagineException throws if an SQLException occures
	 */
	@SuppressWarnings("unchecked")
	public List<EntityType> findAll() throws EMagineException {
			
		//Debug
		log.debug("findall() with '" + getEntityClass().getSimpleName() + "'");
		
		List<EntityType> foundResults  = 
			HibernateUtils.getSession()
						.createCriteria(getEntityClass())
						.addOrder(Order.asc("id"))
						.list();
		
		//Debug
		if(log.isDebugEnabled()==true){
			for(EntityType entityType: foundResults){
				logEntity("findAll", entityType);
			}
		}
		
		
		return foundResults;
	
	}
	
	private void logEntity(String method, EntityType newEntity)
	{
		if(newEntity!=null && log.isDebugEnabled()==true)
		{
			log.debug(method + " entity :" + newEntity);
			ClassMetadata classMetadata = HibernateUtils.getSession()
								.getSessionFactory()
								.getClassMetadata(newEntity.getClass());
			if (classMetadata != null) {
				for(String name : classMetadata.getPropertyNames())
				{
					log.debug("\t update property POJO '" + name  + "' :" + 
							classMetadata.getPropertyValue(newEntity, name, EntityMode.POJO));
				}
			}
		}
	}
}
