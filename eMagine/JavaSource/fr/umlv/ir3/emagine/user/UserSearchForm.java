package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.util.IsASearchParam;
import fr.umlv.ir3.emagine.util.search.SelectSearchForm;

public class UserSearchForm extends SelectSearchForm<User> implements UserSearchParam {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	//@IsASearchParam
	private String firstName;

	//@IsASearchParam
	private String lastName;

	//@IsASearchParam
	private String login;

	//@IsASearchParam
	private String idProfile;
	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;

	/** List of all profils **/
	private Collection <Profile> profiles;
	
	/** Use to DispacthAction **/
	private String action;
	
	
	/**
	 * @see fr.umlv.ir3.emagine.util.search.SearchForm#reset()
	 */
	public void reset() {
		firstName = "";
		lastName = "";
		login = "";
		deletionForced = false;
		idProfile = "";
		profiles = null;
		action = "";
		super.reset();
	}
	
	
	/**
	 * @return Returns the deletionForced.
	 */
	public boolean isDeletionForced() {
		return deletionForced;
	}
	/**
	 * @param deletionForced The deletionForced to set.
	 */
	public void setDeletionForced(boolean deletionForced) {
		this.deletionForced = deletionForced;
	}
	/**
	 * @return Returns the firstName.
	 */
	@IsASearchParam("user.firstName")
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return Returns the lastName.
	 */
	@IsASearchParam("user.lastName")
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return Returns the login.
	 */
	@IsASearchParam("user.login")
	public String getLogin() {
		return login;
	}
	/**
	 * @param login The login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return Returns the profile.
	 */
	@IsASearchParam(
			value = "user.profile.id",
			type = Long.class)
	public String getProfile() {
		return idProfile;
	}
	/**
	 * @param profile The profile to set.
	 */
	public void setProfile(String profile) {
		this.idProfile = profile;
	}
	/**
	 * @return Returns the profiles.
	 */
	public Collection<Profile> getProfiles() {
		return profiles;
	}
	/**
	 * @param profiles The profiles to set.
	 */
	public void setProfiles(Collection<Profile> profiles) {
		this.profiles = profiles;
	}
	/**
	 * @return Returns the action.
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action The action to set.
	 */
	public void setAction(String action) {
		this.action = action;
	}
}
