package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.apprentice.ApprenticeManager;
import fr.umlv.ir3.emagine.apprentice.ApprenticeManagerImpl;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceManager;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceManagerImpl;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManager;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateManagerImpl;
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
import fr.umlv.ir3.emagine.security.SecurityProxy;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManagerImpl;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.UserManagerImpl;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManagerImpl;


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
	private AbsenceManager absenceManager;
	
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
		//FIXME: remetre la ligne commenttée
		//userManager = new SecurityProxy<UserManager>(new UserManagerImpl()).getProxy();
		userManager = new UserManagerImpl();
		profileManager = new ProfileManagerImpl();
		extractionManager = new ExtractionManagerImpl();
		teacherTutorManager = new TeacherTutorManagerImpl();
		firmManager = new FirmManagerImpl();
		eventManager = new EventManagerImpl();
		mailingListManager = new MailingListManagerImpl();
		mailingTypeManager = new MailingTypeManagerImpl();
		massMailingManager = new MassMailingManagerImpl();
		candidateManager = new CandidateManagerImpl();
		apprenticeManager = new ApprenticeManagerImpl();
		editableManager = new EditableManagerImpl();
		absenceManager = new SecurityProxy<AbsenceManager>(new AbsenceManagerImpl()).getProxy();
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

	public AbsenceManager getAbsenceManager() {
		return absenceManager;
	}
	
}
