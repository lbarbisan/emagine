package fr.umlv.ir3.emagine.firm;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmDAO extends BaseDAO<Firm> {
	
	/**
	 * Lists the firms which want one or more Apprentice of the given courseOption. The list is ordered and tries to put the most asking firms on top.
	 * @param rapprochementSearchParam
	 * @return
	 */
	public List<Firm> find(RapprochementSearchParam rapprochementSearchParam) {
		// TODO FirmDAO.find()
		String query = "";
		Session session = HibernateUtils.getSession();
		Query createQuery = session.createQuery(query);
		return createQuery.list();
	}
}
