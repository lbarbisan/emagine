package fr.umlv.ir3.emagine.dao;

import java.util.Collection;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserSearchParam;

public interface UserDAO extends BaseDAO<User> {
	public Collection<User> getUsers(UserSearchParam userSearchParam);
	public void deleteUsers(Collection<User> users);
}
