package fr.umlv.ir3.emagine.apprentice;

import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;

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

	/**
	 * Excludes the given apprentice
	 * @param apprentice
	 * @throws EMagineException throw if the apprentice doesn't exist or if an SQLException occures
	 */
	public void excludeApprentice(Apprentice apprentice) throws EMagineException {
		try {
			apprentice.setExcluded(true);
			HibernateUtils.getSession().saveOrUpdate(apprentice);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.apprenticeDAO.excludeApprentice");
		}
	}

	/**
	 * Move up the given apprentices in the upper courseOption level
	 * @param apprentice
	 * @throws EMagineException throw if an apprentice doesn't exist or if an SQLException occures
	 */
	public void moveUpApprentice(Collection<Apprentice> apprentices) throws EMagineException {
		try {
			for (Apprentice apprentice : apprentices) {
				// TODO : voir une meilleur implémentation que ce foreach
				apprentice.setYear(apprentice.getYear() + 1);
				HibernateUtils.getSession().saveOrUpdate(apprentice);
			}
		} catch (HibernateException exception) {
			throw new EMagineException("exception.apprenticeDAO.moveUpApprentice");
		}
	}
}
