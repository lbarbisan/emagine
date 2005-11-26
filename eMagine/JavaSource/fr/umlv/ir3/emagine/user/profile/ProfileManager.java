package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class ProfileManager {

	public Collection<Profile> getProfiles() throws EMagineException {
		return getDAO().getProfiles();	// TODO : getProfiles javadoc (notamment pour les exceptions)
	}

	private ProfileDAO getDAO() {
		return DAOManager.getInstance().getProfileDAO();
	}

}
