package fr.umlv.ir3.emagine.util.base;

import java.io.OutputStream;
import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.ExtractionParams;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public interface BaseManager
	<EntityType extends BaseEntity, EntityDAO extends BaseDAO<EntityType>> {

	/**
	 * Creates the database data for the specified object. Handles the creation with a transaction.
	 * @param entity object that must be save in database
	 * @throws EMagineException throw this exception if the creation failed or if an SQLException occures
	 */
	public void create(EntityType entity) throws EMagineException;

	/**
	 * Retrieves the database data for the specified id
	 * @param id id of the object to retrieve
	 * @return the object which is associated to id, null if not found
	 * @throws EMagineException throw this exception if an SQLException occures
	 */
	public EntityType retrieve(long id) throws EMagineException;
	
	/**
	 * Retrieves the database data for the specified id
	 * @param id id of the object to retrieve
	 * @return the object which is associated to id, null if not found
	 * @throws EMagineException throw this exception if an SQLException occures
	 */
	public List<EntityType> find(SearchParams searchParams) throws EMagineException;
	
	/**
	 * Returns all the entities of the paramitrized type, or null if none found
	 * @return
	 * @throws EMagineException throws if an SQLException occures
	 */
	public List<EntityType> findAll() throws EMagineException;

	/**
	 * Updates the database data for the specified object. Handles the update with a transaction.
	 * @param entity object that must update save in database
	 * @throws EMagineException  throw this exception if the update failed or if an SQLException occures
	 */
	public void update(EntityType newEntity) throws EMagineException;

	/**
	 * Deletes the database data associated the the specified object. Handles the deletion with a transaction. 
	 * @param object object to delete
	 * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
	 */
	public void delete(EntityType entity) throws EMagineException;

	/**
	 * Deletes the database data associated the the specified objects. Handles the deletion with a transaction. 
	 * @param object object to delete
	 * @throws EMagineException throw this excepion if the deletation failed or if an SQLException occures
	 */
	public void delete(Collection<EntityType> entities) throws EMagineException;

	/**
	 * Extracts the specified extractable, with the specified extraction options (extractionForm) to the specified outputStream.
	 * @param extractable extractable to extract
	 * @param params parameters of the extraction
	 * @param stream output for the extraction
	 * @throws EMagineException if the extraction failed.
	 */
	public void extract(Extractable extractable, ExtractionParams params, OutputStream stream) throws EMagineException;

}