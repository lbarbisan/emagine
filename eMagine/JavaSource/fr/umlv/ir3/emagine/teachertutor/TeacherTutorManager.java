package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class TeacherTutorManager extends BaseManager<TeacherTutor, TeacherTutorDAO>{

	/**
	 * Delete a list of teacher tutor.
	 * @param teacherTutor The list of teacher tutor to be deleted
	 * @throws EMagineException if one of those users doesn't exist in the database, or if one of them is connected and the force switch is false
	 */
	@Override
	public void delete(TeacherTutor entity) throws EMagineException {
		// TODO TeacherTutorManager.delete()
		super.delete(entity);
	}

	/**
	 * Create a new teacher tutor with the given TeacherTutor
	 * @param teacherTutor the teacher tutor to create
	 * @throws EMagineException if there is an SQL exception, or if the teacher tutor already exist
	 */
	@Override
	public void create(TeacherTutor teacherTutor)
			throws EMagineException {
		// TODO : createTeacherTutor :  teacherTutorUnique
		super.create(teacherTutor);
	}

	/**
	 * Update the given TeacherTutor
	 * @param teacherTutor the teacher tutor to update
	 * @throws EMagineException if there is an SQL exception, or if the teacher tutor already exist
	 */
	@Override
	public void update(TeacherTutor teacherTutor)
			throws EMagineException {
		//TODO : updateTeacherTutor : vérif droits. si pas droits de modif, enregistrer patch + envoyer event
		//TODO : updateTeacherTutor :  createTeacherTutor :  teacherTutorUnique
		super.update(teacherTutor);
	}

	
	/**
	 * Return a list of Tutors witch match with teacherTutorSearchParam criteria.
	 * @param teacherTutorSearchParam Criteria
	 * @return list of tutor corresponding to the criteria
	 * @throws EMagineException if criteria are incorrect, or if query in database failed
	 */
	public List<TeacherTutor> find(
			TeacherTutorSearchParam teacherTutorSearchParam)
			throws EMagineException {
		TeacherTutorDAO dao = getDAO();
		List<TeacherTutor> teachersTutor = dao.getTeachersTutor(teacherTutorSearchParam);
		return teachersTutor;
	}
	
	/**
	 * Add a apprentice to a tutor
	 * @param apprentice apprentice to add
	 * @param teacherTutor teacher to add apprentice
	 * @throws EMagineException if apprentice already exist
	 */
	public void addApprentice(Apprentice apprentice , TeacherTutor teacherTutor) throws EMagineException {
		//FIXME: Si l'étudiant existe déjà ?
		//FIXME: Est-ce necessaire d'affecter à l'étudiant , puis d'affecter au tuteur?
		apprentice.setTeacherTutor(teacherTutor);
		List<Apprentice> newApprentice = teacherTutor.getApprentice();
		newApprentice.add(apprentice);
		update(teacherTutor);
	}

	@Override
	protected TeacherTutorDAO getDAO() {
			DAOManager instance = DAOManager.getInstance();
			return instance.getTeacherTutorDAO();
	}

	@Override
	public TeacherTutor retrieve(long id) throws EMagineException {
		TeacherTutorDAO dao = getDAO();
		return dao.retrieve(TeacherTutor.class, id);
	}
}
