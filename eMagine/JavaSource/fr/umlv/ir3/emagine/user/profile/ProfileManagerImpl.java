package fr.umlv.ir3.emagine.user.profile;

import java.util.List;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class ProfileManagerImpl extends BaseManagerImpl<Profile, ProfileDAO> implements ProfileManager {

	/**
	 * @see fr.umlv.ir3.emagine.user.profile.ProfileManager#delete(fr.umlv.ir3.emagine.user.profile.Profile, fr.umlv.ir3.emagine.user.profile.Profile)
	 */
	public void delete(Profile deletingProfile, Profile reallocatingProfile) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<User> usersFrom = deletingProfile.getUsers();
			List<User> usersTo = reallocatingProfile.getUsers();
			usersTo.addAll(usersFrom);
			ProfileDAO dao = getDAO();
			dao.delete(deletingProfile);
			dao.update(reallocatingProfile);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	public ProfileDAO getDAO() {
		return DAOManager.getInstance().getProfileDAO();
	}
}
