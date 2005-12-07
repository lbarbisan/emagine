package fr.umlv.ir3.emagine.user;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class UserDAO extends BaseDAO<User> {

	public List<User> find(UserSearchParam userSearchParam)
			throws EMagineException {
		// TODO UserDAO.getUsers()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}

	/**
	 * Lists all users.
	 * 
	 * @return
	 */
	public List<User> findAll() {
		// TODO UserDAO.findAll()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}

	/**
	 * Returns the user who's login is specified
	 * 
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException
	 *             if an SQLException occures
	 */
	public User find(String login) {
		return (User) HibernateUtils.getSession().createQuery(
				"from User where login = :loginParam").setParameter(
				"loginParam", login, Hibernate.STRING).list().get(0);
	}
}
