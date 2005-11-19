package fr.umlv.ir3.emagine.dao.hibernate;

import java.util.Collection;

import fr.umlv.ir3.emagine.dao.ProfileDAO;
import fr.umlv.ir3.emagine.user.Profile;

public class HibernateProfileDAO extends HibernateBaseDAO<Profile> implements ProfileDAO {

	@Override
	public Profile retrieve(long id) {
  	  return (Profile) HibernateUtils.getSession().load(Profile.class, id);
	}

	public Collection<Profile> getProfiles() {
		// TODO HibernateProfileDAO.getProfiles()
		return null;
	}
}
