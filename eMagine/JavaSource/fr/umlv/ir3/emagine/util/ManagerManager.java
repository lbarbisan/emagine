package fr.umlv.ir3.emagine.util;

import java.util.Hashtable;
import java.util.Map;

import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManagerImpl;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManagerImpl;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManager;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterManagerImpl;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomManager;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomManagerImpl;
import fr.umlv.ir3.emagine.event.EventManager;
import fr.umlv.ir3.emagine.event.EventManagerImpl;
import fr.umlv.ir3.emagine.extraction.ExtractionManager;
import fr.umlv.ir3.emagine.extraction.ExtractionManagerImpl;
import fr.umlv.ir3.emagine.extraction.mailings.MailingListManager;
import fr.umlv.ir3.emagine.extraction.mailings.MailingListManagerImpl;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingTypeManager;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingTypeManagerImpl;
import fr.umlv.ir3.emagine.extraction.massmailing.MassMailingManager;
import fr.umlv.ir3.emagine.extraction.massmailing.MassMailingManagerImpl;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.FirmManagerImpl;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.security.SecurityProxyFactory;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManagerImpl;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.UserManagerImpl;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManagerImpl;
import fr.umlv.ir3.emagine.user.profile.RightManager;
import fr.umlv.ir3.emagine.user.profile.RightManagerImpl;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;
import fr.umlv.ir3.emagine.util.base.BaseManager;


public class ManagerManager {
	private static ManagerManager instance;
	
	private Map<String, BaseManager> managers = new Hashtable<String, BaseManager>();
	
	private UserManager userManager;
	private ProfileManager profileManager;
	private ExtractionManager extractionManager;
	private TeacherTutorManager teacherTutorManager;
	private FirmManager firmManager;
	private EventManager eventManager;
	private MailingListManager mailingListManager;
	private MailingTypeManager mailingTypeManager;
	private MassMailingManager massMailingManager;
	private CandidateManager candidateManager;
	private ApprenticeManager apprenticeManager;
	private EditableManager editableManager;
	private AbsenceManager absenceManager;
	private FormationCenterManager formationCenterManager;
	private RightManager rightManager;
	private RoomManager roomManager;
	private EmagineEnumManager emagineEnumManager;
	
	/**
	 * @return Returns the baseEditableManager.
	 */
	public EditableManager getEditableManager() {
		return editableManager;
	}

	/**
	 * @param baseEditableManager The baseEditableManager to set.
	 */
	public void setEditableManager(EditableManager editableManager) {
		this.editableManager = editableManager;
	}
	
	private <E extends BaseEntity, D extends BaseDAO<E>, M extends BaseManager<E, D>> M addManager(M manager) {
		managers.put(manager.getClass().getName(), manager);
		return SecurityProxyFactory.createProxy(manager);
	}
	
	public BaseManager getManager(String className) {
		return managers.get(className);
	}

	public ManagerManager() {
		
		//FIXME: remetre la ligne commenttée
		//userManager = SecurityProxyFactory.getProxy(new UserManagerImpl());
//		userManager = new UserManagerImpl();
//		
//		profileManager = new ProfileManagerImpl();
//		extractionManager = new ExtractionManagerImpl();
//		teacherTutorManager = new TeacherTutorManagerImpl();
//		firmManager = new FirmManagerImpl();
//		eventManager = new EventManagerImpl();
//		mailingListManager = new MailingListManagerImpl();
//		mailingTypeManager = new MailingTypeManagerImpl();
//		massMailingManager = new MassMailingManagerImpl();
//		candidateManager = new CandidateManagerImpl();
//		apprenticeManager = new ApprenticeManagerImpl();
//		editableManager = new EditableManagerImpl();

		userManager = addManager(new UserManagerImpl());
		
		profileManager = addManager(new ProfileManagerImpl());
		extractionManager = addManager(new ExtractionManagerImpl());
		teacherTutorManager = addManager(new TeacherTutorManagerImpl());
		firmManager = addManager(new FirmManagerImpl());
		eventManager = addManager(new EventManagerImpl());
		mailingListManager = addManager(new MailingListManagerImpl());
		mailingTypeManager = addManager(new MailingTypeManagerImpl());
		massMailingManager = addManager(new MassMailingManagerImpl());
		candidateManager = addManager(new CandidateManagerImpl());
		apprenticeManager = addManager(new ApprenticeManagerImpl());
		formationCenterManager = addManager(new FormationCenterManagerImpl());
		rightManager = addManager(new RightManagerImpl());
		roomManager = addManager(new RoomManagerImpl());
		emagineEnumManager = new EmagineEnumManagerImpl();	// No rights on that manager

		editableManager = new EditableManagerImpl();

		//FIXME: remetre la ligne commenttée
		//absenceManager = SecurityProxyFactory.getProxy(new AbsenceManagerImpl());
	}
	
	/**
	 * Gets the singleton of the ManagerManager.
	 * @return the singleton of the ManagerManager
	 */
	public static ManagerManager getInstance() {
		if (instance == null) {
			instance = new ManagerManager();
		}
		return instance;
	}
	
	public CandidateManager getCandidateManager() {
		return candidateManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public ProfileManager getProfileManager() {
		return profileManager;
	}

	public ExtractionManager getExtractionManager() {
		return extractionManager;
	}
	
	public TeacherTutorManager getTeacherTutorManager() {
		return teacherTutorManager;
	}

	public FirmManager getFirmManager() {
		return firmManager;
	}

	public EventManager getEventManager() {
		return eventManager;
	}
	
	public MailingListManager getMailingListManager() {
		return mailingListManager;
	}
	
	public MailingTypeManager getMailingTypeManager()
	{
		return mailingTypeManager;
	}
	
	public MassMailingManager getMassMailingManager()
	{
		return massMailingManager;	
	}
	public ApprenticeManager getApprenticeManager() {
		return apprenticeManager;
	}

	public AbsenceManager getAbsenceManager() {
		return absenceManager;
	}
	/**
	 * @return Returns the formationCenterManager.
	 */
	public FormationCenterManager getFormationCenterManager() {
		return formationCenterManager;
	}

	public RightManager getRightManager() {
		return rightManager;
	}

	public EmagineEnumManager getEmagineEnumManager() {
		return emagineEnumManager;
	}
	
	public RoomManager getRoomManager() {
		return roomManager;
	}
	
}
