package fr.umlv.ir3.emagine.user;

import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;

public interface UserManager
	extends EditableManager<User, UserDAO> {

	/**
	 * Creates a new user with the given User. Sends a mail to the new user.
	 * @param user the user to create
	 * @throws EMagineException if the login already exists, or if there is an SQL exception
	 */
	@MustHaveRights("user.create")
	public void create(User user) throws EMagineException;

	/**
	 * Updates the given User. If the current connected user doesn't have sufficient rights, a modification is added to the specified user.
	 * Sends a mail to the modified user.
	 * @param user the user to update
	 * @throws EMagineException if the login already exists for another id, or if there is an SQL exception
	 */
	@MustHaveRights("user.update")
	public void update(User user) throws EMagineException;

	/**
	 * Delete a user. If the user is connected and the force switch is set to <code>true</code>, the user's session is killed, and then the user is deleted.
	 * @param users The list of users to be deleted
	 * @param force Force the deletion, even if the user is connected
	 * @throws EMagineException if the user doesn't exist in the database, or if he or she is connected and the force switch is <code>false</code>
	 */
	@MustHaveRights("user.delete")
	public void delete(User user, boolean force) throws EMagineException;

	/**
	 * Returns the user who's login and password is specified 
	 * @param login the User's login
	 * @param password the User's password
	 * @return the User with the given login and password, or null if not found
	 * @throws EMagineException if an SQLException occures
	 */
	public User find(String login, String password) throws EMagineException;

}