package fr.umlv.ir3.emagine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.emagine.extraction.CSVExtractor;
import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.Extractor;
import fr.umlv.ir3.emagine.extraction.ObjectListExtractable;
import fr.umlv.ir3.emagine.extraction.XLSExtractor;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

/**
 * This class is used to  do temp tests.
 * This class isn't not used in production
 * @author eMagine Team
 */
public class Main {

	private static UserDAO userDao;
	private static User user;
	
	
	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {
	}
	
	/**
	 * 
	 * @throws FileNotFoundException
	 * @throws EMagineException
	 */
	public static void Extract() throws FileNotFoundException, EMagineException
	{
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		List<User> users = userDAO.findAll();
		List<String> properties = new ArrayList<String>();
		properties.add("firstName");
		properties.add("lastName");
		properties.add("login");
		properties.add("password");
		properties.add("email");
		properties.add("profile.name");
		
		Extractable extractable = new ObjectListExtractable<User>(users, properties);
		Extractor extractor = new XLSExtractor();
		OutputStream outputStream = new FileOutputStream(new File("toto.xls"));
		extractor.extract(extractable, outputStream);

		extractor = new CSVExtractor();
		outputStream = new FileOutputStream(new File("toto.csv"));
		extractor.extract(extractable, outputStream);	
	}
}