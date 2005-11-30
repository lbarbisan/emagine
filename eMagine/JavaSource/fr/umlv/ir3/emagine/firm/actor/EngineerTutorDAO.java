package fr.umlv.ir3.emagine.firm.actor;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class EngineerTutorDAO extends BaseDAO<EngineerTutor> {
	
	public List<EngineerTutor> getTeachersTutor(EngineerTutorSearchParam teacherTutorSearchParam) throws EMagineException {
		// TODO HibernateUserDAO.getTeachersTutor()
		return null;
	}

	public void deleteTeachersTutor(Collection<EngineerTutor> teacherTutor) throws EMagineException {
		// TODO HibernateUserDAO.deleteTeachersTutor()
	}
}
