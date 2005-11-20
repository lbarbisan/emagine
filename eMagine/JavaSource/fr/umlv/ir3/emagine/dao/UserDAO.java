package fr.umlv.ir3.emagine.dao;

import java.util.Collection;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.IUserSearchForm;

public interface UserDAO extends BaseDAO<User> {
	public Collection<User> getUsers(IUserSearchForm userSearchParam);
}
