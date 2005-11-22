package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.ProfileDAO;

public class DAOManager {
	private static UserDAO userDAO = new UserDAO();
	private static ProfileDAO profileDAO = new ProfileDAO();
	
	public static ProfileDAO getProfileDAO() {
		return profileDAO;
	}
	public static UserDAO getUserDAO() {
		return userDAO;
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

	public static void openSession() {
		// TODO HibernateDAOFactory.openSession()
		
	}

	public static void closeSession() {
		// TODO HibernateDAOFactory.closeSession()
		
	}
}
