package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class ProfileManager extends BaseManagerImpl<Profile, ProfileDAO> {

	/**
	 * Lists all the profiles.
	 * @return
	 * @throws EMagineException
	 */
	public Collection<Profile> findAll() throws EMagineException {
		ProfileDAO dao = getDAO();
		return dao.findAll();
	}
	
	/**
	 * Deletes a the given "deletingProfile" profile, and reallocate all its users to the "reallocatingProfile" specified.
	 * @param deletingProfile the profile to delete
	 * @param reallocatingProfile the profile to give the users' old ones to
	 * @throws EMagineException throws if an SQLException occures
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
	
	@Override
	public Profile retrieve(long id) throws EMagineException {
		return getDAO().retrieve(Profile.class, id);
	}

}
