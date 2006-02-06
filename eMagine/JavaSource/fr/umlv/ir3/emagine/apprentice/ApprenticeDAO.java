package fr.umlv.ir3.emagine.apprentice;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import fr.umlv.ir3.emagine.apprentice.candidate.Candidate;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class ApprenticeDAO extends BaseDAO<Apprentice> {

	public Apprentice Integrate(Candidate candidate) throws EMagineException
	{
		Apprentice apprentice ;
		try {
			Session session = HibernateUtils.getSession();
			apprentice = new Apprentice(candidate);
			session.save(apprentice);
		} catch (HibernateException exception) {
			throw new EMagineException("exception.ApprenticeDAO.create", exception);
		}
		return apprentice;
		
	}
}
