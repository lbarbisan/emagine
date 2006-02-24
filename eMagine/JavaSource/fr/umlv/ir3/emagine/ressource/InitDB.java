package fr.umlv.ir3.emagine.ressource;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Principal;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ResourceBundle;

import servletunit.HttpSessionSimulator;
import servletunit.ServletContextSimulator;
import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.GroupEnum;
import fr.umlv.ir3.emagine.apprentice.JustificationEnum;
import fr.umlv.ir3.emagine.apprentice.LevelEntryEnum;
import fr.umlv.ir3.emagine.apprentice.NationalityEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.absence.Absence;
import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.ContactEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.extraction.ExtractionEntity;
import fr.umlv.ir3.emagine.extraction.ExtractionGroup;
import fr.umlv.ir3.emagine.extraction.ExtractionProperty;
import fr.umlv.ir3.emagine.firm.Firm;
import fr.umlv.ir3.emagine.firm.FirmDAO;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager;
import fr.umlv.ir3.emagine.firm.actor.FirmActor;
import fr.umlv.ir3.emagine.firm.actor.FirmActorDAO;
import fr.umlv.ir3.emagine.security.EmaginePrincipal;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.security.SessionManager;
import fr.umlv.ir3.emagine.security.SessionManagerConfig;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorDAO;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.user.profile.RightDAO;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.Bundles;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.EmagineEnumDAO;
import fr.umlv.ir3.emagine.util.ManagerManager;

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
		Object[] objects = { 1, 4 };
		for (Method method : InitEnums.class.getDeclaredMethods()) {
			if (method.getName().startsWith("create")) {
				method.invoke(null, objects);
			}
		}

		SessionManager.getInstance().initThreadLocal(
				new SessionManagerConfig() {
					public javax.servlet.http.HttpSession getSession() {
						return new HttpSessionSimulator(
								new ServletContextSimulator());
					};

					public fr.umlv.ir3.emagine.security.EmaginePrincipal getUserPrincipal()
							throws fr.umlv.ir3.emagine.security.SecurityFilterNotCorrectlyInitializedException {
						return new EmaginePrincipal() {
							public String getName() {
								return "InitDB";
							};

							public java.security.Principal getPrincipal() {
								return new Principal() {
									public String getName() {
										return "InitDB";
									};
								};
							};

							public User getUser() {
								User user = new User();
								user.setLogin("InitDB");
								return user;
							};
						};
					};

				});

		
		initializeUser();
		createUsers(1, 4);
		createTeachers(1, 4);
		initializeFormationCenter();
		initializeCandidate(1, 4);
		initializeFirm(1, 4);
		initializeApprentice(1, 4);
		initializeEngineerTutor(1,2);
		initializeExtractionEntities();
	}

	private static final void initializeExtractionEntities()
			throws EMagineException {
		DAOManager.beginTransaction();

		HashSet<String> uniqKeys = new HashSet<String>();
		final ResourceBundle extractionBundle = Bundles.getExtractionBundle();
		for (final Enumeration<String> keys = extractionBundle.getKeys(); keys
				.hasMoreElements();) {
			// Get the name of the extraction entity
			String extractionEntityName = keys.nextElement().split("\\.")[1];
			// Don't get the groups and already parsed entities
			if (!"group".equals(extractionEntityName) && !uniqKeys.contains(extractionEntityName)) {
				uniqKeys.add(extractionEntityName);
				// Get the properties of that extraction entity
				LinkedList<String> properties = new LinkedList<String>();
				// Create the extraction entity
				ExtractionEntity extractionEntity = new ExtractionEntity();
				extractionEntity.setName(extractionEntityName);
				// Create the extraction properties and attach them to that extraction entity
				for (String property : properties) {
					// Create the extraction properties
					final ExtractionProperty extractionProperty = new ExtractionProperty(
							property);
					extractionProperty.setExtractionEntity(extractionEntity);
					extractionEntity.getProperties().add(extractionProperty);
				}
				// Create the extraction entity
				DAOManager.getInstance().getExtractionEntityDAO().create(
						extractionEntity);
				System.out.println("ExtractionEntity created : "+extractionEntityName);
			}
		}
		DAOManager.commitTransaction();
	}
	
	private static void addRecursiveEntityProperties(ExtractionGroup group, Collection<String> entityProperties) {
		for (String property : group.getProperties()) {
			entityProperties.add(property);
		}
		for (ExtractionGroup childGroup : group.getGroups()) {
			addRecursiveEntityProperties(childGroup, entityProperties);
		}
	}

	private static final void initializeCandidate(int start, int end)
			throws EMagineException {

		CandidateDAO candidateDAO = DAOManager.getInstance().getCandidateDAO();
		DAOManager.beginTransaction();

		for (int index = start; index < end; index++) {
			/*
			 * Contact contact = new Contact();
			 * contact.setAddressPersonnal(createAddress(index));
			 * contact.setBirthdayCity("Ville" + index);
			 * contact.setBirthdayCountry((CountryEnum)
			 * InitEnums.getEmagineEnum("Country " + index, CountryEnum.class));
			 * contact.setBirthdayDate(new Date());
			 * contact.setBirthdayDepartment((DepartmentEnum)
			 * InitEnums.getEmagineEnum("Department " + index,
			 * DepartmentEnum.class)); contact.setEmail("contact" + index +
			 * "@gmail.com"); contact.setFirstName("LastNameContact" + index);
			 * contact.setLastName("FirstNameContact" + index);
			 * contact.setFax("01012" + index);
			 * contact.setMobilePhone("32902930" + index);
			 * contact.setNationality((NationalityEnum)
			 * InitEnums.getEmagineEnum("Nationality " + index,
			 * NationalityEnum.class)); contact.setPhone("8798798" + index);
			 * contact.setSex((SexEnum) InitEnums.getEmagineEnum("Male",
			 * SexEnum.class));
			 */
			Candidate candidate = new Candidate();
			candidate.setAccepted(false);
			candidate.setAddressPersonnal(createAddress(index));
			candidate.setBirthdayCity("Ville" + index);
			candidate.setBirthdayCountry((CountryEnum) InitEnums
					.getEmagineEnum("Country " + index, CountryEnum.class));
			candidate.setBirthdayDate(new Date());
			candidate
					.setBirthdayDepartment((DepartmentEnum) InitEnums
							.getEmagineEnum("Department " + index,
									DepartmentEnum.class));
			// candidate.setContactOriginIG2K(contact);
			candidate.setContactOriginIG2K((ContactEnum) InitEnums
					.getEmagineEnum("jpo", ContactEnum.class));
			candidate.setCourseOption((CourseOptionEnum) InitEnums
					.getEmagineEnum("CourseOption " + index,
							CourseOptionEnum.class));
			// candidate.setEmail(contact.getEmail());
			candidate.setEmail("contact" + index + "@gmail.com");
			candidate.setEntryLevel((LevelEntryEnum) InitEnums.getEmagineEnum(
					"Level " + index, LevelEntryEnum.class));
			candidate.setFax("70987987" + index);
			candidate.setFirstName("FirstNameContact" + index);
			// candidate.setFirstName(contact.getFirstName() + "Candidate");
			// candidate.setFormationCenter()
			// candidate.setLastDiploma()
			candidate.setLastName("LastNameContact" + index);
			// candidate.setLastName(contact.getLastName() + "Candiate");
			// candidate.setLastSection()
			candidate.setMobilePhone("87695468" + index);
			candidate.setNationality((NationalityEnum) InitEnums
					.getEmagineEnum("Nationality " + index,
							NationalityEnum.class));
			// candidate.setNationality(contact.getNationality());
			// candidate.setOtherFormation()
			candidate.setPhone("098098" + index);
			// candidate.setProfessionFather()
			// candidate.setProfessionMother()
			candidateDAO.create(candidate);

			// candidate.setSex(contact.getSex());
			candidate.setSex((SexEnum) InitEnums.getEmagineEnum("Homme",
					SexEnum.class));
		}

		DAOManager.commitTransaction();
	}

	private static final void initializeApprentice(int start, int end)
			throws EMagineException {

		ApprenticeManager apprenticeManager = ManagerManager.getInstance()
				.getApprenticeManager();
		CandidateDAO candidateDAO = DAOManager.getInstance().getCandidateDAO();

		DAOManager.beginTransaction();

		for (int index = start; index < end; index++) {
			Candidate candidate = candidateDAO.findAll().get(index - start);
			Apprentice apprentice  = apprenticeManager.integrate(candidate);
			
			EmagineEnumDAO emagineEnumDAO =  DAOManager.getInstance().getEmagineEnumDAO();
			JustificationEnum justification = (JustificationEnum) emagineEnumDAO.find("NJ", JustificationEnum.class);
			
			apprentice.setCourseOption((CourseOptionEnum) emagineEnumDAO.find(CourseOptionEnum.IR, CourseOptionEnum.class));
			apprentice.setGroup((GroupEnum) emagineEnumDAO.find(GroupEnum.G1A, GroupEnum.class));
			
			Absence absence =  new Absence(justification ,"c'est pas bien...", new Date(), new Date());
			absence.setApprentice(apprentice);
			apprentice.getAbsences().add(absence);
		}

		DAOManager.commitTransaction();
	}
	
	private static final void initializeEngineerTutor(int start, int end) throws EMagineException {
		
		EngineerTutorManager engineerTutorManager = ManagerManager.getInstance().getEngineerTutorManager();
		
		FirmActorDAO firmActorDAO = DAOManager.getInstance().getFirmActorDAO();
		
		DAOManager.beginTransaction();
		
		for (int index = start; index < end; index++) {
			FirmActor candidate = firmActorDAO.findAll().get(index - start);
			engineerTutorManager.becomeEngineerTutor(candidate);
		}		
		DAOManager.commitTransaction();
	}

	public static void initializeUser() {

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

			administrateur.setRights(DAOManager.getInstance().getRightDAO()
					.findAll());

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
				teacher.setBirthdayCountry((CountryEnum) InitEnums
						.getEmagineEnum("Country 1", CountryEnum.class));
				teacher.setBirthdayDate(Calendar.getInstance().getTime());
				teacher.setBirthdayDepartment((DepartmentEnum) InitEnums
						.getEmagineEnum("Department 1", DepartmentEnum.class));
				teacher.setEmail("mail" + index + "@gmail.com");
				teacher.setFax("9" + index * 100);
				teacher.setFirstName("LastNameTeachers" + index);
				teacher.setLastName("FirstNameTeachers" + index);
				teacher.setMobilePhone("709870");
				teacher.setPhone("12003" + index);
				teacher.setSex((SexEnum) InitEnums.getEmagineEnum("Male",
						SexEnum.class));
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
		address.setCity("City " + index);
		address.setPostalCode("77178");
		address.setCountry((CountryEnum) InitEnums.getEmagineEnum("Country 1", CountryEnum.class));
		address.setDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department 1", DepartmentEnum.class));
		address.setPostalCode("9310" + index);
		address.setStreet(index + " rue de la java");

		return address;
	}

	private static void initializeFirm(int start, int length) {

		FirmDAO firmDAO = DAOManager.getInstance().getFirmDAO();

		DAOManager.beginTransaction();
		try {
			for (int index = start; index < length; index++) {
				FirmActor firmActor = createFrimActor(index*10+1);
				FirmActor firmActor2= createFrimActor(index*10+2);
				FirmActor firmActor3 = createFrimActor(index*10+3);
				
				Firm firm = new Firm();
				firm.setAddress(createAddress(index));
				firm.setEmail("FirmMail@domain" + index + ".com");
				firm.setFax("+33123456 " + index);
				firm.setName("FirmName " + index);
				firm.setPhone("+33123456" + index);
				firm.setWebSite("http://www" + index + "domain.com");
				firm.getFirmActors().add(firmActor);
				firm.getFirmActors().add(firmActor2);
				firm.getFirmActors().add(firmActor3);
				
				firmActor.setFirm(firm);
				firmActor2.setFirm(firm);
				firmActor3.setFirm(firm);
				
				firmDAO.create(firm);
			}

			DAOManager.commitTransaction();
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
	}

	/**
	 * Create FirmActor
	 * @param index
	 * @return
	 */
	private static FirmActor createFrimActor(int index) {
		FirmActor firmActor = new FirmActor();
		try {
			firmActor.setAddressPersonnal(createAddress(index));
			firmActor.setAddressProfessional(createAddress(index));
			firmActor.setBirthdayCity("BirthdayCity " + index);
			firmActor.setBirthdayCountry((CountryEnum) InitEnums.getEmagineEnum("Country " + index, CountryEnum.class));
			firmActor.setBirthdayDate(new Date());
			firmActor.setBirthdayDepartment((DepartmentEnum) InitEnums.getEmagineEnum("Department " + index, DepartmentEnum.class));
			firmActor.setEmail("mail@domain.com");
			firmActor.setFax("+33123456" + index);
			firmActor.setFirstName("FirstNameActorFirm" + index);
			firmActor.setLastName("LastNameActorFirm" + index);
			firmActor.setMobilePhone("+33123456" + index);
			firmActor.setNationality((NationalityEnum) InitEnums.getEmagineEnum("Nationality " + index,	NationalityEnum.class));
			firmActor.setPhone("+33123456" + index);
			firmActor.setSex((SexEnum) InitEnums.getEmagineEnum("Homme", SexEnum.class));

		} catch (EMagineException e) {
			// TODO EMagineException.e Not Implemented
			e.printStackTrace();
		}

		return firmActor;
	}
	
	

	private static void initializeFormationCenter() {
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
								// Adds the class rights if no method rights are
								// specified
								// The checked rights become : [class
								// right].[methode name] for each class right
								for (String classRight : classRights.value()) {
									addRight(rightSet, classRight + "."
											+ method.getName(), rightDAO);
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

	private static final void addRight(HashSet<String> rightSet,
			String fullRightName, RightDAO rightDAO) throws EMagineException {
		if (!rightSet.contains(fullRightName)) {
			rightDAO.create(new Right(fullRightName));
			rightSet.add(fullRightName);
			System.out.println(".\t=> " + fullRightName);
		}
	}
}