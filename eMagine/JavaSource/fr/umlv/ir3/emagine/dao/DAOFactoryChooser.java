package fr.umlv.ir3.emagine.dao;

import fr.umlv.ir3.emagine.dao.hibernate.HibernateDAOFactory;

public class DAOFactoryChooser {
	
    public static enum DataSourceType {HIBERNATE, DEFAULT};
    
    private static DAOFactory currentDAOFactory;
    
    public static DAOFactory getCurrentDAOFactory() {
		if(currentDAOFactory==null)
		{
			setCurrentDAOFactory(DataSourceType.DEFAULT);
		}
    	return currentDAOFactory;
	}
    
    public static void setCurrentDAOFactory(DataSourceType dataSourceType)
    {
        if(dataSourceType==null)
        {
        	dataSourceType = DataSourceType.DEFAULT;
        }
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
