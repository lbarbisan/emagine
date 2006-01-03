package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;


public interface AbsenceManager extends EditableManager<Absence, AbsenceDAO> {

	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParams
	 * @throws EMagineException if an SQLException occures
	 */
	public abstract List<Absence> find(Collection<Apprentice> apprentices,
			AbsenceSearchParams absenceSearchParams) throws EMagineException;

	@MustHaveRights("absence.update")
	public void update(Absence newEntity) throws EMagineException;
}