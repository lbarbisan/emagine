package fr.umlv.ir3.emagine.modification;

import java.util.List;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;
import junit.framework.TestCase;

public class ModificationInterceptorTest extends TestCase {

	private static UserDAO userDao;
	private static User user;
	
	
	/*
	 * Test method for 'fr.umlv.ir3.emagine.modification.ModificationInterceptor.onFlushDirty(Object, Serializable, Object[], Object[], String[], Type[])'
	 */
	public void testOnFlushDirtyObjectSerializableObjectArrayObjectArrayStringArrayTypeArray() throws EMagineException {
		
		SearchParamsImpl searchParams = new SearchParamsImpl();
		userDao = DAOManager.getInstance().getUserDAO();
		
		searchParams.setField("FirstName", "Laurent");
		List<User> lists= userDao.find(searchParams);	
		user = lists.get(0);

		/* Generate password */
		char[] password = new char[10];
		for(int index=0;index<10;index++)
		{
			password[index] = (char) ((Math.random()*56)+65);
		}
		
		user.setPassword(password.toString());
		
		DAOManager.beginTransaction();
		userDao.update(user);
		DAOManager.commitTransaction();

	}

}
