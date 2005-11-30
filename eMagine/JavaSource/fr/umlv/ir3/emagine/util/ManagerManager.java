package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.event.EventManager;
import fr.umlv.ir3.emagine.extraction.ExtractionManager;
import fr.umlv.ir3.emagine.extraction.mailings.MailingListManager;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingTypeManager;
import fr.umlv.ir3.emagine.extraction.massmailing.MassMailingManager;
import fr.umlv.ir3.emagine.firm.FirmManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;

public class ManagerManager {
	private static ManagerManager instance;
	
	private UserManager userManager = new UserManager();
	private ProfileManager profileManager = new ProfileManager();
	private ExtractionManager extractionManager = new ExtractionManager();
	private TeacherTutorManager teacherTutorManager = new TeacherTutorManager();
	private FirmManager firmManager = new FirmManager();
	private EventManager eventManager = new EventManager();
	private MailingListManager mailingListManager = new MailingListManager();
	private MailingTypeManager mailingTypeManager = new MailingTypeManager();
	private MassMailingManager massMailingManager = new MassMailingManager();
	
	public static ManagerManager getInstance() {
		if (instance == null) {
			instance = new ManagerManager();
		}
		return instance;
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
	
}
