package fr.umlv.ir3.emagine.ressource;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import fr.umlv.ir3.emagine.apprentice.Contact;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorDAO;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.user.profile.RightDAO;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class InitDB {

	/**
	 * @param args
	 * @throws EMagineException
	 * @throws FileNotFoundException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static void main(String[] args) throws FileNotFoundException,
			EMagineException, IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		// Initialize Enum
		Object[] objects = { 1,4 };
		for (Method method : InitEnums.class.getDeclaredMethods()) {
			if (method.getName().startsWith("create")) {
				method.invoke(null, objects);
			}
		}

		InitializeUser();
		createUsers(1, 4);
		createTeachers(1, 4);
		InitializeFormationCenter();
		InitializeCandidate(1,4);
	}

	private static final void InitializeCandidate(int start, int end) throws EMagineException
	{
		
		CandidateDAO candidateDAO = DAOManager.getInstance().getCandidateDAO();
		DAOManager.beginTransaction();
		
		for(int index=start; index < end; index++)
		{
		
		Contact contact = new Contact();
		contact.setAddressPersonnal(createAddress(index));
		contact.setBirthdayCity("Ville" + index);
		contact.setBirthdayCountry((CountryEnum) InitEnums.getEmagineEnum("Country " + index, CountryEnum.class));
		contact.setBirthdayDate(new Date());
		contact.setBirthdayDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department " + index, DepartmentEnum.class));
		contact.setEmail("contact" + index + "@gmail.com");
		contact.setFirstName("LastNameContact" + index);
		contact.setLastName("FirstNameContact" + index);
		contact.setFax("01012" + index);
		contact.setMobilePhone("32902930" + index);
		contact.setNationality((NationalityEnum) InitEnums.getEmagineEnum("Nationality " + index, NationalityEnum.class));
		contact.setPhone("8798798" + index);
		contact.setSex((SexEnum) InitEnums.getEmagineEnum("Male", SexEnum.class));
		
		Candidate candidate = new Candidate();
		candidate.setAccepted(false);
		candidate.setAddressPersonnal(createAddress(index));
		candidate.setBirthdayCity("Ville" + index);
		candidate.setBirthdayCountry((CountryEnum) InitEnums.getEmagineEnum("Country " + index, CountryEnum.class));
		candidate.setBirthdayDate(new Date());
		candidate.setBirthdayDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department " + index, DepartmentEnum.class));
		candidate.setContactOriginIG2K(contact);
		candidate.setCourseOption((CourseOptionEnum) InitEnums.getEmagineEnum("CourseOption " + index, CourseOptionEnum.class));
		candidate.setEmail(contact.getEmail());
		candidate.setEntryLevel((LevelEntryEnum) InitEnums.getEmagineEnum("Level " + index, LevelEntryEnum.class));
		candidate.setFax("70987987" + index);
		candidate.setFirstName(contact.getFirstName() + "Candidate");
//		candidate.setFormationCenter()
//		candidate.setLastDiploma()
		candidate.setLastName(contact.getLastName() + "Candiate");
//		candidate.setLastSection()
		candidate.setMobilePhone("87695468" + index);
		candidate.setNationality(contact.getNationality());
//		candidate.setOtherFormation()
		candidate.setPhone("098098" + index);
//		candidate.setProfessionFather()
//		candidate.setProfessionMother()
		candidateDAO.create(candidate);

		candidate.setSex(contact.getSex());
		}
		
		DAOManager.commitTransaction();
	}

	public static void InitializeUser() {

		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		DAOManager.beginTransaction();

		try {

			Profile administrateur = new Profile();
			administrateur.setDescription("Droit des utilisateurs");
			administrateur.setName("Administrateur");

			// Init Rights
			HashSet<String> rightSet = new HashSet<String>();

			File rootFolder = new File("JavaSource/fr");
			initFolderManager(rootFolder, "fr", rightSet);
			
			administrateur.setRights(DAOManager.getInstance().getRightDAO().findAll());
			
			Profile visitor = new Profile();
			visitor.setDescription("Droit des utilisateurs");
			visitor.setName("Utilisateur");

			User user = new User();
			user.setEmail("lbarbisan@gmail.com");
			user.setFirstName("Laurent");
			user.setLastName("Barbisan");
			user.setLogin("lbarbisan");
			user.setPassword("lbarbisan");
			user.setProfile(administrateur);
			userDAO.create(user);

			user = new User();
			user.setEmail("netangel@gmail.com");
			user.setFirstName("Anthony");
			user.setLastName("Ogier");
			user.setLogin("aogier");
			user.setPassword("aogier");
			user.setProfile(administrateur);
			userDAO.create(user);

			user = new User();
			user.setEmail("jrenaudi@gmail.com");
			user.setFirstName("Jean-Baptiste");
			user.setLastName("Renaudi");
			user.setLogin("jrenaudi");
			user.setPassword("jrenaudi");
			user.setProfile(administrateur);
			userDAO.create(user);

			user = new User();
			user.setEmail("caroline.rondini@free.fr");
			user.setFirstName("Caroline");
			user.setLastName("Rondini");
			user.setLogin("crondini");
			user.setPassword("crondini");
			user.setProfile(administrateur);
			userDAO.create(user);

			user = new User();
			user.setEmail("mmancel@gmail.com");
			user.setFirstName("Mathieu");
			user.setLastName("Mancel");
			user.setLogin("mmancel");
			user.setPassword("mmancel");
			user.setProfile(administrateur);
			userDAO.create(user);

			user = new User();
			user.setEmail("admin@gmail.com");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setLogin("admin");
			user.setPassword("admin");
			user.setProfile(administrateur);
			userDAO.create(user);
			
			
			user = new User();
			user.setEmail("a@gmail.com");
			user.setFirstName("a");
			user.setLastName("a");
			user.setLogin("a");
			user.setPassword("");
			user.setProfile(visitor);
			userDAO.create(user);
			
			user = new User();
			user.setEmail("user@gmail.com");
			user.setFirstName("user");
			user.setLastName("user");
			user.setLogin("user");
			user.setPassword("user");
			user.setProfile(visitor);
			userDAO.create(user);

			DAOManager.commitTransaction();
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}

	}

	private static void createUsers(int start, int length) {
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		DAOManager.beginTransaction();

		try {

			Profile CFA = new Profile();
			CFA.setDescription("Droit des utilisateurs");
			CFA.setName("CFA");

			for (int index = start; index < length; index++) {
				User user = new User();
				user.setEmail("user" + index + "@gmail.com");
				user.setFirstName("LastNameUser" + index);
				user.setLastName("FirstNameUser" + index);
				user.setLogin("login" + index);
				user.setPassword("password" + index);
				user.setProfile(CFA);
				userDAO.create(user);
			}

			DAOManager.commitTransaction();
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}

	}

	private static void createTeachers(int start, int length) {
		TeacherTutorDAO teacherTutorDAO = DAOManager.getInstance()
				.getTeacherTutorDAO();
		DAOManager.beginTransaction();

		try {

			for (int index = start; index < length; index++) {
				TeacherTutor teacher = new TeacherTutor();

				teacher.setAddressPersonnal(createAddress(index * 2));
				teacher.setAddressProfessional(createAddress(index));
				teacher.setBirthdayCity("Paris" + index);
				teacher.setBirthdayCountry((CountryEnum) InitEnums.getEmagineEnum("Country 1", CountryEnum.class));
				teacher.setBirthdayDate(Calendar.getInstance().getTime());
				teacher.setBirthdayDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department 1", DepartmentEnum.class));
				teacher.setEmail("mail" + index + "@gmail.com");
				teacher.setFax("9" + index * 100);
				teacher.setFirstName("LastNameTeachers" + index);
				teacher.setLastName("FirstNameTeachers" + index);
				teacher.setMobilePhone("709870");
				teacher.setPhone("12003" + index);
				teacher.setSex((SexEnum) InitEnums.getEmagineEnum("Male",  SexEnum.class));
				teacherTutorDAO.create(teacher);
			}

			DAOManager.commitTransaction();
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}

	}

	private static Address createAddress(int index) throws EMagineException {
		Address address = new Address();
		address.setCity("City" + index);
		address.setCountry((CountryEnum) InitEnums.getEmagineEnum("Country 1", CountryEnum.class));
		address.setDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department 1", DepartmentEnum.class));
		address.setPostalCode("99" + index);
		address.setStreet(index + "rue de la java");

		return address;
	}

	private static void InitializeFormationCenter() {
		FormationCenterDAO formationCenterDAO = DAOManager.getInstance()
				.getFormationCenterDAO();
		DAOManager.beginTransaction();
		try {

			

			FormationCenter formationCenter = new FormationCenter();
			formationCenter.setAddress(createAddress(1));
			formationCenter.setName("Lyon");
			formationCenter.setPhone("0180808080");

			Room room = new Room();
			room.setFormationCenter(formationCenter);
			room.setCapacity(100);
			room.setName("10DC10");
			
			Room room1 = new Room();
			room1.setFormationCenter(formationCenter);
			room1.setCapacity(102);
			room1.setName("10DC12");

			Room room2 = new Room();
			room2.setFormationCenter(formationCenter);
			room2.setCapacity(101);
			room2.setName("10DC11");
			
			formationCenter.getRooms().add(room);
			formationCenter.getRooms().add(room1);
			formationCenter.getRooms().add(room2);
			
			
			formationCenterDAO.create(formationCenter);

			DAOManager.commitTransaction();
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
	}

	private static final void initFolderManager(File root, String packageName,
			HashSet<String> rightSet) throws EMagineException {
		RightDAO rightDAO = DAOManager.getInstance().getRightDAO();

		for (File file : root.listFiles()) {
			String fullPackName = packageName + "." + file.getName();
			// Lists all files
			if (file.isDirectory()) {
				// If it's a directory, treat it as new package
				initFolderManager(file, fullPackName, rightSet);
			} else {
				// else, treat it as new class
				if (fullPackName.endsWith("Manager.java")) {
					System.out.println(fullPackName);
					String className = fullPackName.substring(0, fullPackName
							.indexOf(".java"));
					// It's a manager
					Class<?> clazz;
					try {
						clazz = Class.forName(className);
						// Iterate on each method
						for (Method method : clazz.getMethods()) {
							MustHaveRights methodRights = method
									.getAnnotation(MustHaveRights.class);
							MustHaveRights classRights = clazz
									.getAnnotation(MustHaveRights.class);

							if (methodRights == null && classRights != null) {
								// Adds the class rights if no method rights are specified
								// The checked rights become : [class right].[methode name] for each class right
								for (String classRight : classRights.value()) {
									addRight(rightSet, classRight + "." + method.getName(), rightDAO);
								}
							} else if (methodRights != null) {
								// Else, we take the rights as they are listed
								// in the anotation for that method
								for (String rightName : methodRights.value()) {
									addRight(rightSet, rightName, rightDAO);
								}
							}
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private static final void addRight(HashSet<String> rightSet, String fullRightName, RightDAO rightDAO) throws EMagineException {
		if (!rightSet.contains(fullRightName)) {
			rightDAO.create(new Right(fullRightName));
			rightSet.add(fullRightName);
			System.out.println(".\t=> "+fullRightName);
		}
	}
}