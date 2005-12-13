package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.util.search.SearchParams;

/**
 * Represent the criteria for searching a teacher tutor
 * @author eMagine team
 */
public interface TeacherTutorSearchParams extends SearchParams {
	/**
	 * @return the firstName of teacher tutor
	 */
	public String getFirstName();
	/**
	 * @return the LastName of teacher tutor
	 */
	public String getLastName();
}
