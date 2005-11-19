package fr.umlv.ir3.emagine.dao.hibernate;

import fr.umlv.ir3.emagine.dao.DAOFactory;
import fr.umlv.ir3.emagine.dao.ProfileDAO;
import fr.umlv.ir3.emagine.dao.UserDAO;

public class HibernateDAOFactory implements DAOFactory {

    /**
     * @see fr.umlv.ir3.emagine.dao.DAOFactory#getUserDAO()
     */
    public UserDAO getUserDAO() {
        return new HibernateUserDAO();
    }

    /**
     * @see fr.umlv.ir3.emagine.dao.DAOFactory#getProfileDAO()
     */
    public ProfileDAO getProfileDAO() {
        return new HibernateProfileDAO();
    }

    /**
     * @see fr.umlv.ir3.emagine.dao.DAOFactory#beginTransaction()
     */
    public void beginTransaction() {
    	HibernateUtils.beginTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.dao.DAOFactory#commitTransaction()
     */
    public void commitTransaction() {
    	HibernateUtils.commitTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.dao.DAOFactory#rollBackTransaction()
     */
    public void rollBackTransaction() {
    	HibernateUtils.rollbackTransaction();
        
    }

	public void openSession() {
		// TODO HibernateDAOFactory.openSession()
		
	}

	public void closeSession() {
		// TODO HibernateDAOFactory.closeSession()
		
	}

 
}
