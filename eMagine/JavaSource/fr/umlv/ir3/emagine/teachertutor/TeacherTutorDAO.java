package fr.umlv.ir3.emagine.teachertutor;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class TeacherTutorDAO extends BaseDAO<TeacherTutor> {
	
	public List<TeacherTutor> find(TeacherTutorSearchParam teacherTutorSearchParam) throws EMagineException {
		// TODO HibernateUserDAO.getTeachersTutor()
		return null;
	}

	public void delete(Collection<TeacherTutor> teacherTutor) throws EMagineException {
		// TODO HibernateUserDAO.deleteTeachersTutor()
	}
}
