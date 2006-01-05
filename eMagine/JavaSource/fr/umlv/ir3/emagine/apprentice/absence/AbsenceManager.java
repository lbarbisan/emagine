package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.modification.EditableManager;
import fr.umlv.ir3.emagine.security.MustHaveRights;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseEntity;

/**
 * Interface for Abscence Manager
 * @author eMagine Team
 *
 */
public interface AbsenceManager extends EditableManager<Absence, AbsenceDAO> {

	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParams
	 * @return Abscence's List
	 * @throws EMagineException if an SQLException occures
	 */
	public abstract List<Absence> find(Collection<Apprentice> apprentices,
			AbsenceSearchParams absenceSearchParams) throws EMagineException;

	/**
	 * @param newEntity Entity to Update
	 * @throws EMagineException if an error occures
	 * @see fr.umlv.ir3.emagine.util.base.BaseManager#update(BaseEntity)
	 */
	@MustHaveRights("absence.update")
	public void update(Absence newEntity) throws EMagineException;
}