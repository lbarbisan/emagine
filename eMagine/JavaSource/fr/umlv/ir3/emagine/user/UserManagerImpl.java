package fr.umlv.ir3.emagine.user;

import java.util.List;

import fr.umlv.ir3.emagine.extraction.ExtractionParam;
import fr.umlv.ir3.emagine.user.login.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.MailManager;
import fr.umlv.ir3.emagine.util.base.BaseEditableManagerImpl;



public class UserManagerImpl extends BaseEditableManagerImpl<User, UserDAO> implements UserManager {

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#create(fr.umlv.ir3.emagine.user.User)
	 */
	@Override
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
	 * @see fr.umlv.ir3.emagine.user.UserManager#update(fr.umlv.ir3.emagine.user.User)
	 */
	@Override
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
	 * @see fr.umlv.ir3.emagine.user.UserManager#delete(fr.umlv.ir3.emagine.user.User, boolean)
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
	 * @see fr.umlv.ir3.emagine.user.UserManager#find(fr.umlv.ir3.emagine.user.UserSearchParam)
	 */
	public List<User> find(UserSearchParam userSearchParam) throws EMagineException {
		UserDAO dao = getDAO();
		List<User> users = dao.find(userSearchParam);
		return users;
	}

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#find(java.lang.String, java.lang.String)
	 */
	public User find(String login, String password) throws EMagineException {
		return getDAO().find(login, password);
	}

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#findAll()
	 */
	public List<User> findAll()
	{
		UserDAO dao = getDAO();
		return dao.findAll();
	}
	
	protected UserDAO getDAO() {
		return DAOManager.getInstance().getUserDAO();
	}

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#retrieve(long)
	 */
	@Override
	public User retrieve(long id) throws EMagineException {
		return getDAO().retrieve(User.class, id);
	}

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#extract(fr.umlv.ir3.emagine.extraction.ExtractionParam)
	 */
	@Override
	public Extractable extract(ExtractionParam extractionParam) {
		// TODO UserManagerImpl.extract()
		return null;
	}
}
