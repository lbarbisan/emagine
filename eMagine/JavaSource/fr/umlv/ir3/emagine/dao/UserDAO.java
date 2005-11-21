package fr.umlv.ir3.emagine.dao;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.core.user.User;
import fr.umlv.ir3.emagine.user.UserSearchParam;

public interface UserDAO extends BaseDAO<User> {
	public List<User> getUsers(UserSearchParam userSearchParam);
	public void deleteUsers(Collection<User> users);
}
