package fr.umlv.ir3.emagine.user.profile;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class ProfileDAO extends BaseDAO<Profile> {
	@Override
	public Profile retrieve(long id) {
  	  return (Profile) HibernateUtils.getSession().load(Profile.class, id);
	}

	public Collection<Profile> getProfiles() throws EMagineException {
		// TODO HibernateProfileDAO.getProfiles()
		return null;
	}
}
