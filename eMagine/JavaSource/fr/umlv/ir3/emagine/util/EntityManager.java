package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.user.UserManager;

public class EntityManager {
	private static EntityManager instance;
	private UserManager userManager = new UserManager();
	//private ProfileManager profileManager = new ProfileManager();

	public static EntityManager getInstance() {
		if (instance == null) {
			instance = new EntityManager();
		}
		return instance;
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
}
