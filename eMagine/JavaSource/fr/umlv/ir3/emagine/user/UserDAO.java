package fr.umlv.ir3.emagine.user;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class UserDAO extends BaseDAO<User> {

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
	 * Returns the user who's login and password is specified
	 * 
	 * @param login
	 *            the User's login
	 * @param password
	 *            the User's password
	 * @return the User with the given login and password, or null if not found
	 * @throws EMagineException
	 *             if an SQLException occures
	 */
	@SuppressWarnings("unchecked")
	public User find(String login, String password) {
		List<User> foundUsers = (List<User>) HibernateUtils
				.getSession()
				.createQuery(
						"from User where login = :loginParam and password = :passwordParam")
				.setParameter("loginParam", login, Hibernate.STRING)
				.setParameter("passwordParam", password, Hibernate.STRING)
				.list();
		if (foundUsers.size() <= 0) {
			return null;
		}
		return foundUsers.get(0);
	}
}
