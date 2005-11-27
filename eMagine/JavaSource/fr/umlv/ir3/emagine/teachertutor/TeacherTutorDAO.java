package fr.umlv.ir3.emagine.teachertutor;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class TeacherTutorDAO extends BaseDAO<TeacherTutor> {
	
	/**
	 * Retrieve a teacher tutor from database
	 * @param id id of teacher tutor
	 * @return return 
	 */
	@Override
	public TeacherTutor retrieve(long id) {
	  	return (TeacherTutor) HibernateUtils.getSession().load(TeacherTutor.class, id);
	}

	public List<TeacherTutor> getTeachersTutor(TeacherTutorSearchParam teacherTutorSearchParam) throws EMagineException {
		// TODO HibernateUserDAO.getTeachersTutor()
		return null;
	}

	public void deleteTeachersTutor(Collection<TeacherTutor> teacherTutor) throws EMagineException {
		// TODO HibernateUserDAO.deleteTeachersTutor()
	}
}
