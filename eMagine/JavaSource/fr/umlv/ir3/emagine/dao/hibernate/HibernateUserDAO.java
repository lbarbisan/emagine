/**
 * 
 */
package fr.umlv.ir3.emagine.dao.hibernate;

import java.util.Collection;

import fr.umlv.ir3.emagine.dao.UserDAO;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserSearchParam;


/**
 * @author Administrateur
 *
 */
public class HibernateUserDAO extends HibernateBaseDAO<User> implements UserDAO {
	
	@Override
	public User retrieve(long id) {
	  	return (User) HibernateUtils.getSession().load(User.class, id);
	}

	public Collection<User> getUsers(UserSearchParam userSearchParam) {
		// TODO HibernateUserDAO.getUsers()
		return null;
	}
}
