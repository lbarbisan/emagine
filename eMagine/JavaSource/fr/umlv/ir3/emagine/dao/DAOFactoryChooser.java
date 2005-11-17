package fr.umlv.ir3.emagine.dao;

import fr.umlv.ir3.emagine.dao.hibernate.HibernateDAOFactory;

public class DAOFactoryChooser {
	
    public static enum DataSourceType {HIBERNATE, DEFAULT};
    
    private static DAOFactory currentDAOFactory;
    
    public static DAOFactory getCurrentDAOFactory() {
		return currentDAOFactory;
	}
    
    public static void setCurrentDAOFactory(DataSourceType dataSourceType)
    {
        switch(dataSourceType)
        {
            case HIBERNATE :
                currentDAOFactory = new HibernateDAOFactory();
                break;
                
            case DEFAULT:    
            default :
                currentDAOFactory = new HibernateDAOFactory();
                break;
        }
    }
}
