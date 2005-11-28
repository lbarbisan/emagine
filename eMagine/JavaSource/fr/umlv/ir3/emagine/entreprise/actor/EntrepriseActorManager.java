package fr.umlv.ir3.emagine.entreprise.actor;

import fr.umlv.ir3.emagine.util.DAOManager;
import fr.umlv.ir3.emagine.util.base.BaseManager;

public class EntrepriseActorManager extends BaseManager<EntrepriseActor, EntrepriseActorDAO> {

	@Override
	protected EntrepriseActorDAO getDAO() {
		return DAOManager.getInstance().getEntrepriseActorDAO();
	}
}