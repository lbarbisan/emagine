package fr.umlv.ir3.emagine.user;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class UserManager extends BaseManager<User, UserDAO> {

	/**
	 * Create a new user with the given User
	 * @param user the user to create
	 * @throws EMagineException if the login already exists, or if there is an SQL exception
	 */
	public void create(User user) throws EMagineException {
		// Create the new User
		// TODO : createUser : vérif login unique
		
		DAOManager.beginTransaction();
		try {
			getDAO().create(user);
			// TODO : createUser : Mail
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
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
			// TODO : modifyUser : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
			// TODO : modifyUser : vérif login unique
			getDAO().update(user);
			// TODO : modifyUser : Mail
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Delete a list of users.
	 * @param users The list of users to be deleted
	 * @param force Force the deletion, even if one user is connected
	 * @throws EMagineException if one of those users doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public void delete(List<User> users, boolean force) throws EMagineException {
		// TODO : gérer les user connectés, notamment, supprimer ceux qui sont pas connectés, et question sur les autres ? ...
		super.delete(users);
	}

	/**
	 * Lists users, using the given search parameters
	 * @param studentSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<User> getUsers(UserSearchParam userSearchParam) throws EMagineException {
		return getDAO().getUsers(userSearchParam);
	}
	
	protected UserDAO getDAO() {
		return DAOManager.getInstance().getUserDAO();
	}
}
