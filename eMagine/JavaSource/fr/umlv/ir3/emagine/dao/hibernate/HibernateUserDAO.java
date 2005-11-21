/**
 * 
 */
package fr.umlv.ir3.emagine.dao.hibernate;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.dao.UserDAO;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserSearchParam;
import fr.umlv.ir3.emagine.util.hibernate.HibernateUtils;


/**
 * @author Administrateur
 *
 */
public class HibernateUserDAO extends HibernateBaseDAO<User> implements UserDAO {
	
	@Override
	public User retrieve(long id) {
	  	return (User) HibernateUtils.getSession().load(User.class, id);
	}

	public List<User> getUsers(UserSearchParam userSearchParam) {
		// TODO HibernateUserDAO.getUsers()
		return null;
	}

	public void deleteUsers(Collection<User> users) {
		// TODO HibernateUserDAO.deleteUsers()
		
	}
}
