package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.HibernateUtils;
import fr.umlv.ir3.emagine.util.base.BaseDAO;

public class EntrepriseDAO extends BaseDAO<Entreprise> {
	@Override
	public Entreprise retrieve(long id) {
	  	return (Entreprise) HibernateUtils.getSession().load(Entreprise.class, id);
	}

	public List<Entreprise> getEntreprises(EntrepriseSearchParam entrepriseSearchParam) throws EMagineException {
		// TODO EntrepriseDAO.getEntreprises()
		return null;
	}
}