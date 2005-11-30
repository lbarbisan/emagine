package fr.umlv.ir3.emagine.util;

import fr.umlv.ir3.emagine.apprentice.ApprenticeDAO;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomDAO;
import fr.umlv.ir3.emagine.event.EventDAO;
import fr.umlv.ir3.emagine.extraction.ExtractionDAO;
import fr.umlv.ir3.emagine.firm.FirmDAO;
import fr.umlv.ir3.emagine.firm.JobDAO;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorDAO;
import fr.umlv.ir3.emagine.firm.actor.FirmActorDAO;
import fr.umlv.ir3.emagine.modification.ModificationDAO;
import fr.umlv.ir3.emagine.statistic.StatisticDAO;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorDAO;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.ProfileDAO;

public class DAOManager {
	private static DAOManager instance;
	
	private UserDAO userDAO = new UserDAO();
	private ProfileDAO profileDAO = new ProfileDAO();
	private ModificationDAO modificationDAO = new ModificationDAO();
	private TeacherTutorDAO teacherTutorDAO = new TeacherTutorDAO();
	private EngineerTutorDAO engineerTutorDAO = new EngineerTutorDAO();
	private ApprenticeDAO apprenticeDAO = new ApprenticeDAO();
	private FirmDAO firmDAO = new FirmDAO();
	private FirmActorDAO firmActorDAO = new FirmActorDAO();
	private JobDAO jobDAO = new JobDAO();
	private EventDAO eventDAO = new EventDAO();
	private StatisticDAO statisticDAO = new StatisticDAO();
	private AbsenceDAO absenceDAO = new AbsenceDAO();
	private CandidateDAO candidateDAO = new CandidateDAO();
	private ExtractionDAO extractionDAO = new ExtractionDAO();
	private FormationCenterDAO formationCenterDAO = new FormationCenterDAO();
	private RoomDAO roomDAO = new RoomDAO();

	
	public ModificationDAO getModificationDAO() {
		return modificationDAO;
	}
	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public TeacherTutorDAO getTeacherTutorDAO() {
		return teacherTutorDAO;
	}
	public EngineerTutorDAO getEngineerTutorDAO() {
		return engineerTutorDAO;
	}
	public ApprenticeDAO getApprenticeDAO() {
		return apprenticeDAO;
	}
	public FirmDAO getFirmDAO() {
		return firmDAO;
	}
	public FirmActorDAO getFirmActorDAO() {
		return firmActorDAO;
	}
	public JobDAO getJobDAO() {
		return jobDAO;
	}
	public EventDAO getEventDAO() {
		return eventDAO;
	}
	public StatisticDAO getStatisticDAO() {
		return statisticDAO;
	}
	public AbsenceDAO getAbsenceDAO() {
		return absenceDAO;
	}
	public CandidateDAO getCandidateDAO() {
		return candidateDAO;
	}
	public ExtractionDAO getExtractionDAO() {
		return extractionDAO;
	}
	public FormationCenterDAO getFormationCenterDAO() {
		return formationCenterDAO;
	}
	public RoomDAO getRoomDAO() {
		return roomDAO;
	}
	public static DAOManager getInstance() {
		if (instance == null) {
			instance = new DAOManager();
		}
		return instance;
	}
	
    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#beginTransaction()
     */
    public static void beginTransaction() {
    	HibernateUtils.beginTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#commitTransaction()
     */
    public static void commitTransaction() {
    	HibernateUtils.commitTransaction();
    }

    /**
     * @see fr.umlv.ir3.emagine.util.DAOManager#rollBackTransaction()
     */
    public static void rollBackTransaction() {
    	HibernateUtils.rollbackTransaction();
        
    }

    /**
     * Close the session, flush the hibernate cache, commit the last uncommited objects
     *
     */
	public static void closeSession() {
		HibernateUtils.closeSession();
	}
}
