package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class EngineerTutorDAO extends BaseDAO<EngineerTutor> {
	
	public List<EngineerTutor> find(EngineerTutorSearchParams teacherTutorSearchParams) throws EMagineException {
		return super.find(teacherTutorSearchParams);
	}

	public EngineerTutor becomeEngineerTutor(FirmActor firmActor) throws EMagineException {
		EngineerTutor engineerTutor ;
		try {
			Session session = HibernateUtils.getSession();
			engineerTutor = new EngineerTutor(firmActor);
			session.save(engineerTutor);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.ApprenticeDAO.create", exception);
		}
		return engineerTutor;
	}
}
