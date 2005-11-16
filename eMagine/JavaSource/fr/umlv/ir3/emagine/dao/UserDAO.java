package fr.umlv.ir3.emagine.dao;

import java.util.Collection;

import fr.umlv.ir3.emagine.user.User;

public interface UserDAO {
	public Collection<User> getUsers(UserSearchParam userSearchParam);
}
