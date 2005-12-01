package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class AbsenceDAO extends BaseDAO<Absence> {
	
	/**
	 * Lists absences, using the given search parameters
	 * @param absenceSearchParam
	 * @return
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(AbsenceSearchParam absenceSearchParam) {
		// TODO AbsenceDAO.getAbsences()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}
}
