package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.util.search.SearchParam;

/**
 * Represent the criteria for searching a teacher tutor
 * @author eMagine team
 */
public interface TeacherTutorSearchParam extends SearchParam {
	/**
	 * @return the firstName of teacher tutor
	 */
	public String getFirstName();
	/**
	 * @return the LastName of teacher tutor
	 */
	public String getLastName();
}
