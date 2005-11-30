package fr.umlv.ir3.emagine.extraction.massmailing;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class MassMailingManager extends BaseEditableManager<MassMailing, MassMailingDAO> {

	@Override
	public MassMailing retrieve(long id) throws EMagineException {
		return getDAO().retrieve(MassMailing.class, id);
	}

	@Override
	protected BaseDAO<MassMailing> getDAO() {
		ManagerManager.getInstance().getMailingTypeManager();
		return null;
	}

	//TODO : Use case « Créer une mailing-list »
	//TODO : Use case « Modifier une mailing-list »
	//TODO : Use case « Ajouter un membre à une mailing-list »
	//TODO : Use case « Supprimer des mailing-list »
	//TODO : Use case « Visualiser une mailing-list »
	//TODO : Use case « Visualiser la liste des mailing-list »
	//TODO : Use case « Générer mailing »


}
