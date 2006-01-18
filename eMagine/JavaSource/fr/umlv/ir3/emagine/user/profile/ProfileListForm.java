package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import org.apache.struts.action.ActionForm;

public class ProfileListForm extends ActionForm {
	
	private static final long serialVersionUID = -2405706291327109100L;

	
	/** Decide if you must force the deleted of entity **/
	private boolean deletionForced;

	/** List of all profils **/
	private Collection <Profile> profiles;

	/** Use to DispacthAction **/
	private String dispatch;
	
	
	/**
	 * Reset information
	 */
	public void reset() {
		profiles = null;
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
}