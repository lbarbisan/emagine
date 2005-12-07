package fr.umlv.ir3.emagine.user;

import java.util.List;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.user.login.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;



public class UserManager extends BaseEditableManager<User, UserDAO> {

	/**
	 * Create a new user with the given User
	 * @param user the user to create
	 * @throws EMagineException if the login already exists, or if there is an SQL exception
	 */
	public void create(User user) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			UserDAO dao = getDAO();
			dao.create(user);
			MailManager.sendMail(user.getEmail(), "Titre création", "Corps création", null);	// FIXME : charger la phrase du titre du mail depuis les properties
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;	// FIXME : Mapper sur la bonne erreur : en cas de double login, mettre un titre correct
		}
	}

	/**
	 * Update the given User
	 * @param user the user to update
	 * @throws EMagineException if the login already exists for another id, or if there is an SQL exception
	 */
	public void update(User user) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			UserDAO dao = getDAO();
			dao.update(user);
			MailManager.sendMail(user.getEmail(), "Titre modification", "Corps modification", null);	// FIXME : charger la phrase du titre du mail depuis les properties
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;	// FIXME : Mapper sur la bonne erreur : en cas de double login, mettre un titre correct
		}
	}

	/**
	 * Delete a user. If the user is connected and the force switch is set to <code>true</code>, the user's session is killed, and then the user is deleted.
	 * @param users The list of users to be deleted
	 * @param force Force the deletion, even if the user is connected
	 * @throws EMagineException if the user doesn't exist in the database, or if he or she is connected and the force switch is <code>false</code>
	 */
	public void delete(User user, boolean force) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			if (SessionManager.isUserConnected(user)) {
				if (force) {
					SessionManager.killUserSession(user);
				} else {
					throw new EMagineException("exception.userManager.delete.userConnected");
				}
			}
			UserDAO dao = getDAO();
			dao.delete(user);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Lists users, using the given search parameters
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<User> find(UserSearchParam userSearchParam) throws EMagineException {
		UserDAO dao = getDAO();
		List<User> users = dao.find(userSearchParam);
		return users;
	}

	/**
	 * Returns the user who's login is specified 
	 * @param apprenticeSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public User find(String login) throws EMagineException {
		return getDAO().find(login);
	}

	/**
	 * Lists all users.
	 * @return
	 */
	public List<User> findAll()
	{
		UserDAO dao = getDAO();
		return dao.findAll();
	}
	
	protected UserDAO getDAO() {
		return DAOManager.getInstance().getUserDAO();
	}

	@Override
	public User retrieve(long id) throws EMagineException {
		return getDAO().retrieve(User.class, id);
	}

	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO UserManager.extract()
		return null;
	}
}
