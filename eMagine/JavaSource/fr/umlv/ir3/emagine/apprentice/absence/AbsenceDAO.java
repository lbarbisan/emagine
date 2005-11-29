package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class AbsenceDAO extends BaseDAO<Absence> {
	@Override
	public Absence retrieve(long id) throws EMagineException {
		return (Absence) HibernateUtils.getSession().load(Absence.class, id);
	}

	public List<Absence> getAbsences(AbsenceSearchParam absenceSearchParam) {
		// TODO AbsenceDAO.getAbsences()
		return null;
	}
}
