package fr.umlv.ir3.emagine.firm;

import java.util.List;

import org.hibernate.Query;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmDAO extends BaseDAO<Firm> {

	/**
	 * Return the list of firm which have the specified course option
	 * @param id
	 * @return
	 */
	public List<Firm> findFirmForCourseOptionId(long id)
	{
		StringBuilder s = new StringBuilder();
		s.append("select distinct job.firm from Job job where job.cursus.id like :id");
	
		Query query = HibernateUtils.getSession().createQuery(s.toString());
		query.setParameter("id" , id );
		
		return query.list();
	}
}
