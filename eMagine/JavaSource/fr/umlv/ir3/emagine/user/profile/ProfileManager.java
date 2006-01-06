package fr.umlv.ir3.emagine.user.profile;

import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

@MustHaveRights("profile")
public interface ProfileManager extends BaseManager<Profile, ProfileDAO> {

	/**
	 * Deletes a the given "deletingProfile" profile, and reallocate all its users to the "reallocatingProfile" specified.
	 * @param deletingProfile the profile to delete
	 * @param reallocatingProfile the profile to give the users' old ones to
	 * @throws EMagineException throws if an SQLException occures
	 */
	public abstract void delete(Profile deletingProfile,
			Profile reallocatingProfile) throws EMagineException;

}