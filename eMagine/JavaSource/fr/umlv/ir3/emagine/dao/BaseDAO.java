/**
 * 
 */
package fr.umlv.ir3.emagine.dao;

import java.util.Collection;


/**
 * @author Administrateur
 *
 */
//CRUD Design pattern
public interface BaseDAO<ObjectType> {
    public void create(ObjectType object);
    public void update(ObjectType object);
    public ObjectType retrieve(long id);
    public void delete(ObjectType object);
}
