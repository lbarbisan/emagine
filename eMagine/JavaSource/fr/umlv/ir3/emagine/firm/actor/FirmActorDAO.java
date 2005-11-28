package fr.umlv.ir3.emagine.firm.actor;

import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmActorDAO extends BaseDAO<FirmActor> {
	@Override
	public FirmActor retrieve(long id) {
	  	return (FirmActor) HibernateUtils.getSession().load(FirmActor.class, id);
	}
}