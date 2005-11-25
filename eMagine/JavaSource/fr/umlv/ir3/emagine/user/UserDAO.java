package fr.umlv.ir3.emagine.user;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.BaseDAO;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;

public class UserDAO extends BaseDAO<User> {
	@Override
	public User retrieve(long id) {
	  	return (User) HibernateUtils.getSession().load(User.class, id);
	}
	
	@Override
	public void create(User object) throws EMagineException {
		// TODO UserDAO.create() : Mail
		super.create(object);
	}

	public List<User> getUsers(UserSearchParam userSearchParam) throws EMagineException {
		// TODO HibernateUserDAO.getUsers()
		return null;
	}

	public void deleteUsers(Collection<User> users) throws EMagineException {
		// TODO HibernateUserDAO.deleteUsers()
	}
}
