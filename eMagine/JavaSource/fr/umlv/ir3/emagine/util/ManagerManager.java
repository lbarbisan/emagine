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
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.firm.FirmManagerImpl;
import fr.umlv.ir3.emagine.firm.JobManager;
import fr.umlv.ir3.emagine.firm.JobManagerImpl;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorManager;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorManagerImpl;
import fr.umlv.ir3.emagine.firm.actor.FirmActorManager;
import fr.umlv.ir3.emagine.firm.actor.FirmActorManagerImpl;
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
	private EngineerTutorManager engineerTutorManager;
	private FirmManager firmManager;
	private JobManager jobManager;
	private EventManager eventManager;
	private MailingListManager mailingListManager;
	private MailingTypeManager mailingTypeManager;
	private CandidateManager candidateManager;
	private ApprenticeManager apprenticeManager;
	private EditableManager editableManager;
	private AbsenceManager absenceManager;
	private FormationCenterManager formationCenterManager;
	private RightManager rightManager;
	private RoomManager roomManager;
	private FirmActorManager firmActorManager;
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
		engineerTutorManager = addManager(new EngineerTutorManagerImpl());
		firmManager = addManager(new FirmManagerImpl());
		eventManager = addManager(new EventManagerImpl());
		mailingListManager = addManager(new MailingListManagerImpl());
		mailingTypeManager = addManager(new MailingTypeManagerImpl());
		candidateManager = addManager(new CandidateManagerImpl());
		apprenticeManager = addManager(new ApprenticeManagerImpl());
		formationCenterManager = addManager(new FormationCenterManagerImpl());
		rightManager = addManager(new RightManagerImpl());
		roomManager = addManager(new RoomManagerImpl());
		emagineEnumManager = new EmagineEnumManagerImpl();	// No rights on that manager
		editableManager = new EditableManagerImpl();
		jobManager = new JobManagerImpl();
		firmActorManager = new FirmActorManagerImpl();
		
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

	/**
	 * @return Returns the absenceManager.
	 */
	public AbsenceManager getAbsenceManager() {
		return absenceManager;
	}

	/**
	 * @return Returns the apprenticeManager.
	 */
	public ApprenticeManager getApprenticeManager() {
		return apprenticeManager;
	}

	/**
	 * @return Returns the candidateManager.
	 */
	public CandidateManager getCandidateManager() {
		return candidateManager;
	}

	/**
	 * @return Returns the emagineEnumManager.
	 */
	public EmagineEnumManager getEmagineEnumManager() {
		return emagineEnumManager;
	}

	/**
	 * @return Returns the engineerTutorManager.
	 */
	public EngineerTutorManager getEngineerTutorManager() {
		return engineerTutorManager;
	}

	/**
	 * @return Returns the eventManager.
	 */
	public EventManager getEventManager() {
		return eventManager;
	}

	/**
	 * @return Returns the extractionManager.
	 */
	public ExtractionManager getExtractionManager() {
		return extractionManager;
	}

	/**
	 * @return Returns the firmActorManager.
	 */
	public FirmActorManager getFirmActorManager() {
		return firmActorManager;
	}

	/**
	 * @return Returns the firmManager.
	 */
	public FirmManager getFirmManager() {
		return firmManager;
	}

	/**
	 * @return Returns the formationCenterManager.
	 */
	public FormationCenterManager getFormationCenterManager() {
		return formationCenterManager;
	}

	/**
	 * @return Returns the jobManager.
	 */
	public JobManager getJobManager() {
		return jobManager;
	}

	/**
	 * @return Returns the mailingListManager.
	 */
	public MailingListManager getMailingListManager() {
		return mailingListManager;
	}

	/**
	 * @return Returns the mailingTypeManager.
	 */
	public MailingTypeManager getMailingTypeManager() {
		return mailingTypeManager;
	}

	/**
	 * @return Returns the managers.
	 */
	public Map<String, BaseManager> getManagers() {
		return managers;
	}

	/**
	 * @return Returns the profileManager.
	 */
	public ProfileManager getProfileManager() {
		return profileManager;
	}

	/**
	 * @return Returns the rightManager.
	 */
	public RightManager getRightManager() {
		return rightManager;
	}

	/**
	 * @return Returns the roomManager.
	 */
	public RoomManager getRoomManager() {
		return roomManager;
	}

	/**
	 * @return Returns the teacherTutorManager.
	 */
	public TeacherTutorManager getTeacherTutorManager() {
		return teacherTutorManager;
	}

	/**
	 * @return Returns the userManager.
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param instance The instance to set.
	 */
	public static void setInstance(ManagerManager instance) {
		ManagerManager.instance = instance;
	}
	
	


}
