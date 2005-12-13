package fr.umlv.ir3.emagine.firm.actor;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
/**
 * The class is used to manage relation with database and core class TeacherTutor.
 * @author eMagine
 */
public class EngineerTutorDAO extends BaseDAO<EngineerTutor> {
	
	public List<EngineerTutor> find(EngineerTutorSearchParams teacherTutorSearchParams) throws EMagineException {
		return super.find(teacherTutorSearchParams);
	}
}
