/**
 * 
 */
package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.util.base.BaseDAO;

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
public class EmagineEnumDAO extends BaseDAO<EmagineEnum>  {}
