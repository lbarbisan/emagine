package fr.umlv.ir3.emagine.user;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

import fr.umlv.ir3.emagine.user.profile.Profile;

public class UserDetailsForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	/** Current user **/
	private User user;
	
	/** List of all profils **/
	private Collection <Profile> profiles;

	/** Use to DispacthAction **/
	private String dispatch;

	
	
	/**
	 * @return Returns the dispatch.
	 */
	public String getDispatch() {
		return dispatch;
	}

	/**
	 * @param dispatch The dispatch to set.
	 */
	public void setDispatch(String dispatch) {
		this.dispatch = dispatch;
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
	 * @return Returns the user.
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user The user to set.
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
