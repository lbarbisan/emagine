package fr.umlv.ir3.emagine.apprentice;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class ApprenticeDAO extends BaseDAO<Apprentice> {

	public List<Apprentice> find(ApprenticeSearchParam apprenticeSearchParam) throws EMagineException {
		// TODO ApprenticeDAO.getApprentices()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}
}
