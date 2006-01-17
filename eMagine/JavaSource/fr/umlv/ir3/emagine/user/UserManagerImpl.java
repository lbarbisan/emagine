package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.MailManager;



public class UserManagerImpl 
	extends EditableManagerImpl<User, UserDAO> 
	implements UserManager {

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#create(fr.umlv.ir3.emagine.user.User)
	 */
	@Override
	public void create(User user) throws EMagineException {
		DAOManager.beginTransaction();

		try {
			UserDAO dao = getDAO();
			dao.create(user);
			DAOManager.commitTransaction();
	
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;	// FIXME : Mapper sur la bonne erreur : en cas de double login, mettre un titre correct
		}
		
		try {
			MailManager.sendMail(user.getEmail(), "Titre création", "Corps création", null);	// FIXME : charger la phrase du titre du mail depuis les properties
		} catch (EMagineException exception) {
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
			
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;	// FIXME : Mapper sur la bonne erreur : en cas de double login, mettre un titre correct
		}
		
		try {
			MailManager.sendMail(user.getEmail(), "Titre modification", "Corps modification", null);
		} catch (EMagineException exception) {
			throw exception;	// FIXME : Mapper sur la bonne erreur : en cas de double login, mettre un titre correct
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.user.UserManager#delete(fr.umlv.ir3.emagine.user.User, boolean)
	 */
	public void delete(User user, boolean force) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			if (SessionManager.getInstance().isUserConnected(user)) {
				if (force) {
					SessionManager.getInstance().killUserSession(user);
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
	 * @see fr.umlv.ir3.emagine.user.UserManager#find(java.lang.String, java.lang.String)
	 */
	public User find(String login, String password) throws EMagineException {
		return getDAO().find(login, password);
	}
	
	protected UserDAO getDAO() {
		return DAOManager.getInstance().getUserDAO();
	}
}
