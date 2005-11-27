package fr.umlv.ir3.emagine.user;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class UserDAO extends BaseDAO<User> {
	@Override
	public User retrieve(long id) {
	  	return (User) HibernateUtils.getSession().load(User.class, id);
	}

	public List<User> getUsers(UserSearchParam userSearchParam) throws EMagineException {
		// TODO HibernateUserDAO.getUsers()
		return null;
	}

	public void deleteUsers(Collection<User> users) throws EMagineException {
		// TODO HibernateUserDAO.deleteUsers()
	}
}
