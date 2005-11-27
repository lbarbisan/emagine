package fr.umlv.ir3.emagine.student;

import java.util.List;

import fr.umlv.ir3.emagine.student.Student;
import fr.umlv.ir3.emagine.student.StudentDAO;
import fr.umlv.ir3.emagine.student.StudentSearchParam;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class StudentManager {
	/**
	 * Creates a new student with the given Student
	 * @param student the student to create
	 * @throws EMagineException if the login already exists, or if there is an SQL exception
	 */
	public void createStudent(Student student) throws EMagineException {
		// Create the new Student
		DAOManager.beginTransaction();
		try {
			// TODO : createStudent : vérif login unique
			getDAO().create(student);
			// TODO : createStudent : Mail
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Updates the given Student
	 * @param student the student to update
	 * @throws EMagineException if the login already exists for another id, or if there is an SQL exception
	 */
	public void updateStudent(Student student) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : modifyStudent : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
			// TODO : modifyStudent : vérif login unique
			getDAO().update(student);
			// TODO : modifyStudent : Mail
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Deletes a list of students.
	 * @param students The list of students to be deleted
	 * @param force Force the deletion, even if one student is connected
	 * @throws EMagineException if one of those students doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public void deleteStudents(List<Student> students, boolean force) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : gérer les student connectés, notamment, supprimer ceux qui sont pas connectés, et question sur les autres ? ...
			getDAO().deleteStudents(students);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Lists students, using the given search parameters
	 * @param studentSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Student> getStudents(StudentSearchParam studentSearchParam) throws EMagineException {
		return getDAO().getStudents(studentSearchParam);
	}

	private StudentDAO getDAO() {
		return DAOManager.getInstance().getStudentDAO();
	}
}
