package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.BaseDAO;
import fr.umlv.ir3.emagine.util.HibernateUtils;

public class ProfileDAO extends BaseDAO<Profile> {
	@Override
	public Profile retrieve(long id) {
  	  return (Profile) HibernateUtils.getSession().load(Profile.class, id);
	}

	public Collection<Profile> getProfiles() {
		// TODO HibernateProfileDAO.getProfiles()
		return null;
	}
}
