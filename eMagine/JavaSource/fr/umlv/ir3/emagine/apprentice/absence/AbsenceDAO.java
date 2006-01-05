package fr.umlv.ir3.emagine.apprentice.absence;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

/**
 * DAO Use for access to Abscence Data from Database
 * @author eMagineTeam
 */
public class AbsenceDAO extends BaseDAO<Absence> {
	
	/**
	 * Lists absences for a list of Apprentice, between 2 dates
	 * @param apprentices selected apprentices
	 * @param absenceSearchParams
	 * @return the abscence list, if no elements are found return an empty list
	 * @throws EMagineException if an SQLException occures
	 */
	@SuppressWarnings("unchecked")
	public List<Absence> find(Collection<Apprentice> apprentices, AbsenceSearchParams absenceSearchParams) throws EMagineException {
		
		String queryString;

		queryString = "From Abscence a where (a.Apprentice in : apprentices) " ;
		
		for (String field : absenceSearchParams.getFields()) {
			// TODO : Optimiser avec des StringBuffer
			queryString = queryString + " and " + field + " like :" + field;
		}

		Query query = HibernateUtils.getSession().createQuery(queryString);
		for (String field : absenceSearchParams.getFields()) {
			Object value = absenceSearchParams.getField(field);
			query.setParameter(field, value);
		}
		return query.list();
	}
}
