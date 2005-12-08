package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class TeacherTutorManager extends BaseManagerImpl<TeacherTutor, TeacherTutorDAO>{
	
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
		List<TeacherTutor> teachersTutor = dao.find(teacherTutorSearchParam);
		return teachersTutor;
	}
	
	/**
	 * Add a apprentice to a tutor
	 * @param apprentice apprentice to add
	 * @param teacherTutor teacher to add apprentice
	 * @throws EMagineException if apprentice already exist
	 */
	public void addApprentice(Apprentice apprentice , TeacherTutor teacherTutor) throws EMagineException {

		List<Apprentice> apprentices = teacherTutor.getApprentice();
		apprentices.add(apprentice);
		update(teacherTutor);
	}

	/*@Override
	public void update(TeacherTutor teacherTutor) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			TeacherTutorDAO dao =  getDAO();
			dao.update(teacherTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException exception) {
			DAOManager.rollBackTransaction();
			throw exception;
		}
	}*/
	
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
	
	/**
	 * Extracts the selected list, with selected columns (fields) into the selected file format
	 */
	public Extractable extract(TeacherTutorSearchParam teacherTutorSearchParam, Iterable<String> selectedColumns) throws Exception {
		Extractable extractable;
		TeacherTutorDAO dao = getDAO();
		
		extractable = dao.extract(teacherTutorSearchParam, selectedColumns);
		
		return extractable;
	}	
}
