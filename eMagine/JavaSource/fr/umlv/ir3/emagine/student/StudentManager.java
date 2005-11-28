package fr.umlv.ir3.emagine.student;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class StudentManager extends BaseManager<Student, StudentDAO> {

	/**
	 * Lists students, using the given search parameters
	 * @param studentSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Student> getStudents(StudentSearchParam studentSearchParam) throws EMagineException {
		return getDAO().getStudents(studentSearchParam);
	}

	@Override
	protected StudentDAO getDAO() {
		return DAOManager.getInstance().getStudentDAO();
	}
}
