package fr.umlv.ir3.emagine.firm;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class FirmDAO extends BaseDAO<Firm> {
	@Override
	public Firm retrieve(long id) {
	  	return (Firm) HibernateUtils.getSession().load(Firm.class, id);
	}

	public List<Firm> getFirms(FirmSearchParam firmSearchParam) throws EMagineException {
		// TODO FirmDAO.getFirms()
		return null;
	}
}