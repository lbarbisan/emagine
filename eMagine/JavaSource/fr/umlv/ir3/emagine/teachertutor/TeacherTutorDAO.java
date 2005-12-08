package fr.umlv.ir3.emagine.teachertutor;

import java.util.Collection;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class TeacherTutorDAO extends BaseDAO<TeacherTutor> {
	
	public void delete(Collection<TeacherTutor> teacherTutor) throws EMagineException {
		// TODO HibernateUserDAO.deleteTeachersTutor()
	}

	public Extractable extract(TeacherTutorSearchParam teacherTutorSearchParam, Iterable<String> selectedColumns) {
		// TODO TeacherTutorDAO.extract()
		return null;
	}
}
