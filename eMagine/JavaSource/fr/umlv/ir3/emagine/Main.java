package fr.umlv.ir3.emagine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;

import fr.umlv.ir3.emagine.extraction.CSVExtractor;
import fr.umlv.ir3.emagine.extraction.Extractable;
import fr.umlv.ir3.emagine.extraction.Extractor;
import fr.umlv.ir3.emagine.extraction.ObjectListExtractable;
import fr.umlv.ir3.emagine.extraction.XLSExtractor;
import fr.umlv.ir3.emagine.modification.Modification;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.search.SearchParamsImpl;


public class Main {

	private static UserDAO userDao;
	private static User user;
	
	
	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {
		
			SearchParamsImpl searchParams = new SearchParamsImpl();
			
			userDao = DAOManager.getInstance().getUserDAO();
			searchParams.setField("FirstName", "Laurent");
			List<User> lists= userDao.find(searchParams);	
			user = lists.get(0);
			user.setPassword(args[0]);
			
			DAOManager.beginTransaction();
			userDao.update(user);
			DAOManager.commitTransaction();
			
//			DAOManager.beginTransaction();
//			Modification modification = new Modification();
//			modification.setComment("zer");
//			HibernateUtils.getSession().save(modification);
//			DAOManager.commitTransaction();
			
	
	}
	
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