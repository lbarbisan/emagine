package fr.umlv.ir3.emagine.firm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmDAO extends BaseDAO<Firm> {
	
	public List<Firm> find(FirmSearchParam firmSearchParam) throws EMagineException {
		// TODO FirmDAO.getFirms()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}
}
