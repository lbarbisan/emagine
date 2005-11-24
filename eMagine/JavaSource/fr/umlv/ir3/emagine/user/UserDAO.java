package fr.umlv.ir3.emagine.user;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.BaseDAO;
import fr.umlv.ir3.emagine.util.HibernateUtils;

public class UserDAO extends BaseDAO<User> {
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