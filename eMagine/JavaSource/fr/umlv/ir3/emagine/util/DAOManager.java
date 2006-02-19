package fr.umlv.ir3.emagine.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;

import fr.umlv.ir3.emagine.apprentice.ApprenticeDAO;
import fr.umlv.ir3.emagine.apprentice.absence.AbsenceDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.CandidateDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.examcenter.FormationCenterDAO;
import fr.umlv.ir3.emagine.apprentice.candidate.room.RoomDAO;
import fr.umlv.ir3.emagine.event.EventDAO;
import fr.umlv.ir3.emagine.extraction.ExtractionConfigEntityDAO;
import fr.umlv.ir3.emagine.extraction.ExtractionEntityDAO;
import fr.umlv.ir3.emagine.extraction.mailings.MailingListDAO;
import fr.umlv.ir3.emagine.extraction.mailstype.MailingTypeDAO;
import fr.umlv.ir3.emagine.firm.FirmDAO;
import fr.umlv.ir3.emagine.firm.JobDAO;
import fr.umlv.ir3.emagine.firm.actor.EngineerTutorDAO;
import fr.umlv.ir3.emagine.firm.actor.FirmActorDAO;
import fr.umlv.ir3.emagine.modification.EditableDAO;
import fr.umlv.ir3.emagine.statistic.StatisticDAO;
import fr.umlv.ir3.emagine.teachertutor.TeacherTutorDAO;
import fr.umlv.ir3.emagine.user.UserDAO;
import fr.umlv.ir3.emagine.user.profile.ProfileDAO;
import fr.umlv.ir3.emagine.user.profile.RightDAO;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

public class DAOManager {
	private static DAOManager instance;
	private final static Log log = LogFactory.getLog(DAOManager.class);

	private UserDAO userDAO = new UserDAO();

	private ProfileDAO profileDAO = new ProfileDAO();

	private EditableDAO modificationDAO = new EditableDAO();

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

	private ExtractionEntityDAO extractionEntityDAO = new ExtractionEntityDAO();

	private FormationCenterDAO formationCenterDAO = new FormationCenterDAO();

	private RoomDAO roomDAO = new RoomDAO();

	private RightDAO rightDAO = new RightDAO();

	private MailingListDAO mailingListDAO = new MailingListDAO();

	private MailingTypeDAO mailingTypeDAO = new MailingTypeDAO();

	private EmagineEnumDAO emagineEnumDAO = new EmagineEnumDAO();
	
	private ExtractionConfigEntityDAO extractionConfigEntityDAO = new ExtractionConfigEntityDAO();

	private BaseDAO<BaseEntity> baseDAO = new BaseDAO<BaseEntity>();

	public BaseDAO<BaseEntity> getBaseDAO() {
		return baseDAO;
	}

	public RightDAO getRightDAO() {
		return rightDAO;
	}

	public EditableDAO getModificationDAO() {
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

	public ExtractionEntityDAO getExtractionEntityDAO() {
		return extractionEntityDAO;
	}

	public FormationCenterDAO getFormationCenterDAO() {
		return formationCenterDAO;
	}

	public RoomDAO getRoomDAO() {
		return roomDAO;
	}

	public MailingListDAO getMailingListDAO() {
		return mailingListDAO;
	}

	public MailingTypeDAO getMailingTypeDAO() {
		return mailingTypeDAO;
	}

	public EmagineEnumDAO getEmagineEnumDAO() {
		return emagineEnumDAO;
	}

	/**
	 * @return Returns the extractionConfigEntityDAO.
	 */
	public ExtractionConfigEntityDAO getExtractionConfigEntityDAO() {
		return extractionConfigEntityDAO;
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
		try {
			HibernateUtils.beginTransaction();
		} catch (HibernateException hibernateException) {
			log.error("beginTransaction failed", hibernateException);
		}
	}
	
	/**
	 * @see fr.umlv.ir3.emagine.util.DAOManager#commitTransaction()
	 */
	public static void commitTransaction() throws EMagineException {
		try {
			HibernateUtils.commitTransaction();
		} catch (HibernateException hibernateException) {
			throw new EMagineException("commitTransaction failed", hibernateException);
		}
	}

	/**
	 * @see fr.umlv.ir3.emagine.util.DAOManager#rollBackTransaction()
	 */
	public static void rollBackTransaction(){
		try {
			HibernateUtils.rollbackTransaction();
		} catch (HibernateException hibernateException) {
			log.error("rollBackTransaction failed", hibernateException);
		}

	}
}
