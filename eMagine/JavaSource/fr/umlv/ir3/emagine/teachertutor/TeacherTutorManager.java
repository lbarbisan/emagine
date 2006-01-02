package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.EMagineException;

public interface TeacherTutorManager {

	/**
	 * Adds an apprentice to a tutor
	 * @param apprentice apprentice to add
	 * @param teacherTutor teacher to add apprentice
	 * @throws EMagineException if apprentice already exist
	 */
	public abstract void addApprentice(Apprentice apprentice,
			TeacherTutor teacherTutor) throws EMagineException;

}