package fr.umlv.ir3.emagine.modification;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class ModificationThread implements Runnable {

	private static UserDAO userDao;
	private static User user;
	
	private Log log = LogFactory.getLog(EditableInterceptorTest.class);
	
	public void run() {

		EditableInterceptor editableInterceptor;
		try {
		editableInterceptor = ManagerManager.getInstance().getEditableManager().getModificationInterceptor();
		
		editableInterceptor.setDirectWriteAllowed(true);
		
		SearchParamsImpl searchParams = new SearchParamsImpl();
		userDao = DAOManager.getInstance().getUserDAO();
		
		searchParams.setField("FirstName", "Laurent");
		List<User> lists= userDao.find(searchParams);	
		user = lists.get(0);

		/* Generate password */
		char[] password = new char[10];
		
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		for(int index=0;index<10;index++)
		{
			password[index] =  (char) (random.nextDouble()*53 + 65);
		}
	
		log.debug("Set password for '" + user + "' to '" + String.copyValueOf(password) + "'");
		user.setPassword(String.copyValueOf(password));
		
		DAOManager.beginTransaction();
		userDao.update(user);
		DAOManager.commitTransaction();
		log.debug("Test accept modification");
		
		} catch (EMagineException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
