package fr.umlv.ir3.emagine.util;

import java.util.List;

import fr.umlv.ir3.emagine.security.MustHaveRights;

@MustHaveRights("Enum")
public interface EmagineEnumManager{
	/**
	 * Creates the database data for the specified object
	 * 
	 * @param object
	 *            object that must be save in database
	 * @throws EMagineException
	 *             throw this exception if the creation failed or if an
	 *             SQLException occures
	 */
	public void create(EmagineEnum object) throws EMagineException;
	
	/**
	 * Retrieves the database data for the specified id
	 * 
	 * @param id
	 *            id of the object to retrieve
	 * @return the object which is associated to id, null if not found
	 * @throws EMagineException
	 *             throw this exception if an SQLException occures
	 */
	public EmagineEnum retrieve(long id, Class clazz) throws EMagineException;

	
	/**
	 * Returns all the entities of the paramitrized type, or null if none found
	 * @return all collection of objects
	 * @throws EMagineException throws if an SQLException occures
	 */
	public List<? extends EmagineEnum> findAll(Class<? extends EmagineEnum> clazz) throws EMagineException;
}