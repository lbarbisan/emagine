package fr.umlv.ir3.emagine.ressource;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;

import fr.umlv.ir3.emagine.apprentice.CountryEnum;
import fr.umlv.ir3.emagine.apprentice.DepartmentEnum;
import fr.umlv.ir3.emagine.apprentice.SexEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.CourseOptionEnum;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenter;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.Room;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutor;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorDAO;
import fr.umlv.ir3.emagine.user.User;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.Profile;
import fr.umlv.ir3.emagine.user.profile.Right;
import fr.umlv.ir3.emagine.util.Address;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class InitDB {

	/**
	 * @param args
	 * @throws EMagineException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, EMagineException {
		InitializeUser();
		createUsers(1,40);
		createTeachers(1,40);
		InitializeFormationCenter();
		
	}
	
	public static void InitializeUser()
	{
		
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		DAOManager.beginTransaction();
		
		try {
		
		Profile administrateur = new Profile();
		administrateur.setDescription("Droit des utilisateurs");
		administrateur.setName("Administrateur");
		administrateur.addRights(new Right("user.create"));
		administrateur.addRights(new Right("user.update"));
		administrateur.addRights(new Right("user.delete"));
		
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
		user.setEmail("a@gmail.com");
		user.setFirstName("a");
		user.setLastName("a");
		user.setLogin("a");
		user.setPassword("");
		user.setProfile(visitor);
		userDAO.create(user);
		
		DAOManager.commitTransaction();	
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}

	}
	
	private static void createUsers(int start, int length)
	{
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		FormationCenterDAO formationCenterDAO = DAOManager.getInstance().getFormationCenterDAO();
		DAOManager.beginTransaction();
		
		try {
		
		Profile CFA = new Profile();
		CFA.setDescription("Droit des utilisateurs");
		CFA.setName("CFA");
		
		for(int index =start;index<length;index++)
		{
			User user = new User();
			user.setEmail("user" + index + "@gmail.com");
			user.setFirstName("LastName" + index);
			user.setLastName("FirstName" + index);
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
	
	private static void createTeachers(int start, int length)
	{
		UserDAO userDAO = DAOManager.getInstance().getUserDAO();
		TeacherTutorDAO teacherTutorDAO = DAOManager.getInstance().getTeacherTutorDAO();
		DAOManager.beginTransaction();
		
		try {
		
		
		for(int index =start;index<length;index++)
		{
			TeacherTutor teacher = new TeacherTutor();
				
			teacher.setAddressPersonnal(createAddress(index*2) );
			teacher.setAddressProfessional(createAddress(index));
			teacher.setBirthdayCity("Paris" + index);
			teacher.setBirthdayCountry(CountryEnum.values()[index]);
			teacher.setBirthdayDate(Calendar.getInstance().getTime());
			teacher.setBirthdayDepartment(DepartmentEnum.values()[index]);
			teacher.setEmail("mail" + index + "@gmail.com");
			teacher.setFax("9" + index *100);
			teacher.setFirstName("LastName" + index);
			teacher.setLastName("FirstName" + index);
			teacher.setMobilePhone("709870");
			teacher.setSex(SexEnum.values()[index%2]);
			teacherTutorDAO.create(teacher);
		}
		
		DAOManager.commitTransaction();	
		} catch (EMagineException emagine) {
			// TODO EMagineException.e1 Not Implemented
			emagine.printStackTrace();
		}
		
	}
	
	private static Address createAddress(int index)
	{
		Address address =  new Address();
		address.setCity("City" + index);
		address.setCountry(CountryEnum.values()[index]);
		address.setDepartment(DepartmentEnum.values()[index]);
		address.setPostalCode("99" + index);
		address.setStreet(index + "rue de la java");
		
		return address;
	}
	
	private  static void InitializeFormationCenter()
	{
		FormationCenterDAO formationCenterDAO = DAOManager.getInstance().getFormationCenterDAO();
		DAOManager.beginTransaction();
		try {
			
			ArrayList<Room> list = new ArrayList<Room>();
			
			Room room = new Room();
			room.setCapacity(100);
			room.setName("10DC10");
			
			list.add(room);
			
			room = new Room();
			room.setCapacity(102);
			room.setName("10DC11");
			
			list.add(room);
			
			room = new Room();
			room.setCapacity(101);
			room.setName("10DC11");
			
			list.add(room);
			
			FormationCenter formationCenter = new FormationCenter();
			formationCenter.setAddress(new Address());
			formationCenter.setName("Lyon");
			formationCenter.setPhone("0180808080");
			formationCenter.setRooms(list);
			
			formationCenterDAO.create(formationCenter);
			
			DAOManager.commitTransaction();	
			} catch (EMagineException emagine) {
				// TODO EMagineException.e1 Not Implemented
				emagine.printStackTrace();
			}
	}
}