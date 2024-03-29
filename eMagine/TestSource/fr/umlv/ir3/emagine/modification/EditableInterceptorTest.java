package fr.umlv.ir3.emagine.modification;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;

public class EditableInterceptorTest extends TestCase {

	private static UserDAO userDao;
	private static User user;
	
	private Log log = LogFactory.getLog(EditableInterceptorTest.class);
	
	/*
	 * Test method for 'fr.umlv.ir3.emagine.modification.ModificationInterceptor.onFlushDirty(Object, Serializable, Object[], Object[], String[], Type[])'
	 */
	@SuppressWarnings("unchecked")
	public void testOnFlushDirtyObjectSerializableObjectArrayObjectArrayStringArrayTypeArray() throws EMagineException {
		
		EditableInterceptor editableInterceptor =  ManagerManager.getInstance().getEditableManager().getModificationInterceptor();

		editableInterceptor.setDirectWriteAllowed(false);
		
//		Thread thread = new Thread(new ModificationThread());
//		thread.run();
//		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println(editableInterceptor.isDirectWriteAllowed());
		 
		SearchParamsImpl searchParams = new SearchParamsImpl();
		userDao = DAOManager.getInstance().getUserDAO();
		
		searchParams.setField("FirstName", "Laurent");
		List<User> lists= userDao.find(searchParams);	
		user = lists.get(0);
		user.getProfile().setName("Profile2");

		assertNotNull(user);

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
		System.out.println(user.getPassword());
		log.debug("Test accept modification");
		
		/* Accepte les modification du password */
		//FIXME : A repasser en mode Normal avec la s�curit� standard
		editableInterceptor.setDirectWriteAllowed(true);
		ManagerManager.getInstance().getEditableManager().acceptAllModification(user);
		
	}
}
