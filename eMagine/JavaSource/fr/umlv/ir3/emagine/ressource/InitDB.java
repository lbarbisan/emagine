package fr.umlv.ir3.emagine.ressource;

import java.io.FileNotFoundException;
import java.util.Collection;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParamImpl;

public class InitDB {

	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {
		InitializeUser();
	}
	
	public static void InitializeUser()
	{
		
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		DAOManager.beginTransaction();
		
		try {
		
		Profile profile = new Profile();
		profile.setDescription("Droit des utilisateurs");
		profile.setName("User");
		profile.addRights(new Right("User.create"));
		profile.addRights(new Right("User.update"));
		profile.addRights(new Right("User.delete"));
		profile.addRights(new Right("User.find"));
			
		User user = new User();
		user.setEmail("lbarbisan@gmail.com");
		user.setFirstName("Laurent");
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("lbarbisan");	
		user.setProfile(profile);
		userDAO.create(user);

		user = new User();
		user.setEmail("netangel@gmail.com");
		user.setFirstName("Anthony");
		user.setLastName("Ogier");
		user.setLogin("aogier");
		user.setPassword("aogier");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("jrenaudi@gmail.com");
		user.setFirstName("Jean-Baptiste");
		user.setLastName("Renaudi");
		user.setLogin("jrenaudi");
		user.setPassword("jrenaudi");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("caroline.rondini@free.fr");
		user.setFirstName("Caroline");
		user.setLastName("Rondini");
		user.setLogin("crondini");
		user.setPassword("crondini");
		user.setProfile(profile);
		userDAO.create(user);
		
		user = new User();
		user.setEmail("mmancel@gmail.com");
		user.setFirstName("Mathieu");
		user.setLastName("Mancel");
		user.setLogin("mmancel");
		user.setPassword("mmancel");
		user.setProfile(profile);
		userDAO.create(user);
		
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
		DAOManager.commitTransaction();

	}

}