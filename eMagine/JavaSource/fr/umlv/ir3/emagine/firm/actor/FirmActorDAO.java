package fr.umlv.ir3.emagine.firm.actor;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmActorDAO extends BaseDAO<FirmActor> {
	
	/**
	 * Return true if  FirmActor is already a EngineerTutor
	 * @param firmActor firmActor to test
	 * @return Return true if  FirmActor is already a EngineerTutor
	 */
	public boolean isEngineerTutor(FirmActor firmActor)
	{
		Criteria criteria = HibernateUtils.getSession().createCriteria(EngineerTutor.class);
		Criterion criterion= Expression.eq("id", firmActor.getId());
		criteria.add(criterion);
		
		if(criteria.uniqueResult()!=null)
			return true;
		return false;
	}
}
