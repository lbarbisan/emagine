package fr.umlv.ir3.emagine;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.HibernateUtils;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DAOManager.beginTransaction();
		
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		
		/*User user = new User();
		user.setEmail("email@fr");
		user.setFirstName("Laurent");
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("dfsd");
		userDAO.create(user);*/
		
		User user = userDAO.retrieve(3L);
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("dfsd");
		HibernateUtils.getPropertySnapShot(user);
		DAOManager.commitTransaction();
		HibernateUtils.getPropertySnapShot(user);
		
	}

}
