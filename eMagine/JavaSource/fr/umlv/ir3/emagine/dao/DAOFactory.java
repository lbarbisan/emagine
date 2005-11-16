package fr.umlv.ir3.emagine.dao;

public interface DAOFactory {
	public UserDAO getUserDAO();
	public ProfileDAO getProfileDAO();
}
