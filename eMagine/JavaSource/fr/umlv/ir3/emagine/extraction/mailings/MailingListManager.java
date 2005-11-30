package fr.umlv.ir3.emagine.extraction.mailings;

import fr.umlv.ir3.emagine.util.EMagineException;
import fr.umlv.ir3.emagine.util.ManagerManager;
import fr.umlv.ir3.emagine.util.base.BaseDAO;
import fr.umlv.ir3.emagine.util.base.BaseEditableManager;

public class MailingListManager extends BaseEditableManager<MailingList, MailingListDAO> {

	@Override
	public MailingList retrieve(long id) throws EMagineException {
		// TODO MailingListManager.retrieve()
		return null;
	}

	@Override
	protected BaseDAO<MailingList> getDAO() {
		ManagerManager.getInstance().getMailingListManager();
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
