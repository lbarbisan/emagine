package fr.umlv.ir3.emagine.dao;

public interface DAOFactory {
	public UserDAO getUserDAO();
	public ProfileDAO getProfileDAO();
      
    public void beginTransaction();
    public void commitTransaction();
    public void rollBackTransaction();
    
}
