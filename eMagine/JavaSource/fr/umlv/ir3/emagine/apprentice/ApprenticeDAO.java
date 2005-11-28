package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import fr.umlv.ir3.emagine.apprentice.Apprentice;
import fr.umlv.ir3.emagine.apprentice.ApprenticeSearchParam;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class ApprenticeDAO extends BaseDAO<Apprentice> {

	@Override
	public Apprentice retrieve(long id) {
	  	return (Apprentice) HibernateUtils.getSession().load(Apprentice.class, id);
	}

	public List<Apprentice> getApprentices(ApprenticeSearchParam apprenticeSearchParam) throws EMagineException {
		// TODO ApprenticeDAO.getApprentices()
		return null;
	}

	public void deleteApprentices(Collection<Apprentice> apprentices) throws EMagineException {
		// TODO ApprenticeDAO.deleteApprentices()
	}
}
