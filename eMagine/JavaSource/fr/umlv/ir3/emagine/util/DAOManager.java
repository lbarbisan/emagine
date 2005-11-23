package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.ProfileDAO;

public class DAOManager {
	private static DAOManager instance;
	private UserDAO userDAO = new UserDAO();
	private ProfileDAO profileDAO = new ProfileDAO();
	
	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public static DAOManager getInstance() {
		if (instance == null) {
			instance = new DAOManager();
		}
		return instance;
	}
	
    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#beginTransaction()
     */
    public static void beginTransaction() {
    	HibernateUtils.beginTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#commitTransaction()
     */
    public static void commitTransaction() {
    	HibernateUtils.commitTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#rollBackTransaction()
     */
    public static void rollBackTransaction() {
    	HibernateUtils.rollbackTransaction();
        
    }

    /**
     * Close the session, flush the hibernate cache, commit the last uncommited objects
     *
     */
	public static void closeSession() {
		HibernateUtils.closeSession();
	}
}
