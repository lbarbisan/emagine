package fr.umlv.ir3.emagine.dao;

import java.util.Collection;

import fr.umlv.ir3.emagine.core.user.profile.Profile;

public interface ProfileDAO extends BaseDAO<Profile> {
	public Collection<Profile> getProfiles();
}
