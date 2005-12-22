package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager;
import fr.umlv.ir3.emagine.event.EventManager;
import fr.umlv.ir3.emagine.extraction.ExtractionManager;
import fr.umlv.ir3.emagine.extraction.mailings.MailingListManager;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingTypeManager;
import fr.umlv.ir3.emagine.extraction.massmailing.MassMailingManager;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.modification.EditableManagerImpl;
import fr.umlv.ir3.emagine.security.SecurityProxy;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.UserManagerImpl;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;

public class ManagerManager {
	private static ManagerManager instance;
	
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

	/**
	 * 
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public ManagerManager() throws EMagineException {
		userManager = new SecurityProxy<UserManager>(new UserManagerImpl()).getProxy();
		profileManager = new ProfileManager();
		extractionManager = new ExtractionManager();
		teacherTutorManager = new TeacherTutorManager();
		firmManager = new FirmManager();
		eventManager = new EventManager();
		mailingListManager = new MailingListManager();
		mailingTypeManager = new MailingTypeManager();
		massMailingManager = new MassMailingManager();
		candidateManager = new CandidateManager();
		apprenticeManager = new ApprenticeManager();
		editableManager = new EditableManagerImpl();
	}
	
	/**
	 * Gets the singleton of the ManagerManager.
	 * @return the singleton of the ManagerManager
	 * @throws EMagineException if the security filter has not been initialized
	 */
	public static ManagerManager getInstance() throws EMagineException {
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
	
}
