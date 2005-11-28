package fr.umlv.ir3.emagine.entreprise;

import java.util.List;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class EntrepriseManager extends BaseManager<Entreprise, EntrepriseDAO> {

	public List<Entreprise> getEntreprises(EntrepriseSearchParam entrepriseSearchParam) throws EMagineException {
		return getDAO().getEntreprises(entrepriseSearchParam);
	}
	
	@Override
	protected EntrepriseDAO getDAO() {
		return DAOManager.getInstance().getEntrepriseDAO();
	}
}