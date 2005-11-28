package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.entreprise.EntrepriseManager;
import fr.umlv.ir3.emagine.extraction.ExtractionManager;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager;
import fr.umlv.ir3.emagine.user.UserManager;
import fr.umlv.ir3.emagine.user.profile.ProfileManager;

public class ManagerManager {
	private static ManagerManager instance;
	
	private UserManager userManager = new UserManager();
	private ProfileManager profileManager = new ProfileManager();
	private ExtractionManager extractionManager = new ExtractionManager();
	private TeacherTutorManager teacherTutorManager = new TeacherTutorManager();
	private EntrepriseManager entrepriseManager = new EntrepriseManager();

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

	public EntrepriseManager getEntrepriseManager() {
		return entrepriseManager;
	}
}
