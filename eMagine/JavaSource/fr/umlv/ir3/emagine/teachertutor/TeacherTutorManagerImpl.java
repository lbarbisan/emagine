package fr.umlv.ir3.emagine.teachertutor;

import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManagerImpl;

public class TeacherTutorManagerImpl extends BaseManagerImpl<TeacherTutor, TeacherTutorDAO> implements TeacherTutorManager{
	
	/**
	 * @see fr.umlv.ir3.emagine.teachertutor.TeacherTutorManager#addApprentice(fr.umlv.ir3.emagine.apprentice.Apprentice, fr.umlv.ir3.emagine.teachertutor.TeacherTutor)
	 */
	public void addApprentice(Apprentice apprentice , TeacherTutor teacherTutor) throws EMagineException {
		DAOManager.beginTransaction();
		try {
			List<Apprentice> apprentices = teacherTutor.getApprentice();
			apprentices.add(apprentice);
			update(teacherTutor);
			DAOManager.commitTransaction();
		} catch (EMagineException e) {
			DAOManager.rollBackTransaction();
			throw e;
		}
	}
	
	@Override
	protected TeacherTutorDAO getDAO() {
			DAOManager instance = DAOManager.getInstance();
			return instance.getTeacherTutorDAO();
	}	
}
