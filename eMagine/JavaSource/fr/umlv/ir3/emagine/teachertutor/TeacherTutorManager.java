package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.Extractable;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class TeacherTutorManager extends BaseManagerImpl<TeacherTutor, TeacherTutorDAO>{
	
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
