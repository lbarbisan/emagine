package fr.umlv.ir3.emagine.teachertutor;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;

@MustHaveRights("teacherTutor")
public interface TeacherTutorManager extends EditableManager<TeacherTutor, TeacherTutorDAO>  {

	/**
	 * Adds an apprentice to a tutor
	 * @param apprentice apprentice to add
	 * @param teacherTutor teacher to add apprentice
	 * @throws EMagineException if apprentice already exist
	 */
	@MustHaveRights("teacherTutor.update")
	public abstract void addApprentice(Apprentice apprentice,
			TeacherTutor teacherTutor) throws EMagineException;

}