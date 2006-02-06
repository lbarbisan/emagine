package fr.umlv.ir3.emagine.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.search.SearchParams;

public class UserDAO extends BaseDAO<User> {

	private Log log = LogFactory.getLog(UserDAO.class);
	
	@Override
	public List<User> find(SearchParams searchParams) throws EMagineException {
		List<User> list = super.find(searchParams);
		
		return list;
		
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
		User user =  (User)HibernateUtils
				.getSession()
				.createQuery(
						"from User where login = :loginParam and password = :passwordParam")
				.setParameter("loginParam", login, Hibernate.STRING)
				.setParameter("passwordParam", password, Hibernate.STRING)
				.uniqueResult();
		return user;
	}
}
