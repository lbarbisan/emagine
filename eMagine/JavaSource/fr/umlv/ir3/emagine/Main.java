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
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;


public class Main {

	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {

		/*
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		User user = new User();
		user.setEmail("email@fr");
		user.setFirstName("Laurent");
		user.setLastName("Barbisan");
		user.setLogin("lbarbisan");
		user.setPassword("dfsd");
		userDAO.create(user);
		
		DAOManager.beginTransaction();

		userDAO.create(user);
		DAOManager.commitTransaction();*/
		
		/*UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		SearchParamImpl searchParam = new SearchParamImpl();
		searchParam.setField("firstName", "Laurent");
		searchParam.setField("lastName", "Barbisan");
		try {
			RightDAO rightDAO = DAOManager.getInstance().getRightDAO();
			ProfileDAO profileDAO = DAOManager.getInstance().getProfileDAO();
			UserDAO userDAO = DAOManager.getInstance().getUserDAO();
			
			Profile profile = new Profile();
			profile.setName("User");
			List<Right> rights = new ArrayList<Right>();
			
			Right right = new Right();
			right.setName("user.create");
			rightDAO.create(right);
			rights.add(right);
	
			right = new Right();
			right.setName("user.update");
			rightDAO.create(right);
			rights.add(right);
			
			right = new Right();
			right.setName("user.delete");
			rightDAO.create(right);
			rights.add(right);
	
			right = new Right();
			right.setName("user.find");
			rightDAO.create(right);
			rights.add(right);
			
			profile.setRights(rights);
			profileDAO.create(profile);
			
			User user = userDAO.retrieve(1L);
			user.setProfile(profile);
			userDAO.update(user);
			
			DAOManager.commitTransaction();
		} catch (Exception exception) {
			DAOManager.rollBackTransaction();
		}
		
//		user.setLastName("Barbisan");
//		user.setLogin("lbarbisan");
//		user.setPassword("dfsd");
//		HibernateUtils.getPropertySnapShot(user);
//		DAOManager.commitTransaction();
//		HibernateUtils.getPropertySnapShot(user);

		//Collection<User> list = userDAO.find(searchParam);
		/*
		for (User user : list) {
			System.out.println(user.getFirstName());
		}
		*/
		/*List<User> users = new ArrayList<User>();
		users.add(user);
		UserSearchForm userSearchForm = new UserSearchForm();
		userSearchForm.setResults(users);

		ExtractionForm extractionForm = new ExtractionForm();
		extractionForm.setExtractionType(ExtractionType.XLS);
		extractionForm.setExtractable(userSearchForm);
		

		ManagerManager.getInstance().getExtractionManager().extract(extractionForm, new FileOutputStream(new File("toto.xls")));
		*/
		
		
		/*
		UserSearchForm form = new UserSearchForm();
		for (String field : form.getFields()) {
			System.out.println(field);
		}
		
		for (Field field : form.getClass().getDeclaredFields()) {
			System.out.println(" > "+field+" // "+field.isAnnotationPresent(IsAField.class));
		}
		
		/*
		for (Object string : CountryEnum.values()) {
			System.out.println(string);
		}
		CountryEnum.valueOf("FR");
		
		
		UserSearchForm form = new UserSearchForm();
		for (String field : form.getFields()) {
			System.out.println(field);
		}
		
		for (Class klass : form.getClass().getInterfaces()) {
			for (Method method : klass.getDeclaredMethods()) {
				Annotation[] annotations = method.getDeclaredAnnotations();
				System.out.print(" > "+method+" // ");
				for (Annotation annotation : annotations) {
					System.out.print(annotation);
					if (annotation instanceof RequestParam) {
						System.out.print(" : "+((RequestParam)annotation).value());
					}
				}
				System.out.println();
			}
		}
		*/

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