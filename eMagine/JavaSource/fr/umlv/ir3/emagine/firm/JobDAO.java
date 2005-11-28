package fr.umlv.ir3.emagine.firm;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class JobDAO extends BaseDAO<Job> {
	@Override
	public Job retrieve(long id) {
	  	return (Job) HibernateUtils.getSession().load(Job.class, id);
	}
}