package fr.umlv.ir3.emagine.student;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.student.StudentSearchParam;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class StudentDAO extends BaseDAO<Student> {

	@Override
	public Student retrieve(long id) {
	  	return (Student) HibernateUtils.getSession().load(Student.class, id);
	}

	public List<Student> getStudents(StudentSearchParam studentSearchParam) throws EMagineException {
		// TODO StudentDAO.getStudents()
		return null;
	}

	public void deleteStudents(Collection<Student> students) throws EMagineException {
		// TODO StudentDAO.deleteStudents()
	}
}
