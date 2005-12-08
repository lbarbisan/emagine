package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class AbsenceDAO extends BaseDAO<Absence> {
	
	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParam
	 * @throws EMagineException if an SQLException occures
	 */
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParam absenceSearchParam) throws EMagineException {
		// TODO AbsenceDAO.find()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}
}
