package fr.umlv.ir3.emagine;

import java.io.FileNotFoundException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import fr.umlv.ir3.emagine.user.UserSearchForm;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.RequestParam;

public class Main {

	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {

		/*
		DAOManager.beginTransaction();
		
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		
//		User user = new User();
//		user.setEmail("email@fr");
//		user.setFirstName("Laurent");
//		user.setLastName("Barbisan");
//		user.setLogin("lbarbisan");
//		user.setPassword("dfsd");
//		userDAO.create(user);
//		
//		DAOManager.beginTransaction();
//		userDAO.create(user);
//		DAOManager.commitTransaction();
		

		User user = userDAO.retrieve(User.class, 1L);
//		user.setLastName("Barbisan");
//		user.setLogin("lbarbisan");
//		user.setPassword("dfsd");
//		HibernateUtils.getPropertySnapShot(user);
//		DAOManager.commitTransaction();
//		HibernateUtils.getPropertySnapShot(user);

		
		List<User> users = new ArrayList<User>();
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
		*/
		
		
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

	}

}