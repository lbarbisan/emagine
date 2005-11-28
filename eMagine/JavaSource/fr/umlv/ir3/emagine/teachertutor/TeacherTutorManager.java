package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;

public class TeacherTutorManager {

	/**
	 * Create a new teacher tutor with the given TeacherTutor
	 * @param teacherTutor the teacher tutor to create
	 * @throws EMagineException if there is an SQL exception, or if the teacher tutor already exist
	 */
	public void createTeacherTutor(TeacherTutor teacherTutor)
			throws EMagineException {
		// Create the new User
		DAOManager.beginTransaction();
		try {
			// TODO : createTeacherTutor :  teacherTutorUnique
			getDAO().create(teacherTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Update the given TeacherTutor
	 * @param teacherTutor the teacher tutor to update
	 * @throws EMagineException if there is an SQL exception, or if the teacher tutor already exist
	 */
	public void updateTeacherTutor(TeacherTutor teacherTutor)
			throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : updateTeacherTutor : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
			// TODO : updateTeacherTutor :  createTeacherTutor :  teacherTutorUnique
			getDAO().update(teacherTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Delete a list of teacher tutor.
	 * @param teacherTutor The list of teacher tutor to be deleted
	 * @throws EMagineException if one of those users doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	public void deleteTeacherTutor(List<TeacherTutor> teacherTutor) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			// TODO : Vérifier que les étudiant associé au tuteur ont bien leur proporiété Teachertutor à null
			getDAO().deleteTeachersTutor(teacherTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}

	/**
	 * Return a list of Tutors witch match with teacherTutorSearchParam criteria.
	 * @param teacherTutorSearchParam Criteria
	 * @return list of tutor corresponding to the criteria
	 * @throws EMagineException if criteria are incorrect, or if query in database failed
	 */
	public List<TeacherTutor> getTeachersTutor(
			TeacherTutorSearchParam teacherTutorSearchParam)
			throws EMagineException {
		return getDAO().getTeachersTutor(teacherTutorSearchParam);
	}
	
	/**
	 * Add a apprentice to a tutor
	 * @param apprentice apprentice to add
	 * @param teacherTutor teacher to add apprentice
	 * @throws EMagineException if apprentice already exist
	 */
	public void addApprenticeToTeachersTutor(Apprentice apprentice , TeacherTutor teacherTutor) throws EMagineException
	{
		//FIXME: Si l'étudiant existe déjà ?
		//FIXME: Est-ce necessaire d'affecter à l'étudiant , puis d'affecter au tuteur?
		apprentice.setTeacherTutor(teacherTutor);
		teacherTutor.getApprentice().add(apprentice);
	}

	private TeacherTutorDAO getDAO() {
		return DAOManager.getInstance().getTeacherTutorDAO();
	}

}
